package main.vehicles;

import main.provider.Provider;
import main.user.Licence;
import main.user.User;

public class Scooter extends Vehicle {

    private ScooterLight lights = ScooterLight.Off;
    private int capacityLoss = 4;

    public Scooter(String description, Provider provider) {
	super(description, provider);
    }

    @Override
    public String getType() {
	return "Scooter";
    }

    @Override
    public boolean reserve(User user) {
	if (super.reserve(user)) {
	    if (user.checkLicence(Licence.Scooter)) {
		lights = ScooterLight.Sidelight;
		user.setVehicle(this);
		setUser(user);
		return true;
	    }
	}
	return false;
    }

    @Override
    public boolean start(User user) {
	if (super.start(user)) {
	    if (user.checkLicence(Licence.Scooter)) {
		lights = ScooterLight.On;
		setStart();
		user.setVehicle(this);
		setUser(user);
		return true;
	    }
	}
	return false;
    }

    @Override
    public int getCurrentCharge() {
	int duration = super.getCurrentCharge();
	return duration * getProvider().getScooterFee();
    }

    @Override
    public void end() {
	int duration = getDuration();
	setCapacity(duration * capacityLoss);
	super.end();
	lights = ScooterLight.Off;

    }

    @Override
    public String toString() {
	return super.toString() + ", Lights:" + this.lights.toString();
    }
}
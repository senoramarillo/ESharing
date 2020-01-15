package main.vehicles;

import main.provider.Provider;
import main.user.User;

public class TinyScooter extends Vehicle {

    private LEDColor light = LEDColor.Green;
    private int capacityLoss = 2;

    public TinyScooter(String description, Provider provider) {
	super(description, provider);
    }

    @Override
    public String getType() {
	return "Tiny Scooter";
    }

    @Override
    public boolean reserve(User user) {
	if (super.reserve(user)) {
	    light = LEDColor.Yellow;
	    user.setVehicle(this);
	    setUser(user);
	    return true;
	}
	return false;
    }

    @Override
    public boolean start(User user) {
	if (super.start(user)) {
	    light = LEDColor.Blue;
	    setStart();
	    user.setVehicle(this);
	    setUser(user);
	    return true;
	}
	return false;
    }

    @Override
    public int getCurrentCharge() {
	int duration = super.getCurrentCharge();
	return duration * getProvider().getNoLicenceFee();
    }

    @Override
    public void end() {
	int duration = getDuration();
	setCapacity(duration * capacityLoss);
	super.end();
	light = LEDColor.Green;
	if (getCapacity() < getProvider().getMinCapacity()) {
	    light = LEDColor.Red;
	}
    }

    @Override
    public String toString() {
	return super.toString() + ", Light:" + this.light.toString();
    }
}
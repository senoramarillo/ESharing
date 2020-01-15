package main.vehicles;

import main.provider.Provider;
import main.user.Licence;
import main.user.User;

public class Car extends Vehicle {
    private boolean locked = true;
    private boolean sidelight = false;
    private int capacityLoss = 6;

    public Car(String description, Provider provider) {
	super(description, provider);
    }

    @Override
    public String getType() {
	return "Car";
    }

    @Override
    public boolean reserve(User user) {
	if (super.reserve(user)) {
	    if (user.checkLicence(Licence.Car)) {
		user.setVehicle(this);
		setUser(user);
		sidelight = true;
		return true;
	    }
	}
	return false;
    }

    @Override
    public boolean start(User user) {
	if (super.start(user)) {
	    if (user.checkLicence(Licence.Car)) {
		locked = false;
		sidelight = false;
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
	return duration * getProvider().getCarFee();
    }

    @Override
    public void end() {
	int duration = getDuration();
	setCapacity(duration * capacityLoss);
	super.end();
	locked = true;
	sidelight = false;
    }

    @Override
    public String toString() {
	return super.toString() + ", Sidelight: " + this.sidelight + ", Locked:" + this.locked;
    }
}
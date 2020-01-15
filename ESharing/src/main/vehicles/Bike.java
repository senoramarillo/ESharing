package main.vehicles;

import main.provider.Provider;
import main.user.User;

public class Bike extends Vehicle {
    private boolean locked = true;
    private int capacityLoss = 1;

    public Bike(String description, Provider provider) {
	super(description, provider);
    }

    @Override
    public String getType() {
	return "Bike";
    }

    @Override
    public boolean reserve(User user) {
	if (super.reserve(user)) {
	    user.setVehicle(this);
	    setUser(user);
	    return true;
	}
	return false;
    }

    @Override
    public boolean start(User user) {
	if (super.start(user)) {
	    locked = false;
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
	locked = true;
    }

    @Override
    public String toString() {
	return super.toString() + ", Locked:" + this.locked;
    }
}
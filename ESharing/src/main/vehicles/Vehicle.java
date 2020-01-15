package main.vehicles;

import main.provider.Provider;
import main.user.Rate;
import main.user.User;

public abstract class Vehicle implements IShareable {
    private int id;
    private String description;
    private int capacity = 100;
    private Provider provider;
    private User user;
    private long start;

    private static int nextID = 0;

    public Vehicle(String description, Provider provider) {
	this.id = nextID++;
	this.description = description;
	this.provider = provider;
    }

    private boolean checkConstrains(User user) {
	if (this.capacity < provider.getMinCapacity()) {
	    // not enough capacity
	    return false;
	}
	if (user.getRate() == Rate.Prepaid && user.getBalance() <= 0) {
	    // no deposit for prepaid user
	    return false;
	}
	if (user.getVehicle() != null && !user.getVehicle().equals(this)) {
	    // already assigned to some other vehicle
	    return false;
	}
	return true;
    }

    @Override
    public boolean reserve(User user) {
	if (this.user != null) {
	    // already taken by some other user
	    return false;
	}
	if (!checkConstrains(user)) {
	    return false;
	}
	return true;
    }

    @Override
    public boolean start(User user) {
	if (this.user != null && !user.equals(this.user)) {
	    // reserved by some other user
	    return false;
	}
	if (!checkConstrains(user)) {
	    return false;
	}
	return true;
    }

    protected int getDuration() {
	int duration = (int) ((System.currentTimeMillis() - start) / 1000);
	return duration;
    }

    @Override
    public int getCurrentCharge() {
	if (user == null || start == 0) {
	    return 0;
	}
	return getDuration();
    }

    @Override
    public void end() {
	int charge = getCurrentCharge();
	getUser().charge(charge, this);
	getUser().setVehicle(null);
	setUser(null);
    }

    public int getId() {
	return this.id;
    }

    public String getDescription() {
	return description;
    }

    public Provider getProvider() {
	return provider;
    }

    protected void setUser(User user) {
	this.user = user;
    }

    protected User getUser() {
	return user;
    }

    protected void setStart() {
	start = System.currentTimeMillis();
    }

    public int getCapacity() {
	return capacity;
    }

    protected void setCapacity(int reduced) {
	this.capacity -= reduced;
	if (this.capacity < 0) {
	    this.capacity = 0;
	}
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("[" + this.getId() + "]");
	sb.append(" " + getDescription() + " (" + getType() + "): ");
	sb.append("Provider: " + getProvider().getName() + ", ");
	sb.append("Battery: " + this.getCapacity() + "%, UserID: ");
	if (user == null) {
	    sb.append("none");
	} else {
	    sb.append(user.getId());
	}
	return sb.toString();
    }
}
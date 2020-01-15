package main.user;

import main.vehicles.IShareable;
import main.vehicles.Vehicle;

public class User {

    private int id;
    private String name;
    private int balance;
    private Rate rate;
    private Licence[] licences;
    private IShareable vehicle;

    private static int nextID = 0;

    public User(String name, Rate rate, Licence... licences) {
	this.name = name;
	this.rate = rate;
	this.licences = licences;
	this.id = nextID++;
    }

    /**
     * deposit account
     * 
     * @param value - value in cents
     * @return true if successful
     */
    public boolean deposit(int value) {
	if (value >= 0) {
	    balance += value;
	    return true;
	}
	return false;
    }

    /**
     * charge account
     * 
     * @param value   - value in cents
     * @param vehicle - vehicle which wants to charge
     */
    public void charge(int value, Vehicle vehicle) {
	// Only assigned vehicle is allowed to charge
	if (this.vehicle.equals(vehicle)) {
	    balance -= value;
	}
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public int getBalance() {
	return balance;
    }

    public Rate getRate() {
	return rate;
    }

    public Licence[] getLicences() {
	return licences;
    }

    public boolean checkLicence(Licence licence) {
	for (Licence l : licences) {
	    if (l == licence) {
		return true;
	    }
	}
	return false;
    }

    public IShareable getVehicle() {
	return vehicle;
    }

    public void setVehicle(IShareable vehicle) {
	this.vehicle = vehicle;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(id + ": " + name + " (");
	sb.append(getBalance() + " cents, ");
	sb.append(getRate().toString() + " ");
	sb.append("[");
	for (Licence l : licences) {
	    sb.append(l.toString() + " ");
	}
	sb.append("], ");
	if (getVehicle() != null) {
	    sb.append(getVehicle().toString());
	} else {
	    sb.append("None");
	}
	sb.append(")");
	return sb.toString();
    }
}
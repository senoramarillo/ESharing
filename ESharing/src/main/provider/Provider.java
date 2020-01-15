package main.provider;

public class Provider implements IProvider{

    private String name;
    private int minCapacity;
    private int noLicenceFee;
    private int scooterFee;
    private int carFee;

    public Provider(String name, int minCapacity, int noLicenceFee, int scooterFee, int carFee) {
        this.name = name;
        this.minCapacity = minCapacity;
        this.noLicenceFee = noLicenceFee;
        this.scooterFee = scooterFee;
        this.carFee = carFee;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMinCapacity() {
        return minCapacity;
    }

    @Override
    public int getNoLicenceFee() {
        return noLicenceFee;
    }

    @Override
    public int getScooterFee() {
        return scooterFee;
    }

    @Override
    public int getCarFee() {
        return carFee;
    }
}

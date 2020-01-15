package main.manager;

import Prog1Tools.IOTools;
import main.provider.Provider;
import main.user.Licence;
import main.user.Rate;
import main.user.User;
import main.vehicles.Bike;
import main.vehicles.Car;
import main.vehicles.Scooter;
import main.vehicles.TinyScooter;
import main.vehicles.Vehicle;

public class Manager {

    public static void main(String[] args) {
	Provider a = new Provider("A Bikes", 20, 8, 11, 15);
	Provider b = new Provider("B Mobile", 25, 9, 11, 15);
	Provider c = new Provider("C Share", 30, 9, 9, 15);
	System.out.println("Created 3 providers");

	Vehicle scooter1 = new Scooter("B-BB 1", a);
	Vehicle scooter2 = new Scooter("B-BB 2", b);
	Vehicle tinyScooter = new TinyScooter("B-BB 3", c);
	Bike bike = new Bike("Bike B", a);
	Car car = new Car("B-BB 3", b);

	System.out.println("Created Vehicles:");
	System.out.println(scooter1.toString());
	System.out.println(scooter2.toString());
	System.out.println(tinyScooter.toString());
	System.out.println(bike.toString());

	User user1 = new User("user1", Rate.Standard, Licence.Scooter, Licence.Car);
	User user2 = new User("user2", Rate.Prepaid);
	User user3 = new User("user3", Rate.Standard, Licence.Scooter);
	User user4 = new User("user4", Rate.Standard, Licence.Car);

	System.out.println("Created Users:");
	System.out.println(user1.toString());
	System.out.println(user2.toString());
	System.out.println(user3.toString());
	System.out.println(user4.toString());

	System.out.println("--------------");
	System.out.println("scooter1.reserve(user1):");
	scooter1.reserve(user1);
	System.out.println(user1.toString());

	System.out.println("scooter2.reserve(user1):");
	if (!scooter2.reserve(user1)) {
	    System.out.println("Reservation failed.");
	}
	System.out.println(user1.toString());

	System.out.println("--------------");
	System.out.println("scooter1.start(user1):");
	scooter1.start(user1);
	System.out.println(user1);

	IOTools.readLine("Wait for input...");

	System.out.println("scooter1.getCurrentCharge(): " + scooter1.getCurrentCharge() + "cents");
	System.out.println("scooter1.end():");
	scooter1.end();
	System.out.println(user1.toString());
	System.out.println(scooter1.toString());

	System.out.println("--------------");
	System.out.println("tinyScooter.start(user2):");
	tinyScooter.start(user2);
	System.out.println(user2);

	System.out.println("user2.deposit(1000)");
	user2.deposit(1000);
	System.out.println("tinyScooter.reserve(user2):");
	tinyScooter.reserve(user2);
	System.out.println(user2);
	System.out.println("tinyScooter.start(user2):");
	tinyScooter.start(user2);
	System.out.println(user2);

	IOTools.readLine("Wait for input...");

	System.out.println("tinyScooter.getCurrentCharge(): " + tinyScooter.getCurrentCharge() + "cents");
	System.out.println("tinyScooter.end():");
	tinyScooter.end();
	System.out.println(user2.toString());
	System.out.println(tinyScooter.toString());

	System.out.println("--------------");
	System.out.println("user3.deposit(1000)");
	user3.deposit(1000);
	System.out.println("bike.start(user3):");
	bike.start(user3);
	System.out.println(user3);

	IOTools.readLine("Wait for input...");

	System.out.println("bike.getCurrentCharge(): " + bike.getCurrentCharge() + "cents");
	System.out.println("bike.end():");
	bike.end();
	System.out.println(user3.toString());
	System.out.println(bike.toString());

	System.out.println("--------------");
	System.out.println("car.start(user3)");
	car.start(user3);
	System.out.println(user3);
	System.out.println(car);

	System.out.println("car.reserve(user4)");
	car.reserve(user4);
	System.out.println(user4);
	System.out.println("car.start(user4)");
	car.start(user4);
	System.out.println(user4);

	IOTools.readLine("Wait for input...");

	System.out.println("car.getCurrentCharge(): " + car.getCurrentCharge() + "cents");
	System.out.println("car.end():");
	car.end();
	System.out.println(user4.toString());
	System.out.println(car.toString());
    }
}
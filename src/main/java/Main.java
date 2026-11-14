import facade.RentalFacade;
import observer.Customer;

public class Main {
    public static void main(String[] args) {
        RentalFacade rentalService = new RentalFacade();

        System.out.println("1. Adding vehicles");
        rentalService.addVehicle("car", "Toyota Camry");
        rentalService.addVehicle("car", "Hyundai Accent");
        rentalService.addVehicle("bike", "Stels Navigator");
        rentalService.addVehicle("van", "Hyundai Starex");
        rentalService.addVehicle("plane", "Boeing 737"); // wrong type
        System.out.println();
        System.out.println("All vehicles:");
        rentalService.showVehicles();

        System.out.println();
        System.out.println("2. Alizhan rents a car for 5 hours");
        rentalService.rentVehicle("Alizhan", "Toyota Camry", 5, "hourly", false, true, false);

        System.out.println();
        System.out.println("3. Shyngys rents a van for 3 days");
        rentalService.rentVehicle("Shyngys", "Hyundai Starex", 3, "daily", true, false, true);

        System.out.println();
        System.out.println("4. Darkhan rents a bike for 2 hours");
        rentalService.rentVehicle("Darkhan", "Stels Navigator", 2, "hourly", false, false, false);

        System.out.println();
        System.out.println("5. Darkhan also wants the Camry");
        rentalService.rentVehicle("Darkhan", "Toyota Camry", 1, "daily", false, false, false);
        Customer darkhan = new Customer("Darkhan");
        Customer shyngys = new Customer("Shyngys");
        rentalService.subscribe("Toyota Camry", darkhan);
        rentalService.subscribe("Toyota Camry", shyngys);

        System.out.println();
        System.out.println("6. Alizhan returns the car");
        rentalService.returnVehicle("Toyota Camry");

        System.out.println();
        System.out.println("7. Now Darkhan rents the car");
        rentalService.rentVehicle("Darkhan", "Toyota Camry", 2, "daily", true, true, true);

        System.out.println();
        System.out.println("8. Vehicles at the end");
        rentalService.showVehicles();
    }
}

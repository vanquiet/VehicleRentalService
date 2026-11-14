package builder;

import factory.Vehicle;
import strategy.PricingStrategy;

public class RentalBuilder {
    private String customerName;
    private Vehicle vehicle;
    private int time = 1;
    private PricingStrategy pricing;
    private boolean insurance;
    private boolean gps;
    private boolean childSeat;

    public RentalBuilder setCustomer(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public RentalBuilder setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public RentalBuilder setTime(int time) {
        this.time = time;
        return this;
    }

    public RentalBuilder setPricing(PricingStrategy pricing) {
        this.pricing = pricing;
        return this;
    }

    public RentalBuilder setInsurance(boolean insurance) {
        this.insurance = insurance;
        return this;
    }

    public RentalBuilder setGps(boolean gps) {
        this.gps = gps;
        return this;
    }

    public RentalBuilder setChildSeat(boolean childSeat) {
        this.childSeat = childSeat;
        return this;
    }

    public Rental build() {
        // check that main fields are set
        if (customerName == null || vehicle == null || pricing == null) {
            System.out.println("Rental is not complete!");
            return null;
        }
        if (time <= 0) {
            time = 1;
        }
        return new Rental(customerName, vehicle, time, pricing, insurance, gps, childSeat);
    }
}

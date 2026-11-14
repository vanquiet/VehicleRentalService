package builder;

import factory.Vehicle;
import strategy.PricingStrategy;

public class Rental {
    private String customerName;
    private Vehicle vehicle;
    private int time;
    private PricingStrategy pricing;
    private boolean insurance;
    private boolean gps;
    private boolean childSeat;
    private String description;
    private int totalPrice;

    public Rental(String customerName, Vehicle vehicle, int time, PricingStrategy pricing,
                  boolean insurance, boolean gps, boolean childSeat) {
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.time = time;
        this.pricing = pricing;
        this.insurance = insurance;
        this.gps = gps;
        this.childSeat = childSeat;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getTime() {
        return time;
    }

    public PricingStrategy getPricing() {
        return pricing;
    }

    public boolean hasInsurance() {
        return insurance;
    }

    public boolean hasGps() {
        return gps;
    }

    public boolean hasChildSeat() {
        return childSeat;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void printInfo() {
        System.out.println("Customer: " + customerName);
        System.out.println("Order: " + description);
        System.out.println("Price type: " + pricing.getName());
        System.out.println("Total: " + totalPrice + " tg");
    }
}

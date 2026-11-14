package strategy;

import factory.Vehicle;

public class HourlyPricing implements PricingStrategy {

    @Override
    public int calculatePrice(Vehicle vehicle, int hours) {
        return vehicle.getHourPrice() * hours;
    }

    @Override
    public String getName() {
        return "hourly";
    }

    @Override
    public String getUnit() {
        return "hours";
    }
}

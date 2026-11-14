package strategy;

import factory.Vehicle;

public class DailyPricing implements PricingStrategy {

    @Override
    public int calculatePrice(Vehicle vehicle, int days) {
        return vehicle.getDayPrice() * days;
    }

    @Override
    public String getName() {
        return "daily";
    }

    @Override
    public String getUnit() {
        return "days";
    }
}

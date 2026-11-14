package strategy;

import factory.Vehicle;

public interface PricingStrategy {
    int calculatePrice(Vehicle vehicle, int time);

    String getName();

    String getUnit();
}

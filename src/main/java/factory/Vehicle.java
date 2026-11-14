package factory;

import observer.Observer;
import observer.Subject;

import java.util.ArrayList;

public abstract class Vehicle implements Subject {
    protected String model;
    protected int hourPrice;
    protected int dayPrice;
    protected boolean available = true;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Vehicle(String model, int hourPrice, int dayPrice) {
        this.model = model;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    public abstract String getType();

    public String getModel() {
        return model;
    }

    public int getHourPrice() {
        return hourPrice;
    }

    public int getDayPrice() {
        return dayPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
        // vehicle is free again, tell customers
        if (available) {
            notifyObservers(model + " is free now");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    @Override
    public String toString() {
        String status;
        if (available) {
            status = "available";
        } else {
            status = "rented";
        }
        return model + " (" + getType().toLowerCase() + ") - " + hourPrice + " tg per hour, "
                + dayPrice + " tg per day, " + status;
    }
}
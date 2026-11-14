package factory;

public class Van extends Vehicle {

    public Van(String model) {
        super(model, 5000, 35000);
    }

    @Override
    public String getType() {
        return "Van";
    }
}

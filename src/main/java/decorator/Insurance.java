package decorator;

public class Insurance extends RentalDecorator {

    public Insurance(RentalOption rental) {
        super(rental);
    }

    @Override
    public String getDescription() {
        return rental.getDescription() + " + Insurance";
    }

    @Override
    public int getPrice() {
        return rental.getPrice() + 3000;
    }
}

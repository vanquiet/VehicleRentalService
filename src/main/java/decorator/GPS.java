package decorator;

public class GPS extends RentalDecorator {

    public GPS(RentalOption rental) {
        super(rental);
    }

    @Override
    public String getDescription() {
        return rental.getDescription() + " + GPS";
    }

    @Override
    public int getPrice() {
        return rental.getPrice() + 1500;
    }
}

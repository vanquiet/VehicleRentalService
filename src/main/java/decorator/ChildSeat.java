package decorator;

public class ChildSeat extends RentalDecorator {

    public ChildSeat(RentalOption rental) {
        super(rental);
    }

    @Override
    public String getDescription() {
        return rental.getDescription() + " + Child seat";
    }

    @Override
    public int getPrice() {
        return rental.getPrice() + 1000;
    }
}

package decorator;

public abstract class RentalDecorator implements RentalOption {
    protected RentalOption rental;

    public RentalDecorator(RentalOption rental) {
        this.rental = rental;
    }

    @Override
    public String getDescription() {
        return rental.getDescription();
    }

    @Override
    public int getPrice() {
        return rental.getPrice();
    }
}

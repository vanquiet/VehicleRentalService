package decorator;

public class BasicRental implements RentalOption {
    private String description;
    private int price;

    public BasicRental(String description, int price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getPrice() {
        return price;
    }
}

package model;

import java.time.LocalDate;

public class PerishableProduct extends Product implements Discountable {
    private LocalDate expirationDate;

    public PerishableProduct(String name, int quantity, double price, Category category, double weight, LocalDate _expirationDate)
    {
        super(name, quantity, price, category, weight);
        this.expirationDate = _expirationDate;
    }

    @Override
    public void applyDiscount(double rate)
    {
        SetFinalPrice(getPrice() - (getPrice() * rate / 100 ));
    }

    @Override
    public void printSummary()
    {
        super.printSummary();
        System.out.println(
        " expirationDate : " + 
        expirationDate.toString());
    }

    /**
     * @return LocalDate return the expirationDate
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

}

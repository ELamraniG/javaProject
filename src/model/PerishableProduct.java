package model;
import java.util.Date;
class PerishableProduct extends Product implements Discountable {
    Date expirationDate;
    public void applyDiscount(double rate)
    {
        SetFinalPrice(getPrice() * rate);
    }

}
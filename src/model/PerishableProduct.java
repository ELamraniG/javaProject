package model;
import java.time.LocalDate;
public class PerishableProduct extends Product implements Discountable {
    private LocalDate expirationDate;


    public PerishableProduct(String name,int quantity,double price,Category category,double weight ,LocalDate _expirationDate)
    {
        super(name,quantity,price,category,weight );
        this.expirationDate = _expirationDate;

    }
    @Override
    public void applyDiscount(double rate)
    { SetFinalPrice(getPrice() * rate); }

    @Override
    public void printSummary()
    {
        System.out.println(this.toString() +
        " quantity : " +
        getQuantity() +
        " weight  : " +
        getweight () +
        " expirationDate : " + 
        expirationDate.toString());
     }

}
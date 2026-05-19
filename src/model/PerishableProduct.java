package model;
import java.time.LocalDate;
class PerishableProduct extends Product implements Discountable {
    private LocalDate expirationDate;


    public PerishableProduct(String name,int quantity,double price,Category category,double wight)
    {
        super(name,quantity,price,category,wight);
    }
    @Override
    public void applyDiscount(double rate)
    { SetFinalPrice(getPrice() * rate); }

    @Override
    public void printSummary()
    {
        System.out.println(this.toString() +
        "wight : " +
        getWight() +
        "expirationDate : " + 
        expirationDate.toString());
     }

}
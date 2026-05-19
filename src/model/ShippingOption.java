package model;
import java.time.LocalDate;
public sealed class ShippingOption  permits StandardShipping, ExpressShipping,PickupOnly{
    private double shippingPrice;
    private LocalDate shippingDate = LocalDate.now();
    private LocalDate maxShippingTime; 
    private boolean shipToDoor;
    ShippingOption(double _shippingPrice,LocalDate _maxShippingTime,boolean _shipToDoor)
    {
        this.shipToDoor = _shipToDoor;
        this.shippingPrice = _shippingPrice;
        this.maxShippingTime = _maxShippingTime;
    }
    public void setShippingPrice(double shippingPrice) {    this.shippingPrice = shippingPrice;}
    public double getShippingPrice() { return shippingPrice; }
    public LocalDate getShippingDate() {return shippingDate;}
    public void setShippingDate(LocalDate shippingDate) {        this.shippingDate = shippingDate;}
    public LocalDate getMaxShippingTime() {return maxShippingTime;}
    public void setMaxShippingTime(LocalDate maxShippingTime) {this.maxShippingTime = maxShippingTime;    }

    public static double  adjustedPrice(double price,double weight )
    {
        if (weight  >= 1.0 && weight  < 5.0)
        {
            price += 20;
        }
        else if (weight  >= 5.0 && weight  < 10.0)
        {
            price += 40;
        }
        else if (weight  >= 10.0)
        {
            price += 100;
        }
        return price;
    }
}

final class StandardShipping extends ShippingOption
{    
    StandardShipping(double price,double weight )
    {

        super(adjustedPrice(price,weight ),LocalDate.now().plusMonths(1).plusDays(20),true);
    }
}

final class ExpressShipping extends ShippingOption
{
    ExpressShipping(double price,double weight )
    {
        super(adjustedPrice(price,weight ),LocalDate.now().plusDays(8),true);
    }
}

final class PickupOnly extends ShippingOption
{

    PickupOnly(double price,double weight )
    {
        super(adjustedPrice(price,weight ),LocalDate.now().plusDays(15),false);
    }
}
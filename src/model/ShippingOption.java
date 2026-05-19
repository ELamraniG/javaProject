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

    public double getShippingPrice() {return shippingPrice }
    public void setShippingPrice(double shippingPrice) {    this.shippingPrice = shippingPrice;}
    public double getShippingPrice() { return shippingPrice; }
    public LocalDate getShippingDate() {return shippingDate;}
    public void setShippingDate(LocalDate shippingDate) {        this.shippingDate = shippingDate;}
    public LocalDate getMaxShippingTime() {return maxShippingTime;}
    public void setMaxShippingTime(LocalDate maxShippingTime) {this.maxShippingTime = maxShippingTime;    }
}

final class StandardShipping extends ShippingOption
{    
    StandardShipping(double price,double wight)
    {
        if (wight >= 1.0 && wight < 5.0)
        {
            price += 20;
        }
        else if (wight >= 5.0 && wight < 10.0)
        {
            price += 40;
        }
        else if (wight >= 10.0)
        {
            price += 100;
        }
        super(price,LocalDate.now().plusMonths(1).plusDays(20),true);

    }
}

final class ExpressShipping extends ShippingOption
{
    ExpressShipping(double price,double wight)
    {
        if (wight >= 1.0 && wight < 5.0)
        {
            price += 20;
        }
        else if (wight >= 5.0 && wight < 10.0)
        {
            price += 40;
        }
        else if (wight >= 10.0)
        {
            price += 100;
        }
        super(price,LocalDate.now().plusDays(8),true);
    }
}

final class PickupOnly extends ShippingOption
{

    PickupOnly(double price,double wight)
    {
        if (wight >= 1.0 && wight < 5.0)
        {
            price += 20;
        }
        else if (wight >= 5.0 && wight < 10.0)
        {
            price += 40;
        }
        else if (wight >= 10.0)
        {
            price += 100;
        }
        super(price,LocalDate.now().plusDays(15),false);
    }
}
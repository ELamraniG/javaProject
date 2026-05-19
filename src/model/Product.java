package model;

public class Product extends InventoryItem implements Printable 
{
    private double finalPrice;
    private double weight ;
    private int quantity;
    Product(String name,int _quantity,double price,Category category,double _weight )
    {
        super(name,price,category);
        this.weight  = _weight ;
        finalPrice = price;
        this.quantity = _quantity;
    }


    @Override
    public void printSummary()
    {
        System.out.println(this.toString() + " quantity : " + getQuantity() + " weight  : " + weight );
        return ;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getweight () {
        return weight ;
    }

    public void setweight (double weight ) {
        this.weight  = weight ;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void SetFinalPrice(double _finalPrice) {
        this.finalPrice = _finalPrice;
    }
}
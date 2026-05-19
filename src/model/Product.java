package model;

class Product extends InventoryItem implements Printable 
{
    private double wight;
    private double finalPrice;
    Product(String name,int quantity,double price)
    {
        super(name,price);
    }

    public void printSummary()
    {
        return ;
    }

    public double getWight() {
        return wight;
    }

    public void setWight(double wight) {
        updateDateModified()
        this.wight = wight;
    }

}
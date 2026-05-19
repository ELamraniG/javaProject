package model;

class Product extends InventoryItem implements Printable 
{
    private double finalPrice;
    private double wight;
    Product(String name,int quantity,double price,Category category)
    {
        super(name,price,category);
    }

    @Override
    public void printSummary()
    {
        System.out.println(this.toString() + "wight : " + wight); 
        return ;
    }

    public double getWight() {
        return wight;
    }

    public void setWight(double wight) {
        this.wight = wight;
    }

    public double getFinalPrice() {
        return wight;
    }

    public void SetFinalPrice(double _finalPrice) {
        this.finalPrice = _finalPrice;
    }
}
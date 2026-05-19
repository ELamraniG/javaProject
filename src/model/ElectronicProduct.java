package model;
import java.time.LocalDate;
public class ElectronicProduct extends Product {
    private    LocalDate warrantyDate;
    public LocalDate getWarrantyDate() {return warrantyDate;}
    public void setWarrantyDate(LocalDate warrantyDate) {this.warrantyDate = warrantyDate; }

    public ElectronicProduct(String name,int quantity,double price,Category category,double wight)
    {
        super(name,quantity,price,category,wight);
    }
    @Override
    public void printSummary()
    {
        System.out.println(this.toString() + "wight : " + getWight() + "expirationDate : " + warrantyDate.toString()); 
    }
}
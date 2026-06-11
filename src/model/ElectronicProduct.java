package model;

import java.time.LocalDate;

public class ElectronicProduct extends Product {
    private LocalDate warrantyDate;

    public LocalDate getWarrantyDate() { return warrantyDate; }
    public void setWarrantyDate(LocalDate warrantyDate) { this.warrantyDate = warrantyDate; }

    public ElectronicProduct(String name, int quantity, double price, Category category, double weight, LocalDate _warrantyDate)
    {
        super(name, quantity, price, category, weight);
        this.warrantyDate = _warrantyDate;
    }

    @Override
    public void printSummary()
    {
        super.printSummary();
        System.out.println( " warranty experation date : " + warrantyDate.toString());
    }
}

package model;
import java.time.LocalDate;
public class ElectronicProduct extends Product {
    private    LocalDate warrantyDate;
    public LocalDate getWarrantyDate() {
        return warrantyDate;
    }

    public void setWarrantyDate(LocalDate warrantyDate) {
        this.warrantyDate = warrantyDate;
    }
}
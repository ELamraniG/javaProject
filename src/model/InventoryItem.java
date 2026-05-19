package model;
import java.time.LocalDate;
public abstract class InventoryItem {

    static private int  count;

    static {
        count = 0;
        System.out.println("InventoryItem class loaded, ID counter initialized");
    }
    private int         id = ++count;
    private LocalDate   dateAdded = LocalDate.now();
    private LocalDate   dateModified = LocalDate.now();
    private String      name;
    private double      price;
    private Category    category;

    InventoryItem(String _name,double _price,Category _category)
    {
        this.category = _category;
        this.name = _name;
        this.price = _price;
    } 

    public int getId() {
        return id;
    }
    public LocalDate getDateAdded() {
        return dateAdded;
    }
    public String getName() {
        return name;
    }
    public void setName(String _name) {
        this.name = _name;
        updateDateModified();
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double _price) {
        this.price = _price;
        updateDateModified();
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    public void updateDateModified()
    {
        setDateModified(LocalDate.now());
    }
    
    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", dateAdded=" + dateAdded +
                ", dateModified=" + dateModified +
                '}';
    }

}
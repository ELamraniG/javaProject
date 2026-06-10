package model;

import exception.*;
import java.util.ArrayList;
import java.util.List;

public class Product extends InventoryItem implements Printable 
{
    private double finalPrice;
    protected double weight;
    private int quantity;
    private List<String> tags = new ArrayList<>();

    Product(String name, int _quantity, double price, Category category, double _weight)
    {
        super(name, price, category);
        this.weight = _weight;
        finalPrice = price;
        this.quantity = _quantity;
    }

    @Override
    public void printSummary()
    {
        System.out.println(this.toString() + " quantity : " + getQuantity() + " weight : " + weight);
        return;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getweight() {
        return weight;
    }

    public void setweight(double weight) {
        this.weight = weight;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void SetFinalPrice(double _finalPrice) {
        this.finalPrice = _finalPrice;
    }

    public void setQuantity(int quantity) {
        if (quantity > 10000)
            throw new InvalidQuantityException("quantity too big");
        if (quantity < 0)
            throw new InvalidQuantityException("quantity cannot be negative");
        this.quantity = quantity;
    }

    public List<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        
        tags.add(tag);
    }
    public void addTags(List<String> tag) {
        
        tags.addAll(tags);
    }
}

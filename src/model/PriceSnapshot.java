package model;
import java.time.LocalDate;
public record PriceSnapshot(String productName, double price, LocalDate date)
{
    
}
import model.*;
import util.*;
import java.io.*;
import java.time.LocalDate;
import exception.*;

class Main
{

    public static void main(String args[])
    {
        InventoryItem[] items = new InventoryItem[10];
        for (int i = 0; i < 10; i++)
        {
            if (i < 3)
                items[i] = new ElectronicProduct("Electronics " + i, 5 * i, 5.5 * i, Category.TOOLS, 6.7 + i, LocalDate.now()); 
            else if (i < 6)
                items[i] = new ElectronicProduct("Electronics " + i, 5 * i, 5.5 * i, Category.ELECTRONICS, 6.7 + i, LocalDate.now()); 
            else
                items[i] = new PerishableProduct("PerishableProduct " + i, 5 * i, 5.5 * i, Category.FOOD, 6.7 + i, LocalDate.now()); 
        }
        for (InventoryItem item : items)
        {
            Category cat = item.getCategory();
            String choice = switch (cat)
            {
                case TOOLS -> cat.getDetails() ;
                case FOOD  -> cat.getDetails() ;
                case ELECTRONICS -> cat.getDetails() ;
            };
            System.out.println(choice);
        }
        try 
        {
            findProductByName();
            if (items[1] instanceof Product p)
                p.setQuantity(-5);
        }
        catch (ProductNotFoundException | InvalidQuantityException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            System.out.println("we checked ey");
        }
        try 
        {
            if (items[1] instanceof Product p)
                p.setQuantity(-5);
        }
        catch (InvalidQuantityException e)
        {
            System.out.println(e.getMessage());
        }

        try (FileReader reader = new FileReader("file.txt"))
        {
            int data = reader.read();
            //just a dummy reader stub
        }
        catch (IOException e)
        {
        }
    }
}

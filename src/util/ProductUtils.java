package util;
import model.*;
import java.util.List;
public class ProductUtils
{  
    static void printProduct()
    {

    }

    static double calculateValue()
    {
        return 3.9;
    }

    static boolean isLowStock()
    {
        return false;
    }

    public static <T extends InventoryItem> void printAll(List<T> items)
    {  
        for (T item : items)
            if (item instanceof Product p)
                p.printSummary();
    }

   public static void printAll2(List<? extends InventoryItem> items)
    {
        for (InventoryItem item : items)
            if (item instanceof Product p)
            p.printSummary();
    }

}

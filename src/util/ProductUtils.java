package util;
import model.*;
class ProductUtils
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

    <T extends InventoryItem> void printAll(List<T> items)
    {  
        for (T item : items)
            item.printSummary();
    }

   void printAll2(List<? extends InventoryItem> items)
    {
        for (InventoryItem item : items)
            item.printSummary();
    }
    
}

import model.*;
import util.*;
import java.time.LocalDate;
class Main
{

    public static void main(String args[])
    {
        InventoryItem[] items = new InventoryItem[10];
        for (int i = 0;i < 10;i++)
        {
            if (i < 5)
                items[i] = new  ElectronicProduct("Electronics " + i,5 * i,5.5 * i,Category.TOOLS,6.7 + i,LocalDate.now()); 
            else
                 items[i] = new  PerishableProduct("PerishableProduct " + i,5 * i,5.5 * i,Category.FOOD,6.7 + i,LocalDate.now()); 
        }
        for (InventoryItem item : items)
        {
            if (item instanceof PerishableProduct)
                ((Product)item).printSummary();
            else if (item instanceof ElectronicProduct)
                ((Product)item).printSummary();
        }
    }


}
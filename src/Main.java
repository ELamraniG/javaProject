import model.*;
import util.*;
import java.io.*;
import java.util.List;
import java.util.*;
import java.time.LocalDate;
import exception.*;
import repository.*;
class Main
{

    public static void main(String args[])
    {
        InventoryItem[] items = new InventoryItem[10];
        InventoryRepository ourRepo = new InventoryRepository();
        for (int i = 0; i < 10; i++)
        {
            if (i < 3)
                items[i] = new ElectronicProduct("Electronics " + i, 5 * i, 5.5 * i, Category.TOOLS, 6.7 + i, LocalDate.now()); 
            else if (i < 6)
                items[i] = new ElectronicProduct("Electronics " + i, 5 * i, 5.5 * i, Category.ELECTRONICS, 6.7 + i, LocalDate.now()); 
            else
                items[i] = new PerishableProduct("PerishableProduct " + i, 5 * i, 5.5 * i, Category.FOOD, 6.7 + i, LocalDate.now()); 
            ourRepo.addProduct(items[i]);
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
            if (items[1] instanceof Product p)
                p.setQuantity(-5);
        }
        catch (InvalidQuantityException e)
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
        List <InventoryItem> testItems = ourRepo.toList();
        List <Product> prods = new ArrayList<>();
        for (InventoryItem item: testItems)
        {
            if (item instanceof Product p)
            {
                prods.add(p);
            }
        }
        List<InventoryItem> filtered = GenericUtils.filterProducts(prods,
            a -> a.getCategory() == Category.FOOD
        );
        
        ProductUtils.printAll(ourRepo.sortedProductsByPrice());
        System.out.println("\n\n\n\n----");
        ProductUtils.printAll2(prods);
        System.out.println("\n\n\n\n----filtered by food");
        ProductUtils.printAll2(filtered);
        System.out.println("\n\n\n\n----changed to electronic");
        GenericUtils.applyToAll(filtered,
            a -> a.setCategory(Category.ELECTRONICS)
        );
        ProductUtils.printAll2(filtered);
        System.out.println("\n\n\n\n----transformed to string");
        List <String> nameLista = GenericUtils.transformNames(filtered,
        (p)-> p.getName()
        );
        System.out.println(nameLista.toString());
    }
}

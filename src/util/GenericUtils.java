package util;
import model.*;
import java.util.function.*;

import java.util.List;
import java.util.ArrayList;
public class GenericUtils
{
	public static List<InventoryItem> filterProducts(List<? extends InventoryItem> items, Predicate<Product> filter)
    {
        List<InventoryItem> filteredItems = new ArrayList<>();
        for (InventoryItem item : items)
        {
            if (item instanceof Product p)
            {
                if (filter.test(p))
                    filteredItems.add(p);
            }
        }
        return filteredItems;
    }
	public static void applyToAll(List<? extends InventoryItem> items, Consumer<Product> filter)
    {
        for (InventoryItem item : items)
        {
            if (item instanceof Product p)
				filter.accept(p);
        }
    }
	public static  List<String> transformNames(List<? extends InventoryItem> items, Function<Product, String> transform)
    {
		List<String> newLista = new ArrayList<>();
		for (InventoryItem item : items)
		{
			if (item instanceof Product p)
			{
				newLista.add(transform.apply(p));
			}
		}
		return newLista;
    }

}
package Repository;
import model;
import exception.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
    class InventoryRepository  
    {
             final private Map<String,InventoryItem> StoreMap = new HashMap<String,InventoryItem>();


        public InventoryRepository()
        {
            InventoryItem item1 = new Product("itemn1",5,33,Category.TOOLS,15);
            ArrayList<String> testTags =
            new ArrayList<>(Arrays.asList("electronics", "sale", "fresh", "organic", "imported", "fragile"));
            ((Product)item1).addTags(testTags);
            InventoryItem item2 = new Product("itemn2",9,44,Category.TOOLS,5);
            testTags =
            new ArrayList<>(Arrays.asList("electronics", "black", "fresh", "organic", "milk", "fragile"));
            ((Product)item2).addTags(testTags);
            InventoryItem item3 = new Product("itemn3",32,55,Category.TOOLS,2);
            ((Product)item3).addTag("fragile");
            ((Product)item3).addTag("black");
            InventoryItem item4 = new Product("itemn4",55,66,Category.TOOLS,1);
            ((Product)item4).addTag("nice");
            StoreMap.put(item1.getName(),item1);
            StoreMap.put(item2.getName(),item2);
            StoreMap.put(item3.getName(),item3);
            StoreMap.put(item4.getName(),item4);
        }
        private boolean validateProduct(InventoryItem item)
        {
            if (item == null || item.getName().isEmpty() || StoreMap.containsKey(item.getName()) )
                return false;
            return true;
        }

        public Map<String,InventoryItem> getAllProducts()
        {
            return Collections.unmodifiableMap(StoreMap);    
        }

        public boolean removeProduct(String Name)
        {
            InventoryItem item = null;
            try 
            {
                item = findProduct(Name);
            }
            catch (ProductNotFoundException e)
            {
                System.out.println(e.getMessage());
                return false;
            }
            StoreMap.remove(Name);
            return true;
        }
        
        public boolean addProduct(InventoryItem product)
        {
            if (product instanceof Product p)
                if (validateProduct(p))
                {
                    StoreMap.put(product.getName(),product);
                return true;
                }
            System.err.println("Product hasn't been added, it must not be  null and not already existing and must have a name");
            return false;
        }

        public InventoryItem findProduct(String productName) throws ProductNotFoundException 
        {
            InventoryItem prod = StoreMap.get(productName);
            if (prod == null)
                throw new ProductNotFoundException("Product not found");
            return prod;
        }

        public List<InventoryItem> sortedProductsByPrice()
        {
            final List<InventoryItem> StoreArray = new ArrayList<InventoryItem>(StoreMap.values());
            StoreArray.sort(Comparator.comparing(InventoryItem::getPrice));
            return StoreArray;
        }

        public HashSet<String> getUniqueTags()
        {
            HashSet<String> uniqueTags = new HashSet<>();
            for (Map.Entry<String,InventoryItem> entry : StoreMap.entrySet())
            {
                if (entry.getValue() instanceof Product p)
                    uniqueTags.addAll(p.getTags());
            }
            return uniqueTags   ;
        }
        public Map<LocalDate,List<InventoryItem>> getSortedExperationDate()
        {
            TreeMap<LocalDate,List<InventoryItem>> sortedByTime = new TreeMap<>();
            for (Map.Entry<String,InventoryItem> entry : StoreMap.entrySet())
            {
                if (entry.getValue() instanceof PerishableProduct p)
                {
                    sortedByTime.computeIfAbsent(p.getExpirationDate(),k-> new ArrayList<>()).add(p);
                }
            }
            return sortedByTime;
        }

        
    }

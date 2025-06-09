package service;

import java.util.List;

import model.Item;

public interface ItemService {

    boolean saveItem(Item var1);

    boolean removeItem(int var1);

    boolean updateItem(Item var1);

    Item loadItem(int var1);

    List<Item> loadItems();
    
    boolean updateItemStatus(int itemId);
}

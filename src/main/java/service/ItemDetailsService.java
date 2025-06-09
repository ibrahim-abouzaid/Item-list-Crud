package service;

import model.ItemDetails;

public interface ItemDetailsService {
	
	boolean saveItemDetails(ItemDetails itemDetails);
	
	ItemDetails showItemDetails(int itemId);
	
}

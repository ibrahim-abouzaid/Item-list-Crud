package model;

public class ItemDetails {

	private int id;
	private String description;
	private String colors;
	private String category;
	private int item_id;
	
	
	
	
	public ItemDetails(String description, String colors, String category,int item_id) {
		super();
		this.description = description;
		this.colors = colors;
		this.category = category;
		this.item_id = item_id;
	}
	
	public ItemDetails(int id, String description, String colors, String category, int item_id) {
		super();
		this.id = id;
		this.description = description;
		this.colors = colors;
		this.category = category;
		this.item_id = item_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColors() {
		return colors;
	}
	public void setColors(String colors) {
		this.colors = colors;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	
	
	
}

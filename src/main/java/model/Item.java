package model;

public class Item {
	private int id;
	private String Name;
	private double price;
	private int totalNumber;
	private String hasDetails="False";
	


	public Item( String name, double price, int totalNumber) {
		this.Name = name;
		this.price = price;
		this.totalNumber = totalNumber;
		
	}
	
	public Item(int id, String Name, double price, int totalNumber) {
		this.id = id;
		this.Name = Name;
		this.price = price;
		this.totalNumber = totalNumber;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	
	public String isHasDetails() {
		return hasDetails;
	}

	public void setHasDetails(String hasDetails) {
		this.hasDetails = hasDetails;
	}
	
	
}

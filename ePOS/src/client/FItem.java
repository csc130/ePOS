package client;

import java.util.ArrayList;

public class FItem {
	public static String[] categories = { "Appetizer", "Entree", "Dessert", "Beverage" };
	public static String[] mtypes = { "None", "Beef", "Chicken", "Pork", "Seafood" };
	public static String[] sizes = { "Small", "Medium", "Large" };
	
	public static ArrayList<FItem> items;
	public static ArrayList<FItem> soldItems;
	
	private int number, category;
	private String description;
	private int type, size;
	private double cost, tax, total;
	
	public FItem(double cost, int number, int category, String description, int type, int size, double tax, double total)
	{
		this.cost = cost;
		this.number = number;
		this.category = category;
		this.description = description;
		this.type = type;
		this.size = size;
		this.tax = tax;
		this.total = total;
		
		if (items == null)
		{
			items = new ArrayList<FItem>();
		}
		items.add(this);
	}
	
	public int getCategory()
	{
		return category;
	}
	
	public String getName()
	{
		return description;
	}

	public static String[] getCategories() {
		return categories;
	}

	public static void setCategories(String[] categories) {
		FItem.categories = categories;
	}

	public static String[] getSizes() {
		return sizes;
	}

	public static void setSizes(String[] sizes) {
		FItem.sizes = sizes;
	}

	public static ArrayList<FItem> getItems() {
		return items;
	}

	public static void setItems(ArrayList<FItem> items) {
		FItem.items = items;
	}

	public static ArrayList<FItem> getSoldItems() {
		return soldItems;
	}

	public static void setSoldItems(ArrayList<FItem> soldItems) {
		FItem.soldItems = soldItems;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setCategory(int category) {
		this.category = category;
	}
}

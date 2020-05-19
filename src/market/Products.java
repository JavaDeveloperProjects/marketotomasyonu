package market;

import java.util.List;
import java.util.Random;

public class Products {
	private String name="";
	private double  price;
	private int quantity;
	private int productId;
	private int barcode=0;
	Random rand=new Random();
	public Products()
	{
		
	}
	public Products(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		barcode++;
		this.productId=barcode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Products [name=" + name + ", price=" + price + ", quantity=" + quantity +  "]";
	}
	
}

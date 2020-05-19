package market;

import java.util.List;

public class Cashier extends User implements Calculate {
	private int cashierId;
	private int password;

	public Cashier(String name, String surName,int cashierId,int password) {
		super(name, surName);
		this.cashierId=cashierId;
		this.password=password;
	}

	public int getCashierId() {
		return cashierId;
	}

	public void setCashierId(int cashierId) {
		this.cashierId = cashierId;
	}
	
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public double totalAmount(List<Products> totalShop) {//Müþterinin aldýgý ürünlerin toplam fiyatýný ezberleyip döndürecek
		double totalAmount=0;
		double price=0;
		int quantity=0;
		for(int i=0;i<totalShop.size();i++) {
			price=(double)totalShop.get(i).getPrice();
			quantity=(int)totalShop.get(i).getQuantity();
			totalAmount=totalAmount+price*quantity;
		}
		return totalAmount;
	}
	
	@Override
	public String toString() {
		return "Cashier [cashierId=" + cashierId  + ", Name=" + getName()
				+ ", SurName =" + getSurName() + "]";
	}

	@Override
	public void openSystem() {
		System.out.println("Welcome "+getName()+" this is cashier class");
	}

}

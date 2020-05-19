package market;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemManager extends User {

	Scanner scan=new Scanner(System.in);
	ProductList stk=new ProductList();
	private int password;//Yönetici olarak girmek istendiginde þifre istenecek
	private int systemManagerId;
	
	//private List<Cashier>cas;
	
	public SystemManager(String name, String surName,int password,int systemManagerId) {
		super(name, surName);
		this.password=password;
		this.systemManagerId=systemManagerId;
		//this.cas=new ArrayList<Cashier>();
		
	}
	

	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}


	public int getSystemManagerId() {
		return systemManagerId;
	}


	public void setSystemManagerId(int systemManagerId) {
		this.systemManagerId = systemManagerId;
	}
	

	/*public List<Cashier> getCas() {
		return cas;
	}


	public void addCashier(Cashier cs)
	{
		cas.add(cs);
	}*/

	public List<Products> addProducts(List<Products> shopList1)//Ürünnler tipinde gelen listeyi alýp ürün ekleyip geri dönderecek
	{	
		
		String newProductName;
		double newProductPrice;
		int newProductQuantity;
		System.out.println("Enter the name, price and quantity of the product you want to add:");
		newProductName=scan.nextLine();
		newProductPrice=scan.nextDouble();
		newProductQuantity=scan.nextInt();
		shopList1.add(new Products(newProductName,newProductPrice,newProductQuantity));

		return shopList1;
	}
	public List<Products> priceUpdate(List<Products> shopList1){//Ürünler tipinde liste alýp fiyatýný güncelleyebilecek
		String updateName;
		double updatePrice;
		
		System.out.println("Enter the name of the product you want to update and the current price:");
		updateName=scan.nextLine();
		updatePrice=scan.nextDouble();
		for(int i=0;i<shopList1.size();i++) {
			if(shopList1.get(i).getName().equalsIgnoreCase(updateName)) {
				shopList1.get(i).setPrice(updatePrice);
			}
		}
		return shopList1;
	}
	public List<Products> quantityUpdate(List<Products> shopList1){//Ürünler tipinde liste alýp miktarýný güncelleyebilecek
		String updateName;
		double updateQuantity;
		
		System.out.println("Enter the name of the product you want to update and the current quantity:");
		updateName=scan.nextLine();
		updateQuantity=scan.nextDouble();
		for(int i=0;i<shopList1.size();i++) {
			if(shopList1.get(i).getName().equalsIgnoreCase(updateName)) {
				shopList1.get(i).setPrice(updateQuantity);
			}
		}
		return shopList1;
	}
	/*public String displayAllCashier()
	{
		String output = "";
		
		for(int i=0;i<cas.size();i++)
		{
			output += cas.get(i) + "\n";
		}
		
		return output;
	}*/
	@Override//ÇOK BÝÇÝMLÝLÝK
	public void openSystem() {
		System.out.println("Welcome "+getName()+" this is systemManager class");
	}
}

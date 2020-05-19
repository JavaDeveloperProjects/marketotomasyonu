package market;

import java.util.ArrayList;
import java.util.List;

public class shopList {
	private List<Products> shopList;

	public shopList() {
		
		this.shopList=new ArrayList<Products>();
	}
	
	public List<Products> getShopList() {
		return shopList;
	}


	public void addShopProduct(Products shop)
	{
		shopList.add(shop);//Müþterinin aldýgý ürünler shopList de tutulacak ve main tarafýnda miktar güncellenecek en son ödevde
	}

	public String displayShopList()
	{
		String output = "";
		
		for(int i=0;i<shopList.size();i++)
		{
			output += shopList.get(i) + "\n";
		}
		return output;
	}
	public String displayInvoice() {
		String output="";
		for(int i=0;i<shopList.size();i++) {
			
			output+=shopList.get(i).getName()+"    -quantity: "+shopList.get(i).getQuantity()+"    -unit price:"+shopList.get(i).getPrice()+"\n";
		}
		return output;
	}

}

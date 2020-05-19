package market;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProductList{
	
	private List<Products> productsList;
	
	public ProductList()
	{
		
		this.productsList=new ArrayList<Products>();
	}
	
	
	public List<Products> getProductsList() {
		return productsList;
	}


	public void addProducts(Products product)
	{
		productsList.add(product);
	}
	
	public void productStockUpdate(String name,int kac)
	{
		for(int i=0;i<productsList.size();i++)
		{
			if(productsList.get(i).getName().equalsIgnoreCase(name)) {
				productsList.get(i).setQuantity(kac);
			}
		}	
	}
	public void productPriceUpdate(String name,double kac)
	{
		for(int i=0;i<productsList.size();i++)
		{
			if(productsList.get(i).getName().equalsIgnoreCase(name)) {
				productsList.get(i).setPrice(kac);
			}
		}	
	}
	public void productDelete(Products product) {
		productsList.remove(product);
	}
	public String displayAllProducts()
	{
		String output = "";
		
		for(int i=0;i<productsList.size();i++)
		{
			output += productsList.get(i) + "\n";
		}
		
		return output;
	}

	

}

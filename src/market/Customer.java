package market;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{

	private int customerId;
	
	public Customer(String name, String surName,int customerId)
	{
		super(name, surName);
		
		this.customerId=customerId;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	
	public void openSystem() {
		System.out.println("Welcome "+getName()+" this is customer class");
	}

}
	



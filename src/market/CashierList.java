package market;

import java.util.ArrayList;
import java.util.List;

public class CashierList {
	
	private List<Cashier>casList;

	public CashierList() {
		this.casList=new ArrayList<Cashier>();
	}
	public List<Cashier> getCasList() {
		return casList;
	}


	public void addCashier(Cashier cs)
	{
		casList.add(cs);
	}
	public String displayAllCashier()
	{
		String output = "";
		
		for(int i=0;i<casList.size();i++)
		{
			output += casList.get(i) + "\n";
		}
		
		return output;
	}
	
}

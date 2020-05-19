package market;

public class Payment extends Customer {

	private String paymentKind;
	public Payment(String name, String surName, int customerId,String paymentKind) {
		super(name, surName, customerId);
		this.paymentKind=paymentKind;
	}
	
	public String invoiceWrite(double totalAmount) {//Müþteri adýna fatura yazdýrýlacak
		return "--Invoice-- \nCustomer Name:"+getName()+
				"\nCustomer Surname:"+getSurName()+
				"\nCustomer Id:"+getCustomerId()+
				"\nPayment Kind:"+paymentKind+
				"\nTotal Amound:"+totalAmount;
	}
	@Override
	public String toString() {
		return "Goodbye";
	}

}

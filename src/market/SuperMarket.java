package market;

import java.util.List;

public abstract class SuperMarket {

	private String name;
	private int id;
	private int contact;
	private Address address;
	private List<Products> productsList;
	private List<User> userList;

	public SuperMarket(String name, int id, int contact, Address address) {
		this.name = name;
		this.id = id;
		this.contact = contact;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public void addUser(User s)
	{
		userList.add(s);
	}

	@Override
	public String toString() {
		return "SuperMarket [name=" + name + ", id=" + id + ", contact="
				+ contact + ", address=" + address + ", products=" + "]";
	}
	
}

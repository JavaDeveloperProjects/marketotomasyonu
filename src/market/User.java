package market;

public  class User {
	private String name="";
	private String surName="";
	public User(String name, String surName)
	{
		super();
		this.name = name;
		this.surName = surName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public void openSystem() {
		System.out.println("Welcome user class");
	}
	
	

}
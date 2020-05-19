package market;

public class Address {
	private String county;
	private String city;
	private int postCode;
	
	public Address(String county, String city, int postCode) {
		this.county = county;
		this.city = city;
		this.postCode = postCode;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

}

package pizzaordering.model;

public class Address{


	private String state;
	private String district;
	private String city;
	private String street;
	private int doorNumber;


    public Address(String state, String district, String city, String street, int doorNumber) {
        this.state = state;
        this.district = district;
        this.city = city;
        this.street = street;
        this.doorNumber = doorNumber;
    }


	public int getDoorNumber() {
	    return doorNumber;
	}
	public void setDoorNumber(int doorNumber) {
	    this.doorNumber = doorNumber;
	}




	public String getStreet() {
	    return street;
	}
	public void setStreet(String street) {
	    this.street = street;
	}


	public String getCity() {
	    return city;
	}
	public void setCity(String city) {
	    this.city = city;
	}




	public String getDistrict() {
	    return district;
	}
	public void setDistrict(String district) {
	    this.district = district;
	}



	public String getState() {
	    return state;
	}
	public void setState(String state) {
	    this.state = state;
	}



	@Override
    public String toString() {
        return "Address => State: " + getState() +  ", District: " + getDistrict() + ", City: " + getCity()+", Street :" + getStreet() + ",  Door number: "+ getDoorNumber();
    }




}
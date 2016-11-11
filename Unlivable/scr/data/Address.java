package data;

public class Address {
	private String streetNum;
	private String nsew;
	private String streetName;
	private String unit;
	private String city;
	private String stateAbbr;
	private String zip;

	public Address() {
	}

	public Address(String streetNum, String nsew, String street, String unit, String city, String streetName,
			String stateAbbr, String zip) {
		this.streetNum = streetNum;
		this.nsew = nsew;
		this.streetName = streetName;
		this.unit = unit;
		this.city = city;
		this.stateAbbr = stateAbbr;
		this.zip = zip;
	}

	public String getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}

	public String getNsew() {
		return nsew;
	}

	public void setNsew(String nsew) {
		this.nsew = nsew;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateAbbr() {
		return stateAbbr;
	}

	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return streetNum + " " + streetName + " " + unit + "\n" + city + ", " + stateAbbr + " " + zip;
	}
}

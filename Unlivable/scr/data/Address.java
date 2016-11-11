package data;

public class Address {
	private Integer streetNum;
	private String streetName;
	private String streetType;
	private String unit;
	private String city;
	private String stateAbbr;
	private Integer zip;

	public Address() {
	}

	public Address(Integer streetNum, String street, String streetType, String unit, String city, String streetName, String stateAbbr,
			Integer zip) {
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.streetType = streetType;
		this.unit = unit;
		this.city = city;
		this.stateAbbr = stateAbbr;
		this.zip = zip;
	}

	public Integer getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(Integer streetNum) {
		this.streetNum = streetNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
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

	public String getState() {
		return stateAbbr;
	}

	public void setState(String state) {
		this.stateAbbr = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return streetNum + " " + streetName + " " + streetType
				+ ". " + unit + "\n" + city + ", " + stateAbbr + " " + zip;
	}

}

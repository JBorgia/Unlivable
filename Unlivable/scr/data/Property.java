package data;

import java.util.List;

public class Property {
	private Address address;
	private Integer numOfBr;
	private Double numOfBa;
	private Integer numOfFloors;
	private Double buildingSqft;
	private Double landSqft;
	private Double ceilingHeight;
	private Double stairSqft;
	private Double hallSqft;
	private List<Bedroom> bedrooms;

	public Property() {
	}

	public Property(Integer streetNum, String nsew, String streetName, String unit, String city, String state,
			Integer zip, Double buildingSqft, Double landSqft, Integer numOfFloors, Integer numOfBr, Double numOfBa,
			Double ceilingHeight, Double stairSqft, Double hallSqft, List<Bedroom> bedrooms) {
		this.address.setStreetNum(streetNum);
		this.address.setNsew(nsew);
		this.address.setStreetName(streetName);
		this.address.setUnit(unit);
		this.address.setCity(city);
		this.address.setCity(city);
		this.address.setZip(zip);
		this.buildingSqft = buildingSqft;
		this.landSqft = landSqft;
		this.numOfFloors = numOfFloors;
		this.numOfBr = numOfBr;
		this.numOfBa = numOfBa;
		this.ceilingHeight = ceilingHeight;
		this.stairSqft = stairSqft;
		this.hallSqft = hallSqft;
		this.bedrooms = bedrooms;
	}

	public Address getAddress() {
		return address;
	}

	public Integer getNumOfBr() {
		return numOfBr;
	}

	public void setNumOfBr(Integer numOfBr) {
		this.numOfBr = numOfBr;
	}

	public Double getNumOfBa() {
		return numOfBa;
	}

	public void setNumOfBa(Double numOfBa) {
		this.numOfBa = numOfBa;
	}

	public Integer getNumOfFloors() {
		return numOfFloors;
	}

	public void setNumOfFloors(Integer numOfFloors) {
		this.numOfFloors = numOfFloors;
	}

	public Double getBuildingSqft() {
		return buildingSqft;
	}

	public void setBuildingSqft(Double buildingSqft) {
		this.buildingSqft = buildingSqft;
	}

	public Double getLandSqft() {
		return landSqft;
	}

	public void setLandSqft(Double landSqft) {
		this.landSqft = landSqft;
	}

	public Double getCeilingHeight() {
		return ceilingHeight;
	}

	public void setCeilingHeight(Double ceilingHeight) {
		this.ceilingHeight = ceilingHeight;
	}

	public Double getStairSqft() {
		return stairSqft;
	}

	public void setStairSqft(Double stairSqft) {
		this.stairSqft = stairSqft;
	}

	public Double getHallSqft() {
		return hallSqft;
	}

	public void setHallSqft(Double hallSqft) {
		this.hallSqft = hallSqft;
	}

}
package data;

import java.util.ArrayList;
import java.util.List;

public class Property {
	private Address address;
	private Integer numOfBr;
	private Double numOfBa;
	private Integer numOfFloors;
	private Double buildingSqft;
	private Double landSqft;
	private Boolean vaultedCeiling;
	private Integer garageSpaces;
	private Double unlivableSqft;
	private List<Bedroom> bedrooms;

	public Property() {
	}

	public Property(Address address, Double buildingSqft, Double landSqft, Integer numOfFloors, Integer numOfBr,
			Double numOfBa, Boolean vaultedCeiling, Integer garageSpaces, Double unlivableSqft, List<Bedroom> bedrooms) {
		this.address = address;
		this.buildingSqft = buildingSqft;
		this.landSqft = landSqft;
		this.numOfFloors = numOfFloors;
		this.numOfBr = numOfBr;
		this.numOfBa = numOfBa;
		this.vaultedCeiling = vaultedCeiling;
		this.garageSpaces = garageSpaces;
		this.unlivableSqft = unlivableSqft;
		this.bedrooms = bedrooms;
	}

	public Property(String streetNum, String nsew, String streetName, String unit, String city, String stateAbbr,
			String zip, Double buildingSqft, Double landSqft, Integer numOfFloors, Integer numOfBr, Double numOfBa,
			String vaultedCeiling, Integer garageSpaces, Double unlivableSqft, List<Bedroom> bedrooms) {
		System.out.println("PROPERTY: I'M GETTING MADE & HAVEN'T BROKEN YET! streetNum is: " + streetNum);
		this.address = new Address();
		this.address.setStreetNum(streetNum);
		this.address.setNsew(nsew);
		this.address.setStreetName(streetName);
		this.address.setUnit(unit);
		this.address.setCity(city);
		this.address.setStateAbbr(stateAbbr);
		this.address.setZip(zip);
		this.buildingSqft = buildingSqft;
		this.landSqft = landSqft;
		this.numOfFloors = numOfFloors;
		this.numOfBr = numOfBr;
		this.numOfBa = numOfBa;
		setVaultedCeiling(vaultedCeiling);
		this.garageSpaces = garageSpaces;
		this.unlivableSqft = unlivableSqft;
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

	public Integer getGarageSpaces() {
		return garageSpaces;
	}

	public void setGarageSpaces(Integer garageSpaces) {
		this.garageSpaces = garageSpaces;
	}

	public Double getUnlivableSqft() {
		return unlivableSqft;
	}

	public void setUnlivableSqft(Double unlivableSqft) {
		this.unlivableSqft = unlivableSqft;
	}

	public Boolean getVaultedCeiling() {
		return vaultedCeiling;
	}

	public void setVaultedCeiling(String vaultedCeiling) {
		this.vaultedCeiling = Boolean.parseBoolean(vaultedCeiling);
	}

	@Override
	public String toString() {
		return "Property [address=" + address + ", numOfBr=" + numOfBr + ", numOfBa=" + numOfBa + ", numOfFloors="
				+ numOfFloors + ", buildingSqft=" + buildingSqft + ", landSqft=" + landSqft + ", vaultedCeiling="
				+ vaultedCeiling + ", garageSpaces=" + garageSpaces + ", unlivableSqft=" + unlivableSqft + ", bedrooms="
				+ bedrooms + "]";
	}

	public List<Bedroom> getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(List<Bedroom> bedrooms) {
		this.bedrooms = bedrooms;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setVaultedCeiling(Boolean vaultedCeiling) {
		this.vaultedCeiling = vaultedCeiling;
	}

	public void populateBedrooms() {
		List<Bedroom> bedrooms = new ArrayList<>();
		for (int i = 0; i < this.numOfBr; i++) {
			bedrooms.add(new Bedroom());
		}
		this.bedrooms = bedrooms;
	}
}
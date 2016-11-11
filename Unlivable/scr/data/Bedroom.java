package data;

public class Bedroom {
	private Boolean attachedBa;
	private Boolean closet;
	private Double bedroomSqft;
	private Double closetSqft;
	
	public Bedroom(){}

	public Bedroom(Boolean attachedBa, Boolean closet, Double bedroomSqft, Double closetSqft) {
		this.attachedBa = attachedBa;
		this.closet = closet;
		this.bedroomSqft = bedroomSqft;
		this.closetSqft = closetSqft;
	}

	public Double getBedroomSqft() {
		return bedroomSqft;
	}

	public void setBedroomSqft(Double bedroomSqft) {
		this.bedroomSqft = bedroomSqft;
	}

	public Boolean getAttachedBa() {
		return attachedBa;
	}

	public void setAttachedBa(Boolean attachedBa) {
		this.attachedBa = attachedBa;
	}

	public Boolean getCloset() {
		return closet;
	}

	public void setCloset(Boolean closet) {
		this.closet = closet;
	}

	public Double getClosetSqft() {
		return closetSqft;
	}

	public void setClosetSqft(Double closetSqft) {
		this.closetSqft = closetSqft;
	}
	
}

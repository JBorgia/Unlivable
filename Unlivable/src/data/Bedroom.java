package data;

public class Bedroom {
	private String bedroomSqft;
	private Boolean attachedBa;
	private Boolean closet;
	private String closetSqft;
	
	public Bedroom(){}

	public Bedroom(String bedroomSqft, Boolean attachedBa, Boolean closet, String closetSqft) {
		this.bedroomSqft = bedroomSqft;
		this.attachedBa = attachedBa;
		this.closet = closet;
		this.closetSqft = closetSqft;
	}

	public String getBedroomSqft() {
		return bedroomSqft;
	}

	public void setBedroomSqft(String bedroomSqft) {
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

	public String getClosetSqft() {
		return closetSqft;
	}

	public void setClosetSqft(String closetSqft) {
		this.closetSqft = closetSqft;
	}
	
}

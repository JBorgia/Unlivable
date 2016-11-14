package data;

public class Bedroom {
	private Boolean attachedBa;
	private Boolean closet;
	private String bedroomSqft;
	private String closetSqft;

	public Bedroom() {
	}

	public Bedroom(Boolean attachedBa, Boolean closet, String bedroomSqft, String closetSqft) {
		this.attachedBa = attachedBa;
		this.closet = closet;
		this.bedroomSqft = bedroomSqft;
		this.closetSqft = closetSqft;
	}

	public String getBedroomSqft() {
		return bedroomSqft;
	}
//
//	public Double getValueBedroomSqft() {
//		return Double.parseDouble(bedroomSqft);
//	}

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

//	public Double getValueClosetSqft() {
//		return Double.parseDouble(closetSqft);
//	}

	public void setClosetSqft(String closetSqft) {
		this.closetSqft = closetSqft;
	}

	@Override
	public String toString() {
		return "Bedroom [attachedBa=" + attachedBa + ", closet=" + closet + ", bedroomSqft=" + bedroomSqft
				+ ", closetSqft=" + closetSqft + "]";
	}

}

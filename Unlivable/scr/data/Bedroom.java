package data;

public class Bedroom {
	private String attachedBa;
	private String closet;
	private String bedroomSqft;
	private String closetSqft;

	public Bedroom() {
	}

	public Bedroom(String attachedBa, String closet, String bedroomSqft, String closetSqft) {
		this.attachedBa = attachedBa;
		this.closet = closet;
		this.bedroomSqft = bedroomSqft;
		this.closetSqft = closetSqft;
	}

	public String getBedroomSqft() {
		return bedroomSqft;
	}

	public Double getValueBedroomSqft() {
		return Double.parseDouble(bedroomSqft);
	}

	public void setBedroomSqft(String bedroomSqft) {
		this.bedroomSqft = bedroomSqft;
	}

	public String getAttachedBa() {
		return attachedBa;
	}

	public void setAttachedBa(String attachedBa) {
		this.attachedBa = attachedBa;
	}

	public String getCloset() {
		return closet;
	}

	public void setCloset(String closet) {
		this.closet = closet;
	}

	public String getClosetSqft() {
		return closetSqft;
	}

	public Double getValueClosetSqft() {
		return Double.parseDouble(closetSqft);
	}

	public void setClosetSqft(String closetSqft) {
		this.closetSqft = closetSqft;
	}

}

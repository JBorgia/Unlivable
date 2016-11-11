package data;

import java.util.Map;

public interface UnlivableDAO {
	public Map<String, Property> getPropertyByAddress(String streetNum, String nsew, String streetName, String unit, String city, String stateAbbr, String zip);

	public Property getPropertyByKeyNum(String keyNum);

	public void addProperty(Property property);
}
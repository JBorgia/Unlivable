package data;

import java.util.Map;

public interface UnlivableDAO {
	public Property getPropertyByStreet(String streetNum, String streetName, String streetType);

	public Property getPropertyByKeyNum(String keyNum);

	public Map<String, Property> getPropertyListByZip(String zip);

	public void addProperty(Property property);
}
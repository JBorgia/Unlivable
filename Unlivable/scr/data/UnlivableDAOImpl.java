package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class UnlivableDAOImpl implements UnlivableDAO {
	private static final String FILE_NAME = "/WEB-INF/lib/database.csv";
	private Map<String, Property> properties = new HashMap<>();
	/*
	 * Use Autowired to have Spring inject an instance of a
	 * WebApplicationContext into this object after creation. We will use the
	 * WebApplicationContext to retrieve an ServletContext so we can read from a
	 * file.
	 */
	@Autowired
	private WebApplicationContext wac;

	/*
	 * The @PostConstruct method is called by Spring after object creation and
	 * dependency injection
	 */
	@PostConstruct
	public void init() {
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				List<Bedroom> bedrooms = new ArrayList<>();
				String[] tokens = line.split(",");
				String keyNum = tokens[0];
				Integer streetNum;
				try {
					streetNum = Integer.parseInt(tokens[1].replaceAll("[^\\d.]", ""));
				} catch (Exception e1) {
					e1.printStackTrace();
					streetNum = 0;
				}
				String streetName = tokens[2];
				String streetType = tokens[3];
				String unit = tokens[4];
				String city = tokens[5];
				String stateAbbr = tokens[6];
				Integer zip = Integer.parseInt(tokens[7].replaceAll("[^\\d.]", ""));
				Integer numOfBr;
				try {
					numOfBr = Integer.parseInt(tokens[9]);
				} catch (Exception e) {
					numOfBr = 0;
				}
				Double numOfBa = Double.parseDouble(tokens[10].replaceAll("[^\\d.]", ""));
				Integer numOfFloors = Integer.parseInt(tokens[11].replaceAll("[^\\d.]", ""));
				Double buildingSqft = Double.parseDouble(tokens[12].replaceAll("[^\\d.]", ""));
				Double landSqft = Double.parseDouble(tokens[13].replaceAll("[^\\d.]", ""));
				Double ceilingHeight = Double.parseDouble(tokens[14].replaceAll("[^\\d.]", ""));
				Double stairSqft = Double.parseDouble(tokens[15].replaceAll("[^\\d.]", ""));
				Double hallSqft = Double.parseDouble(tokens[16].replaceAll("[^\\d.]", ""));
				for (int i = 0; i < numOfBr; i++) {
					Bedroom bedroom = new Bedroom();
					Boolean attachedBa = Boolean.parseBoolean(tokens[17 + i * 4]);
					Boolean closet = Boolean.parseBoolean(tokens[18 + i * 4]);
					Double bedroomSqft = Double.parseDouble(tokens[19 + i * 4].replaceAll("[^\\d.]", ""));
					Double closetSqft = Double.parseDouble(tokens[20 + i * 4].replaceAll("[^\\d.]", ""));
					bedroom.setAttachedBa(attachedBa);
					bedroom.setCloset(closet);
					bedroom.setBedroomSqft(bedroomSqft);
					bedroom.setClosetSqft(closetSqft);
					bedrooms.add(bedroom);
				}

				properties.put(keyNum,
						new Property(streetNum, streetName, streetType, unit, city, stateAbbr, zip, buildingSqft,
								landSqft, numOfFloors, numOfBr, numOfBa, ceilingHeight, stairSqft, hallSqft, bedrooms));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public Property getPropertyByStreet(String streetNum, String streetName, String streetType) {
		Property p = null;
		return p;
	}

	@Override
	public Property getPropertyByKeyNum(String keyNum) {
		Property p = null;
		return p;
	}

	@Override
	public Map<String, Property> getPropertyListByZip(String zip) {
		Map<String, Property> ps = null;
		return ps;
	}

	@Override
	public void addProperty(Property property) {
		properties.put(createKeyNum(property.getAddress().getStreetNum(), property.getAddress().getStreetName(), property.getAddress().getUnit()),
				property);
	}

	private String createKeyNum(Integer streetNum, String streetName, String unit) {
		StringBuilder sb = new StringBuilder(streetNum.toString());
		while (sb.length() < 8) {
			sb.append("x");
		}
		sb.append(streetName.toUpperCase().subSequence(0, 4));
		while (sb.length() < 12) {
			sb.append("x");
		}
		sb.append(unit.toUpperCase().subSequence(0, 4));
		while (sb.length() < 16) {
			sb.append("x");
		}
		sb.append("A");
		char suffix;
		while (properties.get(sb) != null) {
			suffix = sb.charAt(8);
			suffix++;
			sb.replace(8, 8, suffix + "");
		}
		return sb.toString();
	}
}

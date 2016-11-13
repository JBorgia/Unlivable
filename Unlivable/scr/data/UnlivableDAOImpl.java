package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class UnlivableDAOImpl implements UnlivableDAO {
	private static final String FILE_NAME = "/WEB-INF/lib/database.csv";
	private Map<String, Property> properties = new HashMap<>();
	Address address;
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
			line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				List<Bedroom> bedrooms = new ArrayList<>();
				String[] tokens = line.split(",");

				for (String string : tokens) {

					System.out.println(string);
				}

				String streetNum;
				streetNum = tokens[0].replaceAll("[^\\d./]", "");
				System.out.println("Read streetNum");
				String nsew = tokens[1];
				System.out.println("Read nsew");
				String streetName = tokens[2].replaceAll(".$", "");
				System.out.println("Read streetName");
				String unit = tokens[3];
				System.out.println("Read unit");
				String city = tokens[4];
				System.out.println("Read city");
				String stateAbbr = tokens[5];
				System.out.println("Read stateAbbr");
				String zip = tokens[6].substring(0, 5).replaceAll("[^\\d.]", "");
				System.out.println("Read zip");
				String keyNum = createKeyNum(streetNum, zip, unit);
				System.out.println("Got key");
				Integer numOfBr;
				try {
					numOfBr = Integer.parseInt(tokens[7]);
					System.out.println("Read numOfBr");
				} catch (Exception e) {
					numOfBr = 0;
				}
				Double numOfBa;
				try {
					numOfBa = Double.parseDouble(tokens[8].replaceAll("[^\\d.]", ""));
					System.out.println("Read numOfBa");
				} catch (Exception e) {
					numOfBa = 0.0;
				}
				Integer numOfFloors;
				try {
					numOfFloors = Integer.parseInt(tokens[9].replaceAll("[^\\d.]", ""));
					System.out.println("Read numOfFloors");
				} catch (Exception e) {
					numOfFloors = 0;
				}
				Double buildingSqft = Double.parseDouble(tokens[10].replaceAll("[^\\d.]", ""));
				Double landSqft = Double.parseDouble(tokens[11].replaceAll("[^\\d.]", ""));
				String vaultedCeiling = tokens[12];
				Integer garageSpaces = Integer.parseInt(tokens[13].replaceAll("[^\\d.]", ""));
				Double unlivableSqft = Double.parseDouble(tokens[14].replaceAll("[^\\d.]", ""));
				for (int i = 0; i < numOfBr; i++) {
					Bedroom bedroom = new Bedroom();
					String attachedBa = tokens[15 + i * 4];
					String closet = tokens[16 + i * 4];
					String bedroomSqft = tokens[17 + i * 4].replaceAll("[^\\d.]", "");
					String closetSqft = tokens[18 + i * 4].replaceAll("[^\\d.]", "");
					bedroom.setAttachedBa(attachedBa);
					bedroom.setCloset(closet);
					bedroom.setBedroomSqft(bedroomSqft);
					bedroom.setClosetSqft(closetSqft);
					bedrooms.add(bedroom);
				}

				System.out.println("BEFORE PUT!");
				properties.put(keyNum,
						new Property(streetNum, nsew, streetName, unit, city, stateAbbr, zip, buildingSqft, landSqft,
								numOfFloors, numOfBr, numOfBa, vaultedCeiling, garageSpaces, unlivableSqft, bedrooms));
				System.out.println("AFTER PUT!");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		Set<String> keys = properties.keySet();
		for (String string : keys) {
			System.out.println(properties.get(string));
		}
	}

	@Override
	public Map<String, Property> getPropertyByAddress(String streetNum, String nsew, String streetName, String unit,
			String city, String stateAbbr, String zip) {
		Map<String, Property> searchProperties = new HashMap<>();
		Set<String> keys = properties.keySet();
		for (String key : keys) {
			boolean streetNumCase = false;
			boolean nsewCase = false;
			boolean streetNameCase = false;
			boolean unitCase = false;
			boolean cityCase = false;
			boolean stateAbbrCase = false;
			boolean zipCase = false;

			if (streetNum.equals("") || properties.get(key).getAddress().getStreetNum().toUpperCase()
					.contains(streetNum.toUpperCase())) {
				System.out.println("streetNum: " + streetNum);
				streetNumCase = true;
			}
			if (nsew.equals("") || (properties.get(key).getAddress().getNsew().equals(nsew))) {
				System.out.println("nsew: " + nsew);
				nsewCase = true;
			}
			if (streetName.equals("") || properties.get(key).getAddress().getStreetName().toUpperCase()
					.contains(streetName.toUpperCase().replaceAll(".$", ""))) {
				System.out.println("streetName: " + streetName);
				streetNameCase = true;
			}
			if (unit.equals("")
					|| properties.get(key).getAddress().getUnit().toUpperCase().contains(unit.toUpperCase())) {
				System.out.println("unit: " + unit);
				unitCase = true;
			}
			if (city.equals("")
					|| properties.get(key).getAddress().getCity().toUpperCase().contains(city.toUpperCase())) {
				System.out.println("city: " + city);
				cityCase = true;
			}
			if (stateAbbr.equals("") || properties.get(key).getAddress().getStateAbbr().toUpperCase()
					.contains(stateAbbr.toUpperCase())) {
				System.out.println("stateAbbr: " + stateAbbr);
				stateAbbrCase = true;
			}
			if (zip.equals("") || properties.get(key).getAddress().getZip().toUpperCase().contains(zip.toUpperCase())) {
				System.out.println("zip: " + zip);
				zipCase = true;
			}

			if (streetNumCase && nsewCase && streetNameCase && unitCase && cityCase && stateAbbrCase && zipCase) {
				searchProperties.put(key, properties.get(key));
			}
		}

		for (String string : keys) {
			System.out.println(string);
		}
		return searchProperties;
	}

	@Override
	public Property getPropertyByKeyNum(String keyNum) {
		return properties.get(keyNum);
	}

	@Override
	public String getKeyNumOfProperty(Property property) {
		Set<String> keys = properties.keySet();
		for (String string : keys) {
			if (property.equals(properties.get(string)))
				return string;
		}
		return null;
	}

	@Override
	public void addProperty(Property property) {
		properties.put(createKeyNum(property.getAddress().getStreetNum(), property.getAddress().getZip(),
				property.getAddress().getUnit()), property);
	}

	private String createKeyNum(String streetNum, String zip, String unit) {
		StringBuilder sb = new StringBuilder(streetNum.toString());
		while (sb.length() < 8) {
			sb.append("x");
		}
		sb.append(zip);
		while (sb.length() < 13) {
			sb.append("x");
		}
		if (unit.length() > 4) {
			sb.append(unit.toUpperCase().subSequence(0, 4));
		}
		while (sb.length() < 17) {
			sb.append("x");
		}
		sb.append("A");
		char suffix;
		while (properties.get(sb) != null) {
			suffix = sb.charAt(8);
			suffix++;
			sb.replace(8, 8, suffix + "");
		}
		System.out.println("Unique ID Key: " + sb);
		return sb.toString();
	}

	public void deleteProperty(String keyNum) {
		properties.remove(keyNum);
	}
}

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
				Integer streetNum;
				try {
					streetNum = Integer.parseInt(tokens[1].replaceAll("[^\\d.]", ""));
				} catch (Exception e1) {
					throw new IllegalArgumentException("An address must have a number.");
				}
				String nsew = tokens[2];
				String streetName = tokens[3];
				String unit = tokens[4];
				String city = tokens[5];
				String stateAbbr = tokens[6];
				Integer zip = Integer.parseInt(tokens[7].substring(0, 5).replaceAll("[^\\d.]", ""));
				String keyNum = createKeyNum(streetNum, zip, unit);
				Integer numOfBr;
				try {
					numOfBr = Integer.parseInt(tokens[8]);
				} catch (Exception e) {
					numOfBr = 0;
				}
				Double numOfBa = Double.parseDouble(tokens[9].replaceAll("[^\\d.]", ""));
				Integer numOfFloors = Integer.parseInt(tokens[10].replaceAll("[^\\d.]", ""));
				Double buildingSqft = Double.parseDouble(tokens[11].replaceAll("[^\\d.]", ""));
				Double landSqft = Double.parseDouble(tokens[12].replaceAll("[^\\d.]", ""));
				Double ceilingHeight = Double.parseDouble(tokens[13].replaceAll("[^\\d.]", ""));
				Double stairSqft = Double.parseDouble(tokens[14].replaceAll("[^\\d.]", ""));
				Double hallSqft = Double.parseDouble(tokens[15].replaceAll("[^\\d.]", ""));
				for (int i = 0; i < numOfBr; i++) {
					Bedroom bedroom = new Bedroom();
					Boolean attachedBa = Boolean.parseBoolean(tokens[16 + i * 4]);
					Boolean closet = Boolean.parseBoolean(tokens[17 + i * 4]);
					Double bedroomSqft = Double.parseDouble(tokens[18 + i * 4].replaceAll("[^\\d.]", ""));
					Double closetSqft = Double.parseDouble(tokens[19 + i * 4].replaceAll("[^\\d.]", ""));
					bedroom.setAttachedBa(attachedBa);
					bedroom.setCloset(closet);
					bedroom.setBedroomSqft(bedroomSqft);
					bedroom.setClosetSqft(closetSqft);
					bedrooms.add(bedroom);
				}

				properties.put(keyNum,
						new Property(streetNum, nsew, streetName, unit, city, stateAbbr, zip, buildingSqft, landSqft,
								numOfFloors, numOfBr, numOfBa, ceilingHeight, stairSqft, hallSqft, bedrooms));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		Set<String> keys = properties.keySet();
		System.out.println("In init");
		for (String string : keys) {
			System.out.println(properties.get(string));
		}
	}

	@Override
	public Map<String, Property> getPropertyByAddress(String streetNum, String nsew, String streetName, String unit, String city,
			String stateAbbr, String zip) {
		Map<String, Property> subProperties = new HashMap<>();
		Set<String> keys = properties.keySet();
		for (String key : keys) {
			boolean streetNumCase = false;
			boolean nsewCase = false;
			boolean streetNameCase = false;
			boolean unitCase = false;
			boolean cityCase = false;
			boolean stateAbbrCase = false;
			boolean zipCase = false;

			if (properties.get(key).getAddress().getStreetNum() == Integer.parseInt(streetNum)) {
				streetNumCase = true;
			}
			if (properties.get(key).getAddress().getNsew().contains(nsew)) {
				nsewCase = true;
			}
			if (properties.get(key).getAddress().getStreetName().contains(streetName)) {
				streetNameCase = true;
			}
			if (properties.get(key).getAddress().getUnit().contains(unit)) {
				unitCase = true;
			}
			if (properties.get(key).getAddress().getCity().contains(city)) {
				cityCase = true;
			}
			if (properties.get(key).getAddress().getStateAbbr().contains(stateAbbr)) {
				stateAbbrCase = true;
			}
			if (properties.get(key).getAddress().getZip() == Integer.parseInt(zip)) {
				zipCase = true;
			}
		
			if(streetNumCase && nsewCase && streetNameCase && unitCase && cityCase && stateAbbrCase && zipCase){
				subProperties.clear();
				subProperties.put(key, properties.get(key));
				break;
			}
			else if((streetNumCase || streetNameCase) && ((cityCase && stateAbbrCase) || zipCase)){
				subProperties.put(key, properties.get(key));
			}
		}

		return subProperties;
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
		properties.put(createKeyNum(property.getAddress().getStreetNum(), property.getAddress().getZip(),
				property.getAddress().getUnit()), property);
	}

	private String createKeyNum(Integer streetNum, Integer zip, String unit) {
		StringBuilder sb = new StringBuilder(streetNum.toString());
		while (sb.length() < 8) {
			sb.append("x");
		}
		sb.append(zip);
		while (sb.length() < 13) {
			sb.append("x");
		}
		sb.append(unit.toUpperCase().subSequence(0, 4));
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
		return sb.toString();
	}
}

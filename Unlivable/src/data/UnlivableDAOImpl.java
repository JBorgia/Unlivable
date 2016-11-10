package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class UnlivableDAOImpl implements UnlivableDAO {
	private static final String FILE_NAME = "/WEB-INF/lib/database.csv";
	private List<Property> states = new ArrayList<>();
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
				String[] tokens = line.split(",");
				String keyNum = tokens[0];
				String streetNum = tokens[1];
				String streetName = tokens[2];
				String streetType = tokens[3];
				String unit = tokens[4];
				String city = tokens[5];
				String stateAbbr = tokens[6];
				String zip = tokens[7];
				Integer numOfBr;
				try {
					numOfBr = Integer.parseInt(tokens[9]);
				} catch (Exception e) {
					numOfBr = 0;
				}
				String numOfBa = tokens[10];
				String numOfFloors = tokens[11];
				String buildingSqft = tokens[12];
				String landSqft = tokens[13];
				String ceilingHeight = tokens[14];
				String stairSqft = tokens[15];
				String hallSqft = tokens[16];
				for (int i = 0; i < numOfBr; i++) {
					String bedroomSqft;
					String attachedBa;
					String closet;
					String closetSqft;
				}
				List<Bedroom> bedrooms;
				states.add(new Property(abbrev, name, capital, latitude, longitude, population, election));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public Property getStateByName(String name) {
		// TODO : Implement method
		Property s = null;
		// Find the state by it's name in the 'states' array
		// If found, assign the state to 's'
		for (Property state : states) {
			if (state.getName().equalsIgnoreCase(name)) {
				s = states.get(states.indexOf(state));
			}
		}
		return s;
	}

	@Override
	public Property getStateByAbbreviation(String abbr) {
		// TODO : Implement method
		Property s = null;
		// Find the state by it's abbreviation in the 'states' array
		// If found, assign the state to 's'
		for (Property state : states) {
			if (state.getAbbreviation().equalsIgnoreCase(abbr)) {
				s = states.get(states.indexOf(state));
			}
		}
		return s;
	}

	@Override
	public Property getStateByCapital(String capital) {
		// TODO : Implement method
		Property s = null;
		// Find the state by it's abbreviation in the 'states' array
		// If found, assign the state to 's'
		for (Property state : states) {
			if (state.getCapital().equalsIgnoreCase(capital)) {
				s = states.get(states.indexOf(state));
			}
		}
		return s;
	}

	@Override
	public void addState(Property state) {
		// TODO : Implement method
		// This method should add a state to the 'states' array
		states.add(state);
	}

	@Override
	public Property getStateByNumber(Integer number) {
		return states.get(number);
	}

	@Override
	public Integer getStateNumber(Property state) {
		return states.indexOf(state);
	}
}

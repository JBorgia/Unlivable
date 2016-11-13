package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Address;
import data.Bedroom;
import data.Property;
import data.UnlivableDAO;

@Controller
@SessionAttributes({ "address", "sessionProperty" })
public class UnlivableController {
	@Autowired
	private UnlivableDAO unlivableDAO;

	@ModelAttribute("address")
	public Address initAddress() {
		return new Address();
	}

	@ModelAttribute("sessionProperty")
	public Property initSessionProperty() {
		return new Property();
	}

	@RequestMapping(path = "GetPropertyData.do", params = "streetNum", method = RequestMethod.GET)
	public ModelAndView queryPropertyByAddress(@RequestParam("streetNum") String streetNum,
			@RequestParam("nsew") String nsew, @RequestParam("streetName") String streetName,
			@RequestParam("unit") String unit, @RequestParam("city") String city,
			@RequestParam("stateAbbr") String stateAbbr, @RequestParam("zip") String zip) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchProperties",
				unlivableDAO.getPropertyByAddress(streetNum, nsew, streetName, unit, city, stateAbbr, zip));
		mv.setViewName("result.jsp");
		return mv;
	}

	@RequestMapping(path = "GetPropertyToModify.do", method = RequestMethod.GET)
	public ModelAndView queryPropertyByToModify(@RequestParam("streetNum") String streetNum,
			@RequestParam("nsew") String nsew, @RequestParam("streetName") String streetName,
			@RequestParam("unit") String unit, @RequestParam("city") String city,
			@RequestParam("stateAbbr") String stateAbbr, @RequestParam("zip") String zip) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("searchProperties",
				unlivableDAO.getPropertyByAddress(streetNum, nsew, streetName, unit, city, stateAbbr, zip));
		mv.setViewName("seeks.jsp");
		return mv;
	}

	@RequestMapping(path = "UpdateProperty.do", method = RequestMethod.GET)
	public ModelAndView updateProperty(@RequestParam("choice") String choice,
			@RequestParam("selectedPropertyKey") String selectedPropertyKey) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("selectedPropertyKey", selectedPropertyKey);
		mv.addObject("property", unlivableDAO.getPropertyByKeyNum(selectedPropertyKey));
		if (choice.equals("update")) {
			mv.setViewName("update.jsp");
		} else if (choice.equals("delete")) {
//			unlivableDAO.deleteProperty(selectedPropertyKey);
			mv.setViewName("confirmation.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "DeleteProperty.do", method = RequestMethod.GET)
	public ModelAndView deleteProperty(@RequestParam("choice") String choice,
			@RequestParam("selectedPropertyKey") String selectedPropertyKey) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("selectedPropertyKey", selectedPropertyKey);
		if (choice.equals("delete")) {
			unlivableDAO.deleteProperty(selectedPropertyKey);
		}
		mv.setViewName("delete.jsp");
		return mv;
	}

	@RequestMapping(path = "ModifyProperty.do", method = RequestMethod.POST)
	public ModelAndView modifyProperty(Property property, Address address, ArrayList<Bedroom> bedrooms) {
		property.setAddress(address);
		property.setBedrooms(bedrooms);
		System.out.println(property);
		unlivableDAO.addProperty(property);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review.jsp");
		mv.addObject("property", property);
		return mv;
	}

	@RequestMapping(path = "GetPropertyData.do", params = "keyNum", method = RequestMethod.GET)
	public ModelAndView queryPropertyByKeyNum(@RequestParam("keyNum") String keyNum) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("property", unlivableDAO.getPropertyByKeyNum(keyNum));
		mv.setViewName("result.jsp");
		return mv;
	}

	@RequestMapping(path = "AddPropertyData.do", method = RequestMethod.POST)
	public ModelAndView createNewProperty(Address address) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add-details.jsp");
		mv.addObject("address", address);
		return mv;
	}

	@RequestMapping(path = "AddPropertyDetails.do", method = RequestMethod.POST)
	public ModelAndView addPropertyDetails(Property property, @ModelAttribute("address") Address address,
			@RequestParam("addBedroom") String addBedroom) {
		ModelAndView mv = new ModelAndView();
		property.setAddress(address);
		unlivableDAO.addProperty(property);
		if (Boolean.parseBoolean(addBedroom)) {
			property.populateBedrooms();
			mv.setViewName("add-bedroom.jsp");
			mv.addObject("sessionProperty", property);
		} else {
			mv.setViewName("review.jsp");
			mv.addObject("property", property);
		}
		return mv;
	}

	@RequestMapping(path = "AddPropertyBedroom.do", method = RequestMethod.POST)
	public ModelAndView addPropertyBedroom(@ModelAttribute("sessionProperty") Property property,
			ArrayList<Bedroom> bedrooms) {
		for (Bedroom bedroom : bedrooms) {
			System.out.println(bedroom);
		}
		property.setBedrooms(bedrooms);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("review.jsp");
		mv.addObject("property", property);
		return mv;
	}

	@RequestMapping(path = "CompareProperties.do", method = RequestMethod.POST)
	public ModelAndView compareProperties(Property property, @ModelAttribute("address") Address address,
			@RequestParam("addBedroom") String addBedroom) {
		ModelAndView mv = new ModelAndView();
		property.setAddress(address);
		unlivableDAO.addProperty(property);
		if (Boolean.parseBoolean(addBedroom)) {
			property.populateBedrooms();
			mv.setViewName("add-bedroom.jsp");
			mv.addObject("sessionProperty", property);
		} else {
			mv.setViewName("review.jsp");
			mv.addObject("property", property);
		}
		return mv;
	}
}
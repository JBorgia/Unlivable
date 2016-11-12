package controllers;

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
@SessionAttributes("address")
public class UnlivableController {
	@Autowired
	private UnlivableDAO unlivableDAO;
	
	@ModelAttribute("address")
	public Address initAddress(){
		return new Address();
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
	public ModelAndView addPropertyDetails(Property property,@RequestParam("addBedroom") String addBedroom) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(mv.getModel().get("address"));
		
		unlivableDAO.addProperty(property);
		mv.addObject("property", property);
		if (Boolean.parseBoolean(addBedroom)) {
			mv.setViewName("add-bedroom.jsp");
		} else {
			mv.setViewName("review.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "AddPropertyBedroom.do", method = RequestMethod.POST)
	public ModelAndView addPropertyBedroom(Property property, Bedroom bedroom) {
		unlivableDAO.addProperty(property);
		return queryPropertyByKeyNum(unlivableDAO.getKeyNumOfProperty(property));
	}
}
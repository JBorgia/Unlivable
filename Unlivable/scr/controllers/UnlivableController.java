package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Property;
import data.UnlivableDAO;

@Controller
@SessionAttributes("Property")
public class UnlivableController {
	@Autowired
	private UnlivableDAO unlivableDAO;

	@RequestMapping(path = "GetPropertyData.do", params = "streetNum", method = RequestMethod.GET)
	public ModelAndView queryPropertyByName(	@RequestParam("streetNum") String streetNum,
												@RequestParam("nsew") String nsew,
												@RequestParam("streetName") String streetName,
												@RequestParam("unit") String unit,
												@RequestParam("city") String city,
												@RequestParam("stateAbbr") String stateAbbr,
												@RequestParam("zip") String zip) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("properties", unlivableDAO.getPropertyByAddress(streetNum, nsew, streetName, unit, city, stateAbbr, zip));
		mv.setViewName("result.jsp");
		return mv;
	}

	@RequestMapping(path = "GetPropertyData.do", params = "keyNum", method = RequestMethod.GET)
	public ModelAndView queryPropertyByAbbreviation(@RequestParam("keyNum") String keyNum) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping(path = "NewProperty.do", method = RequestMethod.POST)
	public ModelAndView createNewProperty(Property Property) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
}
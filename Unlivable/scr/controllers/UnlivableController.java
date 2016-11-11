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

	@RequestMapping(path = "GetPropertyData.do", params = "name", method = RequestMethod.GET)
	public ModelAndView queryPropertyByName(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping(path = "GetPropertyData.do", params = "abbr", method = RequestMethod.GET)
	public ModelAndView queryPropertyByAbbreviation(@RequestParam("abbr") String abbr) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping(path = "GetPropertyData.do", params = "capital", method = RequestMethod.GET)
	public ModelAndView queryPropertyByCapital(@RequestParam("capital") String capital) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping(path = "SlideProperty.do", params = "slide", method = RequestMethod.GET)
	public ModelAndView querySlideProperty(@RequestParam("slide") String slide, @ModelAttribute("Property") Property Property) {
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
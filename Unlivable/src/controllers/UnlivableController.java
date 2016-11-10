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
@SessionAttributes("state")
public class UnlivableController {
	@Autowired
	private UnlivableDAO stateDAO;

	@ModelAttribute("state")
	public Property initSessionObject() {
		Property state = stateDAO.getStateByNumber(0);
		return state;
	}

	@RequestMapping(path = "GetStateData.do", params = "name", method = RequestMethod.GET)
	public ModelAndView queryStateByName(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("state", stateDAO.getStateByName(name));
		mv.addObject("name", name);
		System.out.println("inside queryStateByName");
		return mv;
	}

	@RequestMapping(path = "GetStateData.do", params = "abbr", method = RequestMethod.GET)
	public ModelAndView queryStateByAbbreviation(@RequestParam("abbr") String abbr) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("state", stateDAO.getStateByAbbreviation(abbr));
		mv.addObject("abbr", abbr);
		System.out.println("inside queryStateByAbbr");
		return mv;
	}

	@RequestMapping(path = "GetStateData.do", params = "capital", method = RequestMethod.GET)
	public ModelAndView queryStateByCapital(@RequestParam("capital") String capital) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("state", stateDAO.getStateByCapital(capital));
		mv.addObject("capital", capital);
		System.out.println("inside queryStateByCapital");
		return mv;
	}

	@RequestMapping(path = "SlideState.do", params = "slide", method = RequestMethod.GET)
	public ModelAndView querySlideState(@RequestParam("slide") String slide, @ModelAttribute("state") Property state) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		if (slide.equals("Next") && stateDAO.getStateNumber(state) < 50)
			mv.addObject("state", stateDAO.getStateByNumber(stateDAO.getStateNumber(state) + 1));
		if (slide.equals("Prev") && stateDAO.getStateNumber(state) > 0)
			mv.addObject("state", stateDAO.getStateByNumber(stateDAO.getStateNumber(state) - 1));
		System.out.println("inside querySlideState  " + slide);
		return mv;
	}

	@RequestMapping(path = "NewState.do", method = RequestMethod.POST)
	public ModelAndView createNewState(Property state) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		stateDAO.addState(state);
		mv.addObject("state", state);
		return mv;
	}
}
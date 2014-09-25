package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alitvin on 9/18/2014.
 */
@Controller
@RequestMapping("/index")
public class HomeController {
	public static Integer page =0;
	public static Integer pageMax =0;

	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("message", "AddBook page was pressed");
		return "index";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(ModelMap model) {
		model.addAttribute("message", "AddBook page was pressed");
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String viewDetails(ModelMap model) {
		model.addAttribute("message", "AddBook page was pressed");
		return "index";
	}

}

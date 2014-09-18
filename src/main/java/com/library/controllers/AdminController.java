package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alitvin on 9/18/2014.
 */
@Controller
@RequestMapping("/adminPage")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String admin(ModelMap model) {
		model.addAttribute("message", "AddBook page was pressed");
		return "adminPage";
	}
}

package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alitvin on 8/22/2014.
 */

@Controller
@RequestMapping("/book")
public class BookController {

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ModelMap model) {
		model.addAttribute("message", "Button was pressed");
		return "addBook";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String book(ModelMap model) {
		model.addAttribute("message", "AddBook page was pressed");
		return "addBook";
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String findBook(ModelMap model) {
		model.addAttribute("message", "AddBook page was pressed");
		return "addBook";
	}

}

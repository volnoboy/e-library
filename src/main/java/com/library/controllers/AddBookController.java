package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Properties;

/**
 * Created by alitvin on 8/22/2014.
 */

@Controller
public class AddBookController {

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String pressButton(ModelMap model){
		model.addAttribute("message", "Book was added");
		return "addBooks";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(ModelMap model){
		model.addAttribute("message", "Button was pressed");
		return "addBooks.jsp";
	}


}

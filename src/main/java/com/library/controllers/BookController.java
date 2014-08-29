package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alitvin on 8/22/2014.
 */

@Controller()
@RequestMapping("/book")
public class BookController {

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(ModelMap model) {
        model.addAttribute("message", "Button was pressed");
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String hello(ModelMap model) {
		model.addAttribute("message", "AddBook page was pressed");
		return "hello";
    }


}

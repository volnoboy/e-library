package com.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by alitvin on 8/22/2014.
 */
@Controller()
@RequestMapping(value = "/userPage")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public String userInfo(ModelMap modelMap){
		modelMap.addAttribute("message", "Page was selected");
		return "hello";
	}
}

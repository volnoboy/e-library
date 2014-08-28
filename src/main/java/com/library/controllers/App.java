package com.library.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alitvin on 8/26/2014.
 */
@ComponentScan
@EnableAutoConfiguration
public class App {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
}

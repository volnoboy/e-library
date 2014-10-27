package com.library.controllers;

import com.library.model.Author;
import com.library.model.Publisher;
import com.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by alitvin on 10/24/2014.
 */
@Controller
@RequestMapping("/publisher")
public class PublisherController {
	@Autowired private PublisherRepository publisherRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAuthors() {
		List<Publisher> publishers = publisherRepository.findAll();
		return new ModelAndView("publisherInfo", "publishers", publishers);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Publisher publisher) {
		publisherRepository.save(publisher);
		List<Publisher> publishers = publisherRepository.findAll();
		return new ModelAndView("publisherInfo", "publishers", publishers);
	}

	@RequestMapping(value = "/{name}",method = RequestMethod.GET)
	public Publisher getAuthors(@PathVariable String name) {
		return publisherRepository.findByName(name);
	}
}

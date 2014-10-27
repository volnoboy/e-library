package com.library.controllers;

import com.library.model.Author;
import com.library.model.Book;
import com.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alitvin on 10/24/2014.
 */
@Controller
@RequestMapping("/author")
public class AuthorController {
	@Autowired private AuthorRepository authorRepository;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAuthors() {
		Page<Author> authors=authorRepository.findAll(new PageRequest(0, 10));
		return new ModelAndView("authorInfo","authors", authors.getContent());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Author author) {
		authorRepository.save(author);
		Page<Author> authors=authorRepository.findAll(new PageRequest(0, 10));
		return new ModelAndView("authorInfo","authors", authors.getContent());
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public List<Author> getAuthor(Author author) {
		return authorRepository.findByFirstnameOrLastname("","");
	}

}




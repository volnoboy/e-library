package com.library.controllers;


import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Publisher;
import com.library.model.User;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.PublisherRepository;
import com.sun.net.httpserver.HttpsParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by alitvin on 8/22/2014.
 */

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddBook() {
        ModelAndView model = new ModelAndView("addBook");
        model.addObject("authors", authorRepository.findAll());
        model.addObject("publishers", publisherRepository.findAll());
        return model;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ModelAndView findBook(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "page", required = false) int page/*index*/) {
        /*if (page != null) {
			HomeController.page = Integer.parseInt(page);
		} else {
			HomeController.page = 0;
		}*/
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Book> books = bookRepository.findByTitleOrIsbn(name, name, new PageRequest(HomeController.page, 1));
        HomeController.pageMax = books.getTotalPages();
        modelAndView.addObject("book", books.getContent());
        modelAndView.addObject("pageNext", "/book/find?name=" + name + "&page=" + (HomeController.page + 1));
        modelAndView.addObject("pagePrev", "/book/find?name=" + name + "&page=" + (HomeController.page - 1));
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView info(@PathVariable String id) {
        ModelAndView model = new ModelAndView("bookInfo");
        if (bookRepository.exists(id)) {
            model.addObject("state", "Book found in database");
            model.addObject("book", bookRepository.findOne(id));
        } else {
            model.addObject("state", "Book was not in database");
        }
        return model;
    }
}




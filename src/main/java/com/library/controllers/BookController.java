package com.library.controllers;

import com.library.SetAuthors;
import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Publisher;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by alitvin on 8/22/2014.
 */

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired private PublisherRepository publisherRepository;
	@Autowired private AuthorRepository    authorRepository;
	@Autowired private BookRepository      bookRepository;
	@Autowired private MongoTemplate       mongoTemplate;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, ModelMap model) {
		String paramAuthors= request.getParameter("authors");
		SetAuthors<Author> set = new SetAuthors<Author>();
		String[] authors = paramAuthors.split(";");
		for (int i=0; i<authors.length; i++) {
			set.add(new Author(authors[i].split(" ")[0], authors[i].split(" ").length==2?authors[i].split(" ")[1]:""));
		}
		Publisher p = new Publisher(request.getParameter("publisher"));
		Book book = new Book(set, p, request.getParameter("title"), request.getParameter("isbn"));
		model.addAttribute("state", "Book was in database");
		if (mongoTemplate.findOne(query(where("isbn").is(request.getParameter("isbn"))), Book.class) == null) {
			publisherRepository.save(p);
			for (Author a:set) {
				authorRepository.save(a);
			}
			bookRepository.save(book);
			model.addAttribute("state", "Book was added");
		}
		model.addAttribute("book", book);
		return "bookInfo";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getAddBook() {
		return "addBook";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView findBook(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "page", required = false) String page) {
		if (page != null) {
			HomeController.page = Integer.parseInt(page);
		} else {
			HomeController.page = 0;
		}
		ModelAndView modelAndView = new ModelAndView("index");
		Page<Book> books = bookRepository.findByTitleOrIsbn(name, name, new PageRequest(HomeController.page, 1));
		HomeController.pageMax=books.getTotalPages();
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

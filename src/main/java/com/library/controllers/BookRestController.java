package com.library.controllers;

import com.library.model.Author;
import com.library.model.Book;
import com.library.model.Publisher;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;
import com.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alitvin on 11/3/2014.
 */
@Controller
@RequestMapping("/bookRest")
public class BookRestController {
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public
    @ResponseBody
    String save(BookDTO bookDTO) {
        final Publisher publisher = publisherRepository.findOne(bookDTO.getPublisherId());
        Set<Author> authorSet = new HashSet<>();
        for (int i = 0; i < bookDTO.getAuthorIds().length; i++) {
            authorSet.add(authorRepository.findOne(bookDTO.getAuthorIds()[i]));
        }
        final Book book = bookRepository.save(new Book(authorSet, publisher, bookDTO.getTitle(), bookDTO.getIsbn()));
        return book.getObjectId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Book info(@PathVariable String id) {
        return bookRepository.findOne(id);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Book> findBook(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "page", required = false) int page/*index*/) {
        Page<Book> books = bookRepository.findByTitleOrIsbn(name, name, new PageRequest(HomeController.page, 1));
        return books;
    }
}

class BookDTO {

    private String[] authorIds;
    private String publisherId;
    private String title;
    private String isbn;

    public String[] getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(String[] authorIds) {
        this.authorIds = authorIds;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

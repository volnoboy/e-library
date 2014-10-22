package com.library.model;


import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Created by Dmytro on 8/4/2014.
 */
@Document
public class Book extends AbstractDocument {
	@DBRef
	private Set<Author> authors;
	@DBRef
	private Publisher          publisher;
	private String             title;
	private String             isbn;

	public Book() {
	}

	public Book(Set<Author> authors, Publisher publisher, String title, String ISBN) {
		this.authors = authors;
		this.publisher = publisher;
		this.title = title;
		this.isbn = ISBN;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!isbn.equals(book.isbn)) return false;
        if (!authors.equals(book.authors)) return false;
        if (!publisher.equals(book.publisher)) return false;
        if (!title.equals(book.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authors.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + isbn.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", publisher=" + publisher +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

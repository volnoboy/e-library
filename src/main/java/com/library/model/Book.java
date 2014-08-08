package com.library.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmytro on 8/4/2014.
 */
@Document
public class Book extends AbstractDocument {
    private Set<Author> authors;
    private Publisher publisher;
    private String title;
    private String ISBN;

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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!ISBN.equals(book.ISBN)) return false;
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
        result = 31 * result + ISBN.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors +
                ", publisher=" + publisher +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}

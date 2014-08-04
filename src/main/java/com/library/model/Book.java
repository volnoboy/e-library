package com.library.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmytro on 8/4/2014.
 */
public class Book {
    private int id;
    private Order order;
    private Set<Author> authors = new HashSet<Author>();
    private Publisher publisher;
    private String Title;
    private Date publishedDate;
    private int pages;
    private String language;

    public void addAuthor(Author author) {
        this.getAuthors().add(author);
        author.addBook(this);
    }

    public Book(int id, Order order, Publisher publisher, String title, Date publishedDate, int pages, String language) {
        this.id = id;
        this.order = order;
        this.publisher = publisher;
        Title = title;
        this.publishedDate = publishedDate;
        this.pages = pages;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pages != book.pages) return false;
        if (!Title.equals(book.Title)) return false;
        if (authors != null ? !authors.equals(book.authors) : book.authors != null) return false;
        if (!language.equals(book.language)) return false;
        if (!order.equals(book.order)) return false;
        if (!publishedDate.equals(book.publishedDate)) return false;
        if (!publisher.equals(book.publisher)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + order.hashCode();
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + publisher.hashCode();
        result = 31 * result + Title.hashCode();
        result = 31 * result + publishedDate.hashCode();
        result = 31 * result + pages;
        result = 31 * result + language.hashCode();
        return result;
    }
}

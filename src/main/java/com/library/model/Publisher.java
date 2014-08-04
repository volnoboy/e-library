package com.library.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmytro on 8/4/2014.
 */
public class Publisher {
    private int id;
    private String name;
    private Date founded;
    private String Location;
    private Set<Book> books = new HashSet<Book>();

    public Publisher(int id, String name, Date founded, String location) {
        this.id = id;
        this.name = name;
        this.founded = founded;
        Location = location;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setPublisher(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (id != publisher.id) return false;
        if (!Location.equals(publisher.Location)) return false;
        if (books != null ? !books.equals(publisher.books) : publisher.books != null) return false;
        if (!founded.equals(publisher.founded)) return false;
        if (!name.equals(publisher.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + founded.hashCode();
        result = 31 * result + Location.hashCode();
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}

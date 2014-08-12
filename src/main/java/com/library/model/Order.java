package com.library.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Dmytro on 8/4/2014.
 */
@Document
public class Order extends AbstractDocument {
    @DBRef
    private User user;
    @DBRef
    private Book book;
    private Status status;
    private Date startDate;
    private Date endDate;

	public Order(User user, Book book, Status status, Date startDate, Date endDate) {
		this.user = user;
		this.book = book;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Order() {
	}

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!book.equals(order.book)) return false;
        if (!endDate.equals(order.endDate)) return false;
        if (!startDate.equals(order.startDate)) return false;
        if (status != order.status) return false;
        if (!user.equals(order.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + book.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", book=" + book +
                ", status=" + status +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

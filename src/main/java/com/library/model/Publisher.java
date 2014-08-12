package com.library.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmytro on 8/4/2014.
 */
@Document
public class Publisher extends AbstractDocument{
    private String name;

	public Publisher(String name) {
		this.name = name;
	}

	public Publisher() {
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (!name.equals(publisher.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                '}';
    }
}

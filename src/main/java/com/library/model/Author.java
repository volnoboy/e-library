package com.library.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Author extends AbstractDocument {
    private String firtname;
    private String lastname;

    public Author(String firtname, String lastname) {
        this.firtname = firtname;
        this.lastname = lastname;
    }

    public Author() {
    }

    public String getFirtname() {
        return firtname;
    }

    public void setFirtname(String firtname) {
        this.firtname = firtname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;
        if (!firtname.equals(author.firtname)) return false;
        if (!lastname.equals(author.lastname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firtname.hashCode();
        result = 31 * result + lastname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firtname='" + firtname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

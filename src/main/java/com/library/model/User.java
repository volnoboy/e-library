package com.library.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Dmytro on 8/4/2014.
 */
@Document
public class User extends AbstractDocument {
    private UserType userType;
    private String login;
    private String password;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (userType != user.userType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userType.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userType=" + userType +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.library.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmytro on 8/4/2014.
 */
public class User {
    private int id;
    private UserType userType;
    private String login;
    private String password;
    private Set<Order> orders = new HashSet<Order>();

    public User(int id, UserType userType, String login, String password) {
        this.id = id;
        this.userType = userType;
        this.login = login;
        this.password = password;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        order.setUser(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!login.equals(user.login)) return false;
        if (orders != null ? !orders.equals(user.orders) : user.orders != null) return false;
        if (!password.equals(user.password)) return false;
        if (userType != user.userType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userType.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }
}

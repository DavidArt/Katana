package com.davidrus.katana.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by david on 22-May-17.
 */
@Getter
@Setter
public class User {

    private long id;

    private String name;

    private String email;

    private String password;

    private List<Company> companiesOwned;

    private List<Review> reviews;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", companiesOwned=" + companiesOwned +
                ", reviews=" + reviews +
                '}';
    }
}

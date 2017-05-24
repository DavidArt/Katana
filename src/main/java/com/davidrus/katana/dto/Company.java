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
public class Company {

    private long id;

    private String name;

    private String address;

    private List<Review> review;

    private User owner;

    public String toString() {
        return "CompanyDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", review=" + review +
                ", owner=" + owner +
                '}';
    }
}

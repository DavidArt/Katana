package com.davidrus.katana.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by david on 22-May-17.
 */
@Getter
@Setter
public class Review {

    private long id;

    private String reviewContent;

    private Company company;

    private User user;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewContent='" + reviewContent + '\'' +
                ", company=" + company +
                ", user=" + user +
                '}';
    }
}

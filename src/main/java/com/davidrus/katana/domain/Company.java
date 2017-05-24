package com.davidrus.katana.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by david on 22-May-17.
 */
@Getter
@Setter
@Entity
@NamedQueries({
        @NamedQuery(name = Company.GET_COMPANY_BY_ID, query = "SELECT c FROM Company c WHERE c.id = :id"),
        @NamedQuery(name = Company.GET_COMPANY_BY_NAME, query = "SELECT c FROM Company c WHERE c.name = :name")
})
public class Company {

    public static final String GET_COMPANY_BY_ID = "getCompanyById";
    public static final String GET_COMPANY_BY_NAME = "getCompanyByName";

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String address;

    @OneToMany
    private List<Review> review;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Override
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

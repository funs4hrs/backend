package com.funs4hrs.domain.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity
public class Company extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long Id;
    @Getter
    private String Name;
    @Getter
    private String Adress;
    @Getter
    private String City;
    @Getter
    private String TaxNumber;

    public Company() {
    }

    public Company(String name, String adress, String city, String taxNumber) {
        Name = name;
        Adress = adress;
        City = city;
        TaxNumber = taxNumber;
    }

    public Link getId() {
        return new Link(Long.toString(Id));
    }
}

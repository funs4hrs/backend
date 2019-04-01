package com.funs4hrs.domain.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Company extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String Name;
    private String Adress;
    private String City;
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

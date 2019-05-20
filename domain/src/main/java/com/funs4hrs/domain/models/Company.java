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
    private Long id;
    @Getter
    private String name;
    @Getter
    private String adress;
    @Getter
    private String city;
    @Getter
    private String taxNumber;

    public Company() {
    }

    public Company(String name, String adress, String city, String taxNumber) {
        this.name = name;
        this.adress = adress;
        this.city = city;
        taxNumber = taxNumber;
    }

}

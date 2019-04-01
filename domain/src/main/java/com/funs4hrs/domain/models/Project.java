package com.funs4hrs.domain.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity
@Getter
public class Project extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @OneToOne
    private Company Owner;
    private String Description;
    private String Name;
    private double Payout;
    private boolean Internal;

    public Project() {
    }

    public Project(Company owner, String description, String name, double payout, boolean internal) {
        Owner = owner;
        Description = description;
        Name = name;
        Payout = payout;
        Internal = internal;
    }

    public Link getId() {
        return new Link(Long.toString(Id));
    }
}

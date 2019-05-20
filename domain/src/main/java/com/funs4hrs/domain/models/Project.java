package com.funs4hrs.domain.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity
public class Project extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long Id;
    @Getter
    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Company Owner;
    @Getter
    private String Description;
    @Getter
    private String Name;
    @Getter
    private double Payout;
    @Getter
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

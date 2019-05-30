package com.funs4hrs.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonSerialize
    private Long id;
    @Getter
    @OneToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private Company owner;
    @Getter
    private String description;
    @Getter
    private String name;
    @Getter
    private double payout;
    @Getter
    private boolean internal;
    @Getter
    @OneToMany
    @JoinTable(name = "user_to_project", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<User> users;

    public Project() {
    }

    public Project(Company owner, String description, String name, double payout, boolean internal) {
        this.owner = owner;
        this.description = description;
        this.name = name;
        this.payout = payout;
        this.internal = internal;
    }
}

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
    @Column(name = "id", updatable = false, nullable = false)
    @JsonSerialize
    private Long id;
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
    @Getter
    @OneToMany
    @JoinTable(name = "user_to_project", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<User> users;

    public Project() {
    }

    public Project(Company owner, String description, String name, double payout, boolean internal) {
        Owner = owner;
        Description = description;
        Name = name;
        Payout = payout;
        Internal = internal;
    }
}

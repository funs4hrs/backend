package com.funs4hrs.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
@Setter
public class Project extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
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
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @Getter
//    @ManyToMany(mappedBy = "projects")
//    @JsonIgnoreProperties("projects")
//    @OrderBy("id")
    @Getter
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "user_to_project", inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id_user"), joinColumns = @JoinColumn(name = "project_id",referencedColumnName = "id_project"))
    @JsonIgnoreProperties("users")
    @OrderBy("id")
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

    public Long getIdentifier() {
        return id;
    }
}

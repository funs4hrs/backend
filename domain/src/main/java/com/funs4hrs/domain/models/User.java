package com.funs4hrs.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "User")
@Setter
public class User extends ResourceSupport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", updatable = false, nullable = false)
    @JsonSerialize
    private Long id;
    @Getter
    private String firstName;
    @Getter
    private String lastName;
    @Getter
    private String email;
    @Getter
    private String password;
    @Getter
    private Double hourlyWage;
    @Getter
    private String adress;
    @Getter
    private String city;
    @Getter
    private Boolean isManager;
    @Getter
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    @JoinTable(name = "user_to_project", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id_user"), inverseJoinColumns = @JoinColumn(name = "project_id",referencedColumnName = "id_project"))
    @JsonIgnoreProperties("users")
    @OrderBy("id")
    private List<Project> projects;
    @Getter
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "attendance", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @OneToMany
    @JsonIgnoreProperties("users")
    @OrderBy("id")
    private List<Attendance> attendances;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Double hourlyWage, String adress, String city, Boolean isManager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.hourlyWage = hourlyWage;
        this.adress = adress;
        this.city = city;
        this.isManager = isManager;
    }


    @JsonIgnore
    public Long getIdentifier() {
        return id;
    }
}

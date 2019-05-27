package com.funs4hrs.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
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
    @Column(name = "id", updatable = false, nullable = false)
    @JsonSerialize
    private Long id;
    @Getter
    private String FirstName;
    @Getter
    private String LastName;
    @Getter
    private String Email;
    @Getter
    private String Password;
    @Getter
    private Double HourlyWage;
    @Getter
    private String Adress;
    @Getter
    private String City;
    @Getter
    private Boolean IsManager;
    @Getter
    @OneToMany
    @JoinTable(name = "user_to_project", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Project> projects;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Double hourlyWage, String adress, String city, Boolean isManager) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        HourlyWage = hourlyWage;
        Adress = adress;
        City = city;
        IsManager = isManager;
    }

}

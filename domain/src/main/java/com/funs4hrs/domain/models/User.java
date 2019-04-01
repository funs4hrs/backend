package com.funs4hrs.domain.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "User")
public class User extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
    private double HourlyWage;
    private String Adress;
    private String City;
    private boolean IsManager;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, double hourlyWage, String adress, String city, boolean isManager) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Password = password;
        HourlyWage = hourlyWage;
        Adress = adress;
        City = city;
        IsManager = isManager;
    }

    public Link getId() {
        return new Link(Long.toString(Id));
    }
}

package com.funs4hrs.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import javax.persistence.*;

@Entity(name = "user_to_project")
public class UserToProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    @JsonSerialize
    private Long id;

    @Getter
    @ManyToOne
    @JoinTable(name = "user", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private User user;


    @Getter
    @ManyToOne
    @JoinTable(name = "project", joinColumns = @JoinColumn(name = "project_id"),inverseJoinColumns = @JoinColumn(name = "id"))
    private Project project;
}

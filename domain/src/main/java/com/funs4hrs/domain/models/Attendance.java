package com.funs4hrs.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Attendance extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    @JsonSerialize
    private Long id;

    @Getter
    @OneToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id_project")
    private Project project;


    @Getter
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;

    @Getter
    private Date start_time;
    @Getter
    private Date end_time;

    public Long getIdentifier() {
        return id;
    }

    public Attendance() {
    }

    public Attendance(Date startTime, Date endTime) {
        start_time = startTime;
        end_time = endTime;
    }


}


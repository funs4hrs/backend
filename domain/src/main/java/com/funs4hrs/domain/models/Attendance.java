package com.funs4hrs.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Attendance extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    @JsonSerialize
    private Long id;
    @Getter
    private Date start_time;
    @Getter
    private Date end_time;

    public Attendance() {
    }

    public Attendance(Date startTime, Date endTime) {
        start_time = startTime;
        end_time = endTime;
    }


}


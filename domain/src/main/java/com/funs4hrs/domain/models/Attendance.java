package com.funs4hrs.domain.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Attendance extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


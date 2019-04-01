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
@Getter
public class Attendance extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private Date StartTime;
    private Date EndTime;

    public Attendance() {
    }

    public Attendance(Date startTime, Date endTime) {
        StartTime = startTime;
        EndTime = endTime;
    }


    public Link getId() {
        return new Link(Long.toString(Id));
    }
}


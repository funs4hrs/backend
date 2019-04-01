package com.funs4hrs.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Test extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String content;

    @Override
    public Link getId() {
        return new Link(Long.toString(Id));
    }

    public Test() {
    }

    public Test(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Test{" +
                "Id=" + Id +
                ", content='" + content + '\'' +
                '}';
    }
}

package com.funs4hrs.logic.components;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.Project;
import com.funs4hrs.persistence.services.ProjectService;
import com.funs4hrs.persistence.services.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectComponent {

    @Setter
    private ProjectService service;

    public ProjectComponent() {
    }

    @Autowired
    public ProjectComponent(ProjectService service) {
        this.service = service;
    }
}

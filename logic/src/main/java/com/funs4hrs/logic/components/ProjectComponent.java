package com.funs4hrs.logic.components;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.Project;
import com.funs4hrs.domain.models.User;
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

    public Project join(Long projectId, User user){
        Project project = service.read(projectId);

        System.out.println(project.getUsers().size());
        project.getUsers().add(user);
        System.out.println(project.getUsers().size());

        Project p = service.update(project);

        System.out.println(p);

        return project;
    }
}

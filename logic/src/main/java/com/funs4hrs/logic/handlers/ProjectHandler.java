package com.funs4hrs.logic.handlers;

import com.funs4hrs.domain.interfaces.logic.IHandlerCRUD;
import com.funs4hrs.domain.interfaces.logic.components.IUserComponent;
import com.funs4hrs.domain.models.Project;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.logic.components.ProjectComponent;
import com.funs4hrs.logic.components.UserComponent;
import com.funs4hrs.persistence.services.ProjectService;
import com.funs4hrs.persistence.services.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectHandler implements IHandlerCRUD<Project,Long> {

    @Setter
    private ProjectComponent component;

    @Setter
    private ProjectService service;

    public ProjectHandler() {
    }

    @Autowired
    public ProjectHandler(ProjectComponent component, ProjectService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public Project create(Project entity) {
        return service.create(entity);
    }

    @Override
    public Project read(Long id) {
        return service.read(id);
    }

    @Override
    public List<Project> readAll() {
        Iterable<Project> projects = service.readAll();
        List<Project> projectList = new ArrayList<>();

        projects.iterator().forEachRemaining(projectList::add);
        return projectList;
    }

    @Override
    public Project update(Project entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }

    public List<Project> readByUser(User user){
        return service.readByUser(user);
    }
}

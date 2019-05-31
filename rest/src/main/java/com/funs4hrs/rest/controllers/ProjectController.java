package com.funs4hrs.rest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.funs4hrs.domain.interfaces.logic.handlers.IUserHandler;
import com.funs4hrs.domain.interfaces.rest.IRestCRUD;
import com.funs4hrs.domain.interfaces.rest.controllers.IProjectController;
import com.funs4hrs.domain.models.Project;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.logic.handlers.ProjectHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
@RequestMapping("/projects")
public class ProjectController implements IProjectController {

    private ProjectHandler handler;

    Gson gson = new Gson();

    public ProjectController() {
    }

    @Autowired
    public ProjectController(ProjectHandler handler) {
        this.handler = handler;
    }

    @Override
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody String JsonEntity) {
        System.out.println("HALLO");
        Project proj = gson.fromJson(JsonEntity, Project.class);
        Project result = handler.create(proj);
        return new ResponseEntity<>(result,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity read(Long id) {
        Project result = handler.read(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(400));
        }
    }



    @Override
    public ResponseEntity readAll() {
        List<Project> projects = handler.readAll();
        List<Project> tmpProjects = new ArrayList<>();
        for (Project project : projects) {
            tmpProjects.add(project);
        }
        return new ResponseEntity<>(tmpProjects,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity update(String JsonEntity) {
        Project project = handler.update(gson.fromJson(JsonEntity,Project.class));
        return new ResponseEntity<>(project, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity delete(Long id) {
        if (handler.delete(id)){
            return new ResponseEntity<>(true, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<>(false, HttpStatus.valueOf(404));
        }
    }

    @Override
    public ResponseEntity readByUser(String jsonUser) {
        User user = gson.fromJson(jsonUser, User.class);
        return new ResponseEntity<>(handler.readByUser(user), HttpStatus.valueOf(200));
    }
}

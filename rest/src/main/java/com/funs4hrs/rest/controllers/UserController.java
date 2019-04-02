package com.funs4hrs.rest.controllers;

import com.funs4hrs.domain.interfaces.logic.handlers.IUserHandler;
import com.funs4hrs.domain.interfaces.rest.controllers.IUserController;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.logic.handlers.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    private IUserHandler handler;

    public UserController() {
    }

    @Autowired
    public UserController(UserHandler handler) {
        this.handler = handler;
    }

    @Override
    public ResponseEntity login(String email, String password) {
        User user = handler.login(email,password);
        user = addDefaultLinks(user);
        return new ResponseEntity<User>(user, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity create(@RequestBody(required = true)User entity) {
        User result = handler.create(entity);
        result = addDefaultLinks(result);
        return new ResponseEntity<User>(result,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity read(@RequestParam(name = "id", required = true)Long id) {
        User result = handler.read(id);
        if (result != null) {
            result = addDefaultLinks(result);
            return new ResponseEntity<User>(result, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(400));
        }
    }

    @Override
    public ResponseEntity readAll() {
        List<User> users = handler.readAll();
        List<User> tmpUsers = new ArrayList<>();
        for (User user : users) {
            tmpUsers.add(addDefaultLinks(user));
        }
        return new ResponseEntity<List<User>>(tmpUsers,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity update(@RequestBody(required = true)User entity) {
        User user = handler.update(entity);

        user = addDefaultLinks(user);

        return new ResponseEntity<User>(user, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity delete(@RequestParam(name = "id", required = true)Long id) {
        if (handler.delete(id)){
            return new ResponseEntity<Boolean>(true,HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.valueOf(404));
        }
    }

    @Override
    public User addDefaultLinks(User entity){

        entity.add(linkTo(methodOn(UserController.class).create(new User())).withSelfRel());
        entity.add(linkTo(methodOn(UserController.class).read(1L)).withSelfRel());
        entity.add(linkTo(methodOn(UserController.class).readAll()).withSelfRel());
        entity.add(linkTo(methodOn(UserController.class).delete(1L)).withSelfRel());
        entity.add(linkTo(methodOn(UserController.class).login("Email", "Password")).withSelfRel());

        return entity;
    }
}

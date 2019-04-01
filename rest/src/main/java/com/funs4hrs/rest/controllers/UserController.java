package com.funs4hrs.rest.controllers;

import com.funs4hrs.domain.interfaces.logic.handlers.ITestHandler;
import com.funs4hrs.domain.interfaces.logic.handlers.IUserHandler;
import com.funs4hrs.domain.interfaces.rest.IUserController;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.logic.handlers.TestHandler;
import com.funs4hrs.logic.handlers.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity Login(String email, String password) {
        return handler.Login(email,password);
    }

    @Override
    public Long create(User entity) {
        return null;
    }

    @Override
    public User read(long id) {
        return null;
    }

    @Override
    public Iterable readAll() {
        return null;
    }

    @Override
    public Long update(User entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}

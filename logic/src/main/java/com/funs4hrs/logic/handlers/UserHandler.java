package com.funs4hrs.logic.handlers;

import com.funs4hrs.domain.interfaces.logic.components.IUserComponent;
import com.funs4hrs.domain.interfaces.logic.handlers.IUserHandler;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.logic.components.UserComponent;
import com.funs4hrs.persistence.services.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserHandler implements IUserHandler {

    @Setter
    private IUserComponent component;

    @Setter
    private UserService service;

    public UserHandler() {
    }

    @Autowired
    public UserHandler(UserComponent component, UserService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public ResponseEntity Login(String email, String password) {
        return null;
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

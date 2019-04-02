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

import java.util.ArrayList;
import java.util.List;

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
    public User login(String email, String password) {
        return component.login(email,password);
    }

    @Override
    public User create(User entity) {
        return component.create(entity);
    }

    @Override
    public User read(Long id) {
        return service.read(id);
    }

    @Override
    public List<User> readAll() {
        Iterable<User> users = service.readAll();
        List<User> userList = new ArrayList<>();

        users.iterator().forEachRemaining(userList::add);
        return userList;
    }

    @Override
    public User update(User entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}

package com.funs4hrs.logic.components;

import com.funs4hrs.domain.interfaces.logic.components.IUserComponent;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.persistence.services.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserComponent implements IUserComponent {

    @Setter
    private UserService service;

    public UserComponent() {
    }

    @Autowired
    public UserComponent(UserService service) {
        this.service = service;
    }


    @Override
    public User login(String email, String password) {
        return service.login(email,password);
    }

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public Iterable<User> readAll() {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

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
}

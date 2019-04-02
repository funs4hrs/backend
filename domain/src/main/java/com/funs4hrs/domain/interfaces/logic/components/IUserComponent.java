package com.funs4hrs.domain.interfaces.logic.components;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.User;
import org.springframework.http.ResponseEntity;

public interface IUserComponent extends ICRUD<User,Long> {
    User login(String email, String password);

}

package com.funs4hrs.domain.interfaces.logic.handlers;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.User;
import org.springframework.http.ResponseEntity;

public interface IUserHandler extends ICRUD<User,Long> {
    ResponseEntity Login(String email, String password);
}

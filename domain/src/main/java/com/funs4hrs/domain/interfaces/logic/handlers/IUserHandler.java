package com.funs4hrs.domain.interfaces.logic.handlers;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.interfaces.logic.IHandlerCRUD;
import com.funs4hrs.domain.models.User;
import org.springframework.http.ResponseEntity;

public interface IUserHandler extends IHandlerCRUD<User,Long> {
    User login(String email, String password);
}

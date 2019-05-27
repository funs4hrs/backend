package com.funs4hrs.domain.interfaces.logic.components;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.User;

public interface IUserComponent {
    User login(String email, String password);

}

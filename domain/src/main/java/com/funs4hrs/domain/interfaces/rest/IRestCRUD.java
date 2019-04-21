package com.funs4hrs.domain.interfaces.rest;

import com.funs4hrs.domain.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IRestCRUD<T, R> {

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    ResponseEntity create(String JsonEntity);

    @RequestMapping(value = "/read",method = RequestMethod.GET)
    ResponseEntity read(R id);

    @RequestMapping(value = "/readAll",method = RequestMethod.GET)
    ResponseEntity readAll();

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    ResponseEntity update(String JsonEntity);

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    ResponseEntity delete(R id);

    User addDefaultLinks(User entity);
}

package com.funs4hrs.rest.controllers;

import com.funs4hrs.domain.interfaces.logic.handlers.ITestHandler;
import com.funs4hrs.domain.interfaces.rest.controllers.ITestController;
import com.funs4hrs.domain.models.Test;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.logic.handlers.TestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestController implements ITestController {

    private ITestHandler handler;

    public TestController() {
    }

    @Autowired
    public TestController(TestHandler handler) {
        this.handler = handler;
    }

    @Override
    public ResponseEntity create(Test entity) {
        return null;
    }

    @Override
    public ResponseEntity read(Long id) {
        return null;
    }

    @Override
    public ResponseEntity readAll() {
        return null;
    }

    @Override
    public ResponseEntity update(Test entity) {
        return null;
    }

    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }

    @Override
    public User addDefaultLinks(User entity) {
        return null;
    }
}

package com.funs4hrs.rest.controllers;

import com.funs4hrs.domain.interfaces.logic.handlers.ITestHandler;
import com.funs4hrs.domain.interfaces.rest.ITestController;
import com.funs4hrs.domain.models.Test;
import com.funs4hrs.logic.handlers.TestHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Long create(Test entity) {
        return null;
    }

    @Override
    public Test read(long id) {
        return null;
    }

    @Override
    public Iterable readAll() {
        return null;
    }

    @Override
    public Long update(Test entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}

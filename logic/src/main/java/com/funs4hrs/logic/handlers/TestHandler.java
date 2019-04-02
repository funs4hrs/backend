package com.funs4hrs.logic.handlers;

import com.funs4hrs.domain.interfaces.logic.handlers.ITestHandler;
import com.funs4hrs.domain.models.Test;
import com.funs4hrs.logic.components.TestComponent;
import com.funs4hrs.persistence.services.TestService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestHandler implements ITestHandler {

    @Setter
    private TestService service;

    @Setter
    private TestComponent component;

    @Autowired
    public TestHandler(TestComponent component, TestService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public Test create(Test entity) {
        return null;
    }

    @Override
    public Test read(Long id) {
        return null;
    }

    @Override
    public List<Test> readAll() {
        return null;
    }

    @Override
    public Test update(Test entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

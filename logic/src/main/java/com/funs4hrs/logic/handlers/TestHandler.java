package com.funs4hrs.logic.handlers;

import com.funs4hrs.domain.interfaces.logic.handlers.ITestHandler;
import com.funs4hrs.domain.models.Test;
import com.funs4hrs.logic.components.TestComponent;
import com.funs4hrs.persistence.services.TestService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

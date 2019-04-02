package com.funs4hrs.persistence.services;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.Test;
import com.funs4hrs.persistence.repositories.ITestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ICRUD<Test,Long> {

    @Qualifier("TestRepository")
    @Autowired
    private ITestRepository iUserRepository;

    @Override
    public Test create(Test entity) {
        return null;
    }

    @Override
    public Test read(Long id) {
        return null;
    }

    @Override
    public Iterable<Test> readAll() {
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

package com.funs4hrs.persistence.services;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.persistence.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ICRUD<User,Long> {


    @Qualifier("UserRepository")
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Long create(User entity) {
        return null;
    }

    @Override
    public User read(long id) {
        return null;
    }

    @Override
    public Iterable readAll() {
        return null;
    }

    @Override
    public Long update(User entity) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}

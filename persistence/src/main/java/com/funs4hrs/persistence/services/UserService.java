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
    private IUserRepository repository;

    public User login(String email, String password){
        return repository.findByEmailAndPassword(email,password);
    }

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public User read(Long id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            return null;
    }

    @Override
    public Iterable<User> readAll() {
        return repository.findAll();
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}

package com.funs4hrs.persistence.services;

import com.funs4hrs.domain.interfaces.ICRUD;
import com.funs4hrs.domain.models.Company;
import com.funs4hrs.persistence.repositories.ICompanyRepository;
import com.funs4hrs.persistence.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements ICRUD<Company, Long> {

    @Qualifier("CompanyRepository")
    @Autowired
    private ICompanyRepository repository;


    @Override
    public Company create(Company entity) {
        return repository.save(entity);
    }

    @Override
    public Company read(Long id) {
        if (repository.findById(id).isPresent())
            return repository.findById(id).get();
        else
            return null;
    }

    @Override
    public Iterable<Company> readAll() {
        return repository.findAll();
    }

    @Override
    public Company update(Company entity) {
        return repository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}

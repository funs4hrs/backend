package com.funs4hrs.logic.handlers;

import com.funs4hrs.domain.interfaces.logic.IHandlerCRUD;
import com.funs4hrs.domain.models.Company;
import com.funs4hrs.domain.models.Project;
import com.funs4hrs.logic.components.CompanyComponent;
import com.funs4hrs.persistence.services.CompanyService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyHandler implements IHandlerCRUD<Company, Long> {

    @Setter
    private CompanyComponent component;

    @Setter
    private CompanyService service;

    public CompanyHandler() {
    }

    @Autowired
    public CompanyHandler(CompanyComponent component, CompanyService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public Company create(Company entity) {
        return service.create(entity);
    }

    @Override
    public Company read(Long id) {
        return service.read(id);
    }

    @Override
    public List<Company> readAll() {
        Iterable<Company> companies = service.readAll();
        List<Company> companyList = new ArrayList<>();

        companies.iterator().forEachRemaining(companyList::add);
        return companyList;
    }

    @Override
    public Company update(Company entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }
}

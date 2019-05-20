package com.funs4hrs.rest.controllers;

import com.funs4hrs.domain.interfaces.rest.IRestCRUD;
import com.funs4hrs.domain.models.Company;
import com.funs4hrs.domain.models.Project;
import com.funs4hrs.logic.handlers.CompanyHandler;
import com.funs4hrs.logic.handlers.ProjectHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/companies")
public class CompanyController implements IRestCRUD<Company, Long> {

    private CompanyHandler handler;

    Gson gson = new Gson();

    public CompanyController() {
    }

    @Autowired
    public CompanyController(CompanyHandler handler) {
        this.handler = handler;
    }

    @Override
    public ResponseEntity create(String JsonEntity) {
        Company json = gson.fromJson(JsonEntity,Company.class);
        Company result = handler.create(json);
        return new ResponseEntity<>(result, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity read(Long id) {
        Company result = handler.read(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(400));
        }
    }

    @Override
    public ResponseEntity readAll() {
        List<Company> companies = handler.readAll();
        List<Company> tmpCompanies = new ArrayList<>();
        for (Company company : companies) {
            tmpCompanies.add(company);
        }
        return new ResponseEntity<>(tmpCompanies,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity update(String JsonEntity) {
        Company project = handler.update(gson.fromJson(JsonEntity,Company.class));
        return new ResponseEntity<>(project, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity delete(Long id) {
        if (handler.delete(id)){
            return new ResponseEntity<>(true, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<>(false, HttpStatus.valueOf(404));
        }
    }
}

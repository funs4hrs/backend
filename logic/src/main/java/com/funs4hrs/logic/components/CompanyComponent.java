package com.funs4hrs.logic.components;

import com.funs4hrs.persistence.services.CompanyService;
import com.funs4hrs.persistence.services.ProjectService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyComponent {

    @Setter
    private CompanyService service;

    public CompanyComponent() {
    }

    @Autowired
    public CompanyComponent(CompanyService service) {
        this.service = service;
    }

}

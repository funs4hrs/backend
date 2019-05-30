package com.funs4hrs.logic.components;

import com.funs4hrs.persistence.services.AttendanceService;
import com.funs4hrs.persistence.services.CompanyService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttendanceComponent {

    @Setter
    private AttendanceService service;

    public AttendanceComponent() {
    }

    @Autowired
    public AttendanceComponent(AttendanceService service) {
        this.service = service;
    }

}

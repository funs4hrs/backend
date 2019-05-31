package com.funs4hrs.logic.handlers;

import com.funs4hrs.domain.interfaces.logic.IHandlerCRUD;
import com.funs4hrs.domain.interfaces.logic.handlers.IAttendanceHandler;
import com.funs4hrs.domain.models.Attendance;
import com.funs4hrs.domain.models.Company;
import com.funs4hrs.logic.components.AttendanceComponent;
import com.funs4hrs.logic.components.CompanyComponent;
import com.funs4hrs.persistence.services.AttendanceService;
import com.funs4hrs.persistence.services.CompanyService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttendanceHandler implements IAttendanceHandler {

    @Setter
    private AttendanceComponent component;

    @Setter
    private AttendanceService service;

    public AttendanceHandler() {
    }

    @Autowired
    public AttendanceHandler(AttendanceComponent component, AttendanceService service) {
        this.component = component;
        this.service = service;
    }

    @Override
    public Attendance create(Attendance entity) {
        return service.create(entity);
    }

    @Override
    public Attendance read(Long id) {
        return service.read(id);
    }

    @Override
    public List<Attendance> readAll() {
        Iterable<Attendance> attendances = service.readAll();
        List<Attendance> attendanceList = new ArrayList<>();

        attendances.iterator().forEachRemaining(attendanceList::add);
        return attendanceList;
    }

    @Override
    public Attendance update(Attendance entity) {
        return service.update(entity);
    }

    @Override
    public boolean delete(Long id) {
        return service.delete(id);
    }

    @Override
    public Attendance readAllOpenByUserAndProject(Long user, Long project) {
        return service.readAllOpenByUserAndProject(user,project);
    }
}

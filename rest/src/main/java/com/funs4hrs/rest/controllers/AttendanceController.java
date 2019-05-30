package com.funs4hrs.rest.controllers;

import com.funs4hrs.domain.interfaces.rest.IRestCRUD;
import com.funs4hrs.domain.interfaces.rest.controllers.IAttendanceController;
import com.funs4hrs.domain.models.Attendance;
import com.funs4hrs.logic.handlers.AttendanceHandler;
import com.funs4hrs.logic.handlers.CompanyHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200","*"})
@RestController
@RequestMapping("/attendances")
public class AttendanceController implements IAttendanceController {

    private AttendanceHandler handler;

    Gson gson = new Gson();

    public AttendanceController() {
    }

    @Autowired
    public AttendanceController(AttendanceHandler handler) {
        this.handler = handler;
    }

    @Override
    public ResponseEntity create(String JsonEntity) {
        Attendance json = gson.fromJson(JsonEntity,Attendance.class);
        Attendance result = handler.create(json);
        return new ResponseEntity<>(result, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity read(Long id) {
        Attendance result = handler.read(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(400));
        }
    }

    @Override
    public ResponseEntity readAll() {
        List<Attendance> attendances = handler.readAll();
        List<Attendance> tmpAttendances = new ArrayList<>();
        for (Attendance attendance : attendances) {
            tmpAttendances.add(attendance);
        }
        return new ResponseEntity<>(tmpAttendances,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity update(String JsonEntity) {
        Attendance attendance = handler.update(gson.fromJson(JsonEntity,Attendance.class));
        return new ResponseEntity<>(attendance, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity delete(Long id) {
        if (handler.delete(id)){
            return new ResponseEntity<>(true, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<>(false, HttpStatus.valueOf(404));
        }
    }

    @Override
    public ResponseEntity readAllOpenByUserAndProject(Long user, Long project) {
        Attendance att = handler.readAllOpenByUserAndProject(user,project);
        return new ResponseEntity<>(att,HttpStatus.valueOf(200));
    }
}

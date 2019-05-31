package com.funs4hrs.domain.interfaces.rest.controllers;

import com.funs4hrs.domain.interfaces.rest.IRestCRUD;
import com.funs4hrs.domain.models.Attendance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;

public interface IAttendanceController  extends IRestCRUD<Attendance, Long> {
    @RequestMapping(value = "/openByUserAndProject", method = RequestMethod.GET)
    ResponseEntity readAllOpenByUserAndProject(@PathParam("user") Long user,@PathParam("project") Long project);
}

package com.funs4hrs.domain.interfaces.rest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.funs4hrs.domain.interfaces.rest.IRestCRUD;
import com.funs4hrs.domain.models.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IProjectController extends IRestCRUD<Project, Long> {
    @RequestMapping(value = "/byUser", method = RequestMethod.GET)
    ResponseEntity readByUser(String user);
}

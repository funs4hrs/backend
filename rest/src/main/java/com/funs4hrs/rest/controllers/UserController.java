package com.funs4hrs.rest.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.funs4hrs.domain.interfaces.logic.handlers.IUserHandler;
import com.funs4hrs.domain.interfaces.rest.controllers.IUserController;
import com.funs4hrs.domain.models.User;
import com.funs4hrs.logic.handlers.UserHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    private IUserHandler handler;

    Gson gson = new Gson();

    public UserController() {
    }

    @Autowired
    public UserController(UserHandler handler) {
        this.handler = handler;
    }

    @Override
    public ResponseEntity login(@RequestBody ObjectNode node) {
        String email = node.get("email").asText();
        String password = node.get("password").asText();
        User user = handler.login(email,password);
        return new ResponseEntity<User>(user, HttpStatus.valueOf(200));
    }

    public ResponseEntity create(@RequestBody String JsonEntity) {
        User result = handler.create(gson.fromJson(JsonEntity,User.class));
        return new ResponseEntity<>(result,HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity read(Long id) {
        User result = handler.read(id);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(400));
        }
    }

    @Override
    public ResponseEntity readAll() {
        List<User> users = handler.readAll();
        List<User> tmpUsers = new ArrayList<>();
        for (User user : users) {
            tmpUsers.add(user);
        }
        return new ResponseEntity<>(tmpUsers,HttpStatus.valueOf(200));
    }

    public ResponseEntity update(@RequestBody String JsonEntity) {
        User user = handler.update(gson.fromJson(JsonEntity,User.class));
        return new ResponseEntity<>(user, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity delete(@RequestParam(name = "id", required = true)Long id) {
        if (handler.delete(id)){
            return new ResponseEntity<>(true,HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity<>(false, HttpStatus.valueOf(404));
        }
    }

}

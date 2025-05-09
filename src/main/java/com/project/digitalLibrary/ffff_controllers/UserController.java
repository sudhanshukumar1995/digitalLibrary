package com.project.digitalLibrary.ffff_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalLibrary.aaaabbbbb_model.UserModel;
import com.project.digitalLibrary.ddddeeee_inputentities.UserInputEntity;
import com.project.digitalLibrary.eeee_adaptor.CommonAdaptor;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	private final CommonAdaptor<UserInputEntity, UserModel> adapter;

    @Autowired
    public UserController(CommonAdaptor<UserInputEntity, UserModel> adapter) {
        this.adapter = adapter;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserInputEntity userInputEntity) {
        return new ResponseEntity<>(adapter.save(userInputEntity), HttpStatus.CREATED);
    }
}

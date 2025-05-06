package com.project.digitalLibrary.adaptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.digitalLibrary.entities.UserInputEntity;
import com.project.digitalLibrary.mappers.UserInputMapper;
import com.project.digitalLibrary.model.UserModel;

@Component
public class UserAdaptor implements CommonAdaptor<UserInputEntity, UserModel> {

    private final UserInputMapper userInputMapper;
    private final UserService userService;

    @Autowired
    public UserAdaptor(UserInputMapper userInputMapper, UserService userService) {
        this.userInputMapper = userInputMapper;
        this.userService = userService;
    }

    @Override
    public UserModel save(UserInputEntity input) {
        return userService.addUser(this.userInputMapper.mapToModel(input));
    }

    @Override
    public UserModel getById(long id) {
        return null;
    }

    @Override
    public List<UserModel> getAll() {
        return List.of();
    }

    @Override
    public UserModel update(UserInputEntity input) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
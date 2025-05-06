package com.project.digitalLibrary.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.digitalLibrary.entities.UserOutputEntity;
import com.project.digitalLibrary.mappers.UserOutputMapper;
import com.project.digitalLibrary.model.UserModel;
import com.project.digitalLibrary.utils.ResourceNotFoundException;

@Component
public class UserRepository {

    private final UserJPARepository userJPARepository;
    private final UserOutputMapper userOutputMapper;

    @Autowired
    public UserRepository(UserJPARepository userJPARepository, UserOutputMapper userOutputMapper) {
        this.userJPARepository = userJPARepository;
        this.userOutputMapper = userOutputMapper;
    }

    public UserModel addUser(UserModel userModel) {
        UserOutputEntity outputEntity = this.userOutputMapper.mapFromModel(userModel);
        UserOutputEntity savedOutputEntity = this.userJPARepository.save(outputEntity);
        return this.userOutputMapper.mapToModel(savedOutputEntity);
    }

    public UserModel getUserByEmail(String email) {
        return this.userJPARepository.findByEmail(email).map(this.userOutputMapper::mapToModel)
                .orElseThrow(() -> new ResourceNotFoundException(UserModel.class, "email", email));
    }
}

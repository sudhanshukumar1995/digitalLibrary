package com.project.digitalLibrary.mappers;

import org.springframework.stereotype.Component;

import com.project.digitalLibrary.entities.UserInputEntity;
import com.project.digitalLibrary.model.UserModel;

@Component
public class UserInputMapper {
	public UserModel mapToModel(UserInputEntity input) {
        return UserModel.builder()
                .email(input.getEmail())
                .password(input.getPassword())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .role(input.getRole())
                .dob(input.getDateOfBirth().toInstant())
                .build();
    }
}

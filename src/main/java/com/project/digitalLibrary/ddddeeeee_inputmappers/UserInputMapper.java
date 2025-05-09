package com.project.digitalLibrary.ddddeeeee_inputmappers;

import org.springframework.stereotype.Component;

import com.project.digitalLibrary.aaaabbbbb_model.UserModel;
import com.project.digitalLibrary.ddddeeee_inputentities.UserInputEntity;

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

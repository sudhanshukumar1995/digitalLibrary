package com.project.digitalLibrary.bbbb_outputmappers;


import org.springframework.stereotype.Component;

import com.project.digitalLibrary.aaaa_entities.UserOutputEntity;
import com.project.digitalLibrary.aaaabbbbb_model.UserModel;

@Component
public class UserOutputMapper {

    public UserModel mapToModel(UserOutputEntity output) {
        return UserModel.builder()
                .id(output.getId())
                .firstName(output.getFirstName())
                .lastName(output.getLastName())
                .email(output.getEmail())
                .password(output.getPassword())
                .dob(output.getDob())
                .phoneNumber(output.getPhoneNumber())
                .role(output.getRole())
                .build();
    }

    public UserOutputEntity mapFromModel(UserModel userModel) {
        return UserOutputEntity.builder()
                .id(userModel.getId())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .dob(userModel.getDob())
                .phoneNumber(userModel.getPhoneNumber())
                .role(userModel.getRole())
                .build();
    }
}

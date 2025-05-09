package com.project.digitalLibrary.ddddeeee_inputentities;

import java.sql.Date;

import com.project.digitalLibrary.zzzz_utils.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.With;

@Builder
@Data
@With
public class UserInputEntity {
	
	@NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @Size(min = 5)
    private String password;

    
    private Date dateOfBirth;

    @Builder.Default
    private UserRole role = UserRole.USER;

}

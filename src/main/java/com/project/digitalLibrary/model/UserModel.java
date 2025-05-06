package com.project.digitalLibrary.model;

import java.time.Instant;
import java.util.Date;

import com.project.digitalLibrary.entities.UserRole;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Builder
@Data
@With
public class UserModel {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phoneNumber;
	private Instant dob;
	private UserRole role;

	public int getAge() {
		int currentYear = new Date().getYear();
		int yearOfBirth = new Date(this.dob.getNano()).getYear();
		return currentYear - yearOfBirth;
	}
}

package com.project.digitalLibrary.aaaabbbbb_model;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;

import com.project.digitalLibrary.zzzz_utils.UserRole;

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
		int currentYear = Calendar.YEAR;
		int yearOfBirth = ZonedDateTime.ofInstant(dob, ZoneOffset.systemDefault()).getYear();
		return currentYear - yearOfBirth;
	}
}

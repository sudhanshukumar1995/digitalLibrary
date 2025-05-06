package com.project.digitalLibrary.model;

import lombok.Data;

@Data
public class AddressModel {

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String country;
	private long pin;
}

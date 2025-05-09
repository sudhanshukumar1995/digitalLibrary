package com.project.digitalLibrary.aaaa_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class AddressOutputEntity {

	@Id
	@Column(name = "address_id")
	private String address_id;
	
	//foreign key
	@Column(name = "user_id")
	private String user_id;
}

package com.project.digitalLibrary.aaaa_entities;

import java.time.Instant;

import com.project.digitalLibrary.zzzz_utils.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "user")
public class UserOutputEntity {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@OneToOne
	@JoinColumn(name = "user_id")
	private AddressOutputEntity address;

	// foreign key
	@Column(name = "membership_id")
	private long membership_id;
	
	@Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth", nullable = false)
    private Instant dob;

    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "role", nullable = false)
    private UserRole role;
}

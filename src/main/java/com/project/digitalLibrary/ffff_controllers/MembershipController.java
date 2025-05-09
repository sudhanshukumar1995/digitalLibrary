package com.project.digitalLibrary.ffff_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalLibrary.ddddeeee_inputentities.MembershipInputEntity;
import com.project.digitalLibrary.eeee_adaptor.MembershipAdapter;
import com.project.digitalLibrary.zzzz_utils.MembershipException;
import com.project.digitalLibrary.zzzz_utils.MembershipStatus;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/membership")
public class MembershipController {

	private final MembershipAdapter membershipAdapter;

	@Autowired
	public MembershipController(MembershipAdapter membershipAdapter) {
		this.membershipAdapter = membershipAdapter;
	}

	@PostMapping("/add")
	public ResponseEntity<?> addMembership(@Valid @RequestBody MembershipInputEntity membershipInputEntity) {
		try {
			return new ResponseEntity<>(this.membershipAdapter.save(membershipInputEntity), HttpStatus.CREATED);
		} catch (MembershipException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/update/{userId}")
	public ResponseEntity<?> changeMembershipStatus(@PathVariable long userId, @RequestParam MembershipStatus status) {
		if (status == MembershipStatus.EXPIRED) {
			return new ResponseEntity<>("User cannot change the membership status to EXPIRED.", HttpStatus.BAD_REQUEST);
		}
		try {
			return new ResponseEntity<>(this.membershipAdapter.changeMembershipStatus(userId, status), HttpStatus.OK);
		} catch (MembershipException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
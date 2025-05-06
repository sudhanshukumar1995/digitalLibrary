package com.project.digitalLibrary.entities;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "membership")
public class MembershipOutputEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long membership_id;

	//this is how we join to tables
	/*
	 * You meant that one membership has many users Then you need to make user a
	 * collection: And the user table should have a column membership_id pointing
	 * back to membership. Bonus Tips: Avoid using @JoinColumn(name = "id") unless
	 * you're absolutely sure. Usually, foreign keys have different names like
	 * user_id, membership_id, etc.
	 * 
	 * Also, in UserOutputEntity, you're combining @OneToOne, @JoinColumn,
	 * and @Column on the same field. That's not correct. You can't use
	 * both @JoinColumn and @Column on the same field.
	 */	
	@OneToMany
	@JoinColumn(name = "membership_id")
	private List<UserOutputEntity> user;
	
	@Column(name = "start_date")
	private Instant startDate;
	
	@Column(name = "end_date")
	private Instant endDate;
	
	@Column(name = "status")
	private MembershipStatus status;
}

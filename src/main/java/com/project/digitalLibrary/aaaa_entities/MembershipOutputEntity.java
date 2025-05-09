package com.project.digitalLibrary.aaaa_entities;

import java.time.Instant;

import com.project.digitalLibrary.zzzz_utils.MembershipPlan;
import com.project.digitalLibrary.zzzz_utils.MembershipStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "membership")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class MembershipOutputEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private long membership_id;

	// this is how we join to tables
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
	@ManyToOne
	@JoinColumn(name = "membership_id")
	private UserOutputEntity user;

	@Column(name = "start_date")
	private Instant startDate;

	@Column(name = "end_date")
	private Instant endDate;

	@Column(name = "status", nullable = false)
	private MembershipStatus status;

	@Column(name = "plan", nullable = false)
//  @Enumerated(EnumType.ORDINAL)
	private MembershipPlan plan;
}

package com.project.digitalLibrary.aaaabbbbb_model;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.digitalLibrary.zzzz_utils.MembershipPlan;
import com.project.digitalLibrary.zzzz_utils.MembershipStatus;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
@With
public class MembershipModel {

	private long id;

	@JsonIgnore
	private UserModel user;

	private Instant startDate;
	private Instant endDate;
	private MembershipStatus status;
	private MembershipPlan plan;

	@JsonProperty
	public long getUserId() {
		return this.getUser().getId();
	}
}

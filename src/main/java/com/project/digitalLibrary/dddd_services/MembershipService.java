package com.project.digitalLibrary.dddd_services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.digitalLibrary.aaaa_entities.MembershipOutputEntity;
import com.project.digitalLibrary.aaaabbbbb_model.MembershipModel;
import com.project.digitalLibrary.cccc_repository.MembershipRepository;
import com.project.digitalLibrary.zzzz_utils.MembershipException;
import com.project.digitalLibrary.zzzz_utils.MembershipStatus;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MembershipService {

	private final MembershipRepository membershipRepository;

	@Autowired
	public MembershipService(MembershipRepository membershipRepository) {
		this.membershipRepository = membershipRepository;
	}

	public MembershipModel addMembership(MembershipModel membershipModel) {
		if (this.doesUserHaveActiveMembership(membershipModel.getUserId())) {
			throw new MembershipException(membershipModel.getUserId(), true);
		}
		membershipModel = this.membershipRepository.addMembership(membershipModel);
		return membershipModel;
	}

	public MembershipModel updateMembershipStatus(long userId, MembershipStatus status) {
		Optional<MembershipOutputEntity> optional = this.membershipRepository.getNonExpiredMembershipForUser(userId);
		if (optional.isEmpty()) {
			throw new MembershipException(userId, false);
		}
		return this.membershipRepository.updateMembershipStatus(optional.get().getMembership_id(), status);
	}

	private boolean doesUserHaveActiveMembership(long userId) {
		Optional<MembershipOutputEntity> optional = this.membershipRepository.getNonExpiredMembershipForUser(userId);
		if (optional.isPresent()) {
			log.error("The user with ID: {} already has an active membership with ID: {}", userId,
					optional.get().getMembership_id());
			return true;
		}
		log.info("The user with ID: {} does not have an active membership.", userId);
		return false;
	}
}

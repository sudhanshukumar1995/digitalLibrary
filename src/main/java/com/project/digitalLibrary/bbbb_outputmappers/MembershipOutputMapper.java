package com.project.digitalLibrary.bbbb_outputmappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.digitalLibrary.aaaa_entities.MembershipOutputEntity;
import com.project.digitalLibrary.aaaa_entities.UserOutputEntity;
import com.project.digitalLibrary.aaaabbbbb_model.MembershipModel;
import com.project.digitalLibrary.aaaabbbbb_model.UserModel;

@Component
public class MembershipOutputMapper {

	private final UserOutputMapper userOutputMapper;

	@Autowired
	public MembershipOutputMapper(UserOutputMapper userOutputMapper) {
		this.userOutputMapper = userOutputMapper;
	}

	public MembershipModel mapToModel(MembershipOutputEntity outputEntity) {
		UserModel userModel = userOutputMapper.mapToModel(outputEntity.getUser());
		return MembershipModel.builder().id(outputEntity.getMembership_id()).user(userModel).startDate(outputEntity.getStartDate())
				.endDate(outputEntity.getEndDate()).status(outputEntity.getStatus()).plan(outputEntity.getPlan())
				.build();
	}

	public MembershipOutputEntity mapFromModel(MembershipModel model) {
		UserOutputEntity user = userOutputMapper.mapFromModel(model.getUser());
		return MembershipOutputEntity.builder().membership_id(model.getId()).user(user).startDate(model.getStartDate())
				.endDate(model.getEndDate()).status(model.getStatus()).plan(model.getPlan()).build();
	}

}

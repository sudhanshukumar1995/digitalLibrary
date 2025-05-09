package com.project.digitalLibrary.eeee_adaptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.digitalLibrary.aaaabbbbb_model.MembershipModel;
import com.project.digitalLibrary.dddd_services.MembershipService;
import com.project.digitalLibrary.ddddeeee_inputentities.MembershipInputEntity;
import com.project.digitalLibrary.ddddeeeee_inputmappers.MembershipInputMapper;
import com.project.digitalLibrary.zzzz_utils.MembershipStatus;

@Component
public class MembershipAdapter implements CommonAdaptor<MembershipInputEntity, MembershipModel> {

    private final MembershipService membershipService;
    private final MembershipInputMapper membershipInputMapper;

    @Autowired
    public MembershipAdapter(MembershipService membershipService, MembershipInputMapper membershipInputMapper) {
        this.membershipService = membershipService;
        this.membershipInputMapper = membershipInputMapper;
    }

    @Override
    public MembershipModel save(MembershipInputEntity membershipInputEntity) {
        return this.membershipService
                .addMembership(this.membershipInputMapper.mapToModel(membershipInputEntity));
    }

    @Override
    public MembershipModel getById(long id) {
        return null;
    }

    @Override
    public List<MembershipModel> getAll() {
        return List.of();
    }

    @Override
    public MembershipModel update(MembershipInputEntity membershipInputEntity) {
        throw new UnsupportedOperationException("No implementation provided");
    }

    @Override
    public void delete(long id) {
    	throw new UnsupportedOperationException("No implementation provided");
    }

    public MembershipModel changeMembershipStatus(long membershipId, MembershipStatus status) {
        return this.membershipService.updateMembershipStatus(membershipId, status);
    }
}
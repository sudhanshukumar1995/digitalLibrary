package com.project.digitalLibrary.cccc_repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.digitalLibrary.aaaa_entities.MembershipOutputEntity;
import com.project.digitalLibrary.aaaabbbbb_model.MembershipModel;
import com.project.digitalLibrary.bbbb_outputmappers.MembershipOutputMapper;
import com.project.digitalLibrary.zzzz_utils.MembershipStatus;
import com.project.digitalLibrary.zzzz_utils.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MembershipRepository
{

    private final MembershipJPARepository membershipJPARepository;

    private final MembershipOutputMapper membershipOutputMapper;

    @Autowired
    public MembershipRepository(MembershipJPARepository membershipJPARepository,
            MembershipOutputMapper membershipOutputMapper)
    {
        this.membershipJPARepository = membershipJPARepository;
        this.membershipOutputMapper = membershipOutputMapper;
    }

    public MembershipModel addMembership(MembershipModel membershipModel)
    {
        MembershipOutputEntity outputEntity = this.membershipOutputMapper.mapFromModel(membershipModel);
        outputEntity = membershipJPARepository.save(outputEntity);
        log.info("Saved new membership with ID: {} for user with ID: {}", outputEntity.getMembership_id(),
                outputEntity.getUser().getId());
        return membershipOutputMapper.mapToModel(outputEntity);
    }

    public MembershipModel getMembershipById(long id)
    {
        return membershipJPARepository.findById(id).map((o) ->
        {
            log.info("Membership with ID: {} was successfully found.", id);
            return membershipOutputMapper.mapToModel(o);
        }).orElseThrow(() -> new ResourceNotFoundException(MembershipModel.class, "id", String.valueOf(id)));
    }

    public MembershipModel updateMembershipStatus(long membershipId, MembershipStatus status)
    {
        MembershipOutputEntity outputEntity = membershipJPARepository.findById(membershipId).orElseThrow(
                () -> new ResourceNotFoundException(MembershipOutputEntity.class, "id", String.valueOf(membershipId)));
        outputEntity.setStatus(status);
        outputEntity = membershipJPARepository.save(outputEntity);
        log.info("Membership with ID: {} was successfully updated.", membershipId);
        return membershipOutputMapper.mapToModel(outputEntity);
    }

    public Optional<MembershipOutputEntity> getNonExpiredMembershipForUser(long userId)
    {
        return membershipJPARepository.findByUser_IdAndStatusNot(userId, MembershipStatus.EXPIRED);
    }

}

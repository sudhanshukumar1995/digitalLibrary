package com.project.digitalLibrary.cccc_repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.digitalLibrary.aaaa_entities.MembershipOutputEntity;
import com.project.digitalLibrary.zzzz_utils.MembershipStatus;

@Repository
public interface MembershipJPARepository extends JpaRepository<MembershipOutputEntity, Long>
{

    /**
     * Finds if the user with ID has any
     * membership that is not of the status
     * given as the argument.
     *
     * @param id     The User ID
     * @param status The membership status
     *               that the user does not
     *               have
     * @return Optional of
     *         MembershipOutputEntity
     */
    Optional<MembershipOutputEntity> findByUser_IdAndStatusNot(long id, MembershipStatus status);
}
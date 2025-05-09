package com.project.digitalLibrary.cccc_repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.digitalLibrary.aaaa_entities.UserOutputEntity;

@Repository
public interface UserJPARepository extends JpaRepository<UserOutputEntity, Long> {

    Optional<UserOutputEntity> findByEmail(String email);

}

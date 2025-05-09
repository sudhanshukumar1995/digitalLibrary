package com.project.digitalLibrary.cccc_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.digitalLibrary.aaaa_entities.BookOutputEntity;

@Repository
public interface BookJPARepo extends JpaRepository<BookOutputEntity, Long> {

}

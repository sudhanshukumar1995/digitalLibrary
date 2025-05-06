package com.project.digitalLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.digitalLibrary.entities.BookOutputEntity;

@Repository
public interface BookJPARepo extends JpaRepository<BookOutputEntity, Long> {

}

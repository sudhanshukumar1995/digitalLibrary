package com.project.digitalLibrary.aaaa_entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "book")
public class BookOutputEntity {
//Only output entity is connected to database, not input entity
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "description", length = 100)
	private String description;
	
	@Column(name = "published_date")
	private Instant  publishedDate;
	
	//@Column(name = "")
	//private String genre;
	
	
}

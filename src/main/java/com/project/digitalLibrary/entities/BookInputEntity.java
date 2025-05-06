package com.project.digitalLibrary.entities;

import java.time.Instant;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookInputEntity {

	private long id;

	@NotBlank(message = "name cannot be null")
	private String name;

	@NotBlank(message = "author cannot be null")
	private String author;
	private String description;

	@NotBlank(message = "published date cannot be null")
	private Instant publishedDate;
}

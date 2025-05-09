package com.project.digitalLibrary.aaaabbbbb_model;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;
import lombok.With;

@Data
@Builder
@With
public class BookModel {
	/*
	 * BookModel is something that is written to convert what is coming from
	 * BookOutputEntity. The BookOutputEntity deals directly with the Database. Now
	 * that is converted to the backend part i.e BookModel class. This separates the
	 * Entity with our model. We can have separate logic over our model
	 */

	private long id;
	private String name;
	private String author;
	private String description;
	private Instant publishedDate;
	//private AddressModel address;
}

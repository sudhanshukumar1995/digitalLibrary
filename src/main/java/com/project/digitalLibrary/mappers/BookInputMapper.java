package com.project.digitalLibrary.mappers;

import org.springframework.stereotype.Component;

import com.project.digitalLibrary.entities.BookInputEntity;
import com.project.digitalLibrary.model.BookModel;

@Component
public class BookInputMapper {

	public BookModel inputEntityToModel(BookInputEntity bie) {
		return BookModel.builder()
				.id(bie.getId())
				.name(bie.getAuthor())
				.author(bie.getAuthor())
				.description(bie.getDescription())
				.publishedDate(bie.getPublishedDate())
				.build();
	}
}

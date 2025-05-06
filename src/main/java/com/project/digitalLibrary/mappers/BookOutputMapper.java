package com.project.digitalLibrary.mappers;

import org.springframework.stereotype.Component;

import com.project.digitalLibrary.entities.BookOutputEntity;
import com.project.digitalLibrary.model.BookModel;

@Component
public class BookOutputMapper {

	public BookModel entityToModel(BookOutputEntity boe) {
		return BookModel.builder()
				.id(boe.getId())
				.name(boe.getName())
				.author(boe.getAuthor())
				.description(boe.getDescription())
				.publishedDate(boe.getPublishedDate())
				.build();
	}
	
	public BookOutputEntity modelToEntity(BookModel bm) {
		return BookOutputEntity.builder()
				.id(bm.getId())
				.name(bm.getName())
				.author(bm.getAuthor())
				.description(bm.getDescription())
				.publishedDate(bm.getPublishedDate())
				.build();
	}
}

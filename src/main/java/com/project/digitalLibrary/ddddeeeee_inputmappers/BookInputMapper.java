package com.project.digitalLibrary.ddddeeeee_inputmappers;

import org.springframework.stereotype.Component;

import com.project.digitalLibrary.aaaabbbbb_model.BookModel;
import com.project.digitalLibrary.ddddeeee_inputentities.BookInputEntity;

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

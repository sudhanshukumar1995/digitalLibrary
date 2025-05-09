package com.project.digitalLibrary.cccc_repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.digitalLibrary.aaaa_entities.BookOutputEntity;
import com.project.digitalLibrary.aaaabbbbb_model.BookModel;
import com.project.digitalLibrary.bbbb_outputmappers.BookOutputMapper;
import com.project.digitalLibrary.zzzz_utils.ResourceNotFoundException;

@Component
public class BookRepository {

	private BookJPARepo bookJPARepo;
	private BookOutputMapper bookOutputMapper;

	@Autowired
	public BookRepository(BookJPARepo bookJPARepo) {
		this.bookJPARepo = bookJPARepo;
	}

	public BookModel save(BookModel book) {
		// convert model to output-entity
		// save in db
		// convert the saved output entity into model
		// return the model to print the result on API console
		BookOutputEntity outputEntity = bookOutputMapper.modelToEntity(book);
		BookOutputEntity rowCreatedInDatabase = bookJPARepo.save(outputEntity);
		return bookOutputMapper.entityToModel(rowCreatedInDatabase);
	}

	public BookModel findById(long id) {
		// convert model to output-entity
		// save in db
		// convert the saved output entity into model
		// return the model
		Optional<BookOutputEntity> ifNullId = bookJPARepo.findById(id);

		// return ifNullId.isPresent() ? bookOutputMapper.entityToModel(ifNullId.get())
		// : null;
		// another way of writing the statement
		// return ifNullId.map(bookOutputMapper::entityToModel).orElse(null);

		return ifNullId.map(bookOutputMapper::entityToModel)
				.orElseThrow(() -> new ResourceNotFoundException(BookModel.class, "id", String.valueOf(id)));
	}

	public BookModel update(BookModel bookModel) {
		BookModel existingModel = this.findById(bookModel.getId());
//        bookModel.setUpdatedAt(Instant.now());
		bookModel.setPublishedDate(existingModel.getPublishedDate());
		return save(bookModel);
	}

	public List<BookModel> findAllBooks() {
		return bookJPARepo.findAll().stream().map(bookOutputMapper::entityToModel).toList();
	}

	public void deleteBook(long id) {
		bookJPARepo.deleteById(id);
	}
}

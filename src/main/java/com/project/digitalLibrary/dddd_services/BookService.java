package com.project.digitalLibrary.dddd_services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.digitalLibrary.aaaabbbbb_model.BookModel;
import com.project.digitalLibrary.cccc_repository.BookRepository;

//services are to write business logic
@Service
public class BookService {

	private final BookRepository bookrepo;

	public BookService(BookRepository bookrepo) {
		this.bookrepo = bookrepo;
	}

	public BookModel addBook(BookModel book) {
		return bookrepo.save(book);
	}

	public BookModel getBookById(long id) {
		return bookrepo.findById(id);
	}

	public BookModel updateBook(BookModel inputEntityToModel) {
		return bookrepo.update(inputEntityToModel);
	}

	public List<BookModel> getAllBooks() {
		return bookrepo.findAllBooks();
	}
	
	public void deleteBook(long id) {
        bookrepo.deleteBook(id);
    }
}

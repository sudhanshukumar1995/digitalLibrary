package com.project.digitalLibrary.adaptor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.digitalLibrary.entities.BookInputEntity;
import com.project.digitalLibrary.mappers.BookInputMapper;
import com.project.digitalLibrary.model.BookModel;
import com.project.digitalLibrary.services.BookService;

@Component
public class BookAdaptor implements CommonAdaptor<BookInputEntity, BookModel>{

	private BookInputMapper bookInputMapper;
	private BookService booksvc;
	
	@Autowired
	public BookAdaptor(BookInputMapper bookInputMapper, BookService booksvc) {
		this.bookInputMapper = bookInputMapper;
		this.booksvc = booksvc;
	}
	
	@Override
	public BookModel save(BookInputEntity inputEntity) {
		return booksvc.addBook(bookInputMapper.inputEntityToModel(inputEntity));
	}


	@Override
    public BookModel update(BookInputEntity inputEntity) {
        return booksvc.updateBook(
                this.bookInputMapper.inputEntityToModel(inputEntity)
        );
    }

	@Override
	public BookModel getById(long id) {
		// TODO Auto-generated method stub
		return booksvc.getBookById(id);
	}

	@Override
	public List<BookModel> getAll() {
		// TODO Auto-generated method stub
		return booksvc.getAllBooks();
	}

	@Override
	public void delete(long id) {
		 booksvc.deleteBook(id);
		
	}
	
}

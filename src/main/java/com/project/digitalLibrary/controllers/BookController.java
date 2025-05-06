package com.project.digitalLibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.digitalLibrary.adaptor.CommonAdaptor;
import com.project.digitalLibrary.entities.BookInputEntity;
import com.project.digitalLibrary.model.BookModel;
import com.project.digitalLibrary.utils.ResourceNotFoundException;

import jakarta.validation.Valid;

@RestController()
@RequestMapping("/book")
public class BookController {

	private final CommonAdaptor<BookInputEntity, BookModel> bookada;

	@Autowired
	public BookController(CommonAdaptor<BookInputEntity, BookModel> bookada) {
		this.bookada = bookada;
	}

	@PostMapping("/add")
	public ResponseEntity<?> addBook(@Valid @RequestBody BookInputEntity book) { //@Valid tag is to check for @NotBlank annotation
		return new ResponseEntity<>(bookada.save(book), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        return new ResponseEntity<>(bookada.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@Valid @RequestBody BookInputEntity book) {
        try {
            return new ResponseEntity<>(
            		bookada.update(book),
                    HttpStatus.OK
            );
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

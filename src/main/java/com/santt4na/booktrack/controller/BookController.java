package com.santt4na.booktrack.controller;

import com.santt4na.booktrack.domain.Book;
import com.santt4na.booktrack.dtos.BookDTO;
import com.santt4na.booktrack.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private final BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO){
		BookDTO saveBook = service.createBook(bookDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveBook);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BookDTO>> allBooks(){
		List<BookDTO> allBooks = service.allBooks();
		return ResponseEntity.ok(allBooks);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> findBook(@PathVariable Long id){
		BookDTO findedBook = service.findById(id);
		return ResponseEntity.ok(findedBook);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> updateBook(@PathVariable Long id,@Valid @RequestBody BookDTO bookDTO){
		BookDTO updatedBook = service.updateBook(id, bookDTO);
		return ResponseEntity.ok(updatedBook);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		service.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
}

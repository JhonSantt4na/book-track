package com.santt4na.booktrack.controller;

import com.santt4na.booktrack.dtos.book.BookDTO;
import com.santt4na.booktrack.dtos.book.BookResponseDTO;
import com.santt4na.booktrack.dtos.book.BookUpdateDTO;
import com.santt4na.booktrack.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private final BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<BookResponseDTO> create(@Valid @RequestBody BookDTO dto) {
		BookResponseDTO created = service.createBook(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@GetMapping
	public ResponseEntity<List<BookResponseDTO>> findAll() {
		return ResponseEntity.ok(service.listAllBooks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookResponseDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookResponseDTO> update(
		@PathVariable Long id,
		@Valid @RequestBody BookUpdateDTO dto) {
		return ResponseEntity.ok(service.updateBook(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
}
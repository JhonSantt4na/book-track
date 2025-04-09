package com.santt4na.booktrack.service.impl;

import com.santt4na.booktrack.domain.Book;
import com.santt4na.booktrack.dtos.book.BookDTO;
import com.santt4na.booktrack.dtos.book.BookResponseDTO;
import com.santt4na.booktrack.dtos.book.BookUpdateDTO;
import com.santt4na.booktrack.mapper.BookMapper;
import com.santt4na.booktrack.repository.BookRepository;
import com.santt4na.booktrack.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
	
	private final BookRepository repository;
	private final BookMapper mapper;
	
	public BookServiceImpl(BookRepository repository, BookMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	@Transactional
	public BookResponseDTO createBook(BookDTO bookDTO){
		if (bookDTO == null){
			throw new IllegalArgumentException("DTO can't be null");
		}
		Book newBook = mapper.toEntity(bookDTO);
		
		Book savedBook = repository.save(newBook);
		return mapper.toResponseDTO(savedBook);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<BookResponseDTO> listAllBooks(){
		List<Book> books = repository.findAll();
		return books.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public BookResponseDTO findById(Long id){
		Book findBook = repository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));
		return 	mapper.toResponseDTO(findBook);
	}
	
	@Override
	@Transactional
	public BookResponseDTO updateBook(Long id, BookUpdateDTO bookDTO){
		Book updateBook = repository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));
		
		mapper.updateBookFromDTO(bookDTO, updateBook);
		repository.save(updateBook);
		return mapper.toResponseDTO(updateBook);
	}
	
	@Override
	@Transactional
	public void deleteBook(Long id) {
		Book book = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
		repository.delete(book);
	}
	
}
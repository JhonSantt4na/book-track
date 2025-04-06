package com.santt4na.booktrack.service.impl;

import com.santt4na.booktrack.domain.Book;
import com.santt4na.booktrack.dtos.BookDTO;
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
	public BookDTO createBook(BookDTO bookDTO){
		if (bookDTO == null){
			throw new IllegalArgumentException("DTO can't be null");
		}
		
		Book newBook = mapper.toEntity(bookDTO);
		Book savedBook = repository.save(newBook);
		return mapper.toDto(savedBook);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<BookDTO> allBooks(){
		List<Book> books = repository.findAll();
		return books.stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public BookDTO findById(Long id){
		Book findBook = repository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));
		return 	mapper.toDto(findBook);
	}
	
	@Override
	@Transactional
	public BookDTO updateBook(Long id,BookDTO bookDTO){
		Book updateBook = repository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + id));
		
		mapper.updateReaderFromDTO(bookDTO, updateBook);
		repository.save(updateBook);
		return mapper.toDto(updateBook);
	}
	
	@Override
	@Transactional
	public void deleteBook(Long id) {
		Book book = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
		repository.delete(book);
	}
	
}
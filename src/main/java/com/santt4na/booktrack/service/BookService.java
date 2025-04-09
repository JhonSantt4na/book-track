package com.santt4na.booktrack.service;

import com.santt4na.booktrack.dtos.book.BookDTO;
import com.santt4na.booktrack.dtos.book.BookResponseDTO;
import com.santt4na.booktrack.dtos.book.BookUpdateDTO;

import java.util.List;

public interface BookService {
	
	BookResponseDTO createBook(BookDTO bookDTO);
	
	List<BookResponseDTO> listAllBooks();
	
	BookResponseDTO findById(Long id);
	
	BookResponseDTO updateBook(Long id, BookUpdateDTO bookDTO);
	
	void deleteBook(Long id);
}

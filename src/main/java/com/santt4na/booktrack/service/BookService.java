package com.santt4na.booktrack.service;

import com.santt4na.booktrack.dtos.book.BookDTO;
import java.util.List;

public interface BookService {
	BookDTO createBook(BookDTO bookDTO);
	
	List<BookDTO> allBooks();
	
	BookDTO findById(Long id);
	
	BookDTO updateBook(Long id, BookDTO bookDTO);
	
	void deleteBook(Long id);
}

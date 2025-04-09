package com.santt4na.booktrack.mapper;

import com.santt4na.booktrack.domain.Book;
import com.santt4na.booktrack.dtos.book.BookDTO;
import com.santt4na.booktrack.dtos.book.BookResponseDTO;
import com.santt4na.booktrack.dtos.book.BookUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BookMapper {
	
	@Mapping(target = "id", ignore = true)
	void updateBookFromDTO(BookUpdateDTO dto, @MappingTarget Book entity);
	
	Book toEntity(BookDTO bookDTO);
	
	BookDTO toDto(Book book);
	
	BookResponseDTO toResponseDTO (Book book);
	
	BookUpdateDTO toUpdateDTO (Book book);
}

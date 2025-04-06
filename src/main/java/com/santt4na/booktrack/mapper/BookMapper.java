package com.santt4na.booktrack.mapper;

import com.santt4na.booktrack.domain.Book;
import com.santt4na.booktrack.dtos.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BookMapper {
	
	@Mapping(target = "id", ignore = true)
	void updateReaderFromDTO(BookDTO dto, @MappingTarget Book entity);
	
	Book toEntity(BookDTO bookDTO);
	
	BookDTO toDto(Book book);
}

package com.santt4na.booktrack.mapper;

import com.santt4na.booktrack.domain.Reader;
import com.santt4na.booktrack.dtos.reader.ReaderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ReaderMapper {
	
	@Mapping(target = "id", ignore = true)
	void updateReaderFromDTO(ReaderDTO dto, @MappingTarget Reader entity);
	
	Reader toEntity(ReaderDTO readerDTO);
	
	ReaderDTO toDto(Reader reader);
	
}

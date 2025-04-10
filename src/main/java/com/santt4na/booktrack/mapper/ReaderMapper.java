package com.santt4na.booktrack.mapper;

import com.santt4na.booktrack.domain.Reader;
import com.santt4na.booktrack.dtos.reader.ReaderDTO;
import com.santt4na.booktrack.dtos.reader.ReaderResponseDTO;
import com.santt4na.booktrack.dtos.reader.ReaderUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ReaderMapper {
	
	void updateReaderFromDTO(ReaderDTO dto, @MappingTarget Reader entity);
	
	Reader toEntity(ReaderDTO readerDTO);
	
	ReaderDTO toDto(Reader reader);
	
	ReaderResponseDTO toResponseDTO(Reader reader);
	
	ReaderUpdateDTO toUpdateDTO(Reader reader);
}

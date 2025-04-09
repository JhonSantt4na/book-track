package com.santt4na.booktrack.mapper;

import com.santt4na.booktrack.domain.Rental;
import com.santt4na.booktrack.dtos.rental.RentalDTO;
import com.santt4na.booktrack.dtos.rental.RentalResponseDTO;
import com.santt4na.booktrack.dtos.rental.RentalUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RentalMapper {
	
	@Mapping(target = "id", ignore = true)
	void updateMapperFromDTO(RentalDTO dto, @MappingTarget Rental entity);
	
	Rental toEntity(RentalDTO rentalDTO);
	
	RentalDTO toDto(Rental rental);
	
	RentalResponseDTO toResponseDTO(Rental rental);
	
	RentalUpdateDTO toUpdateDTO(Rental rental);
	
}

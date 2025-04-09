package com.santt4na.booktrack.service;

import com.santt4na.booktrack.dtos.rental.RentalDTO;
import com.santt4na.booktrack.dtos.rental.RentalResponseDTO;
import com.santt4na.booktrack.dtos.rental.RentalUpdateDTO;


import java.util.List;

public interface RentalService {
	
	RentalResponseDTO createRental(RentalDTO rentalDTO);
	
	List<RentalResponseDTO> listAllRental();
	
	RentalResponseDTO findById(Long id);
	
	RentalResponseDTO updateRental(Long id, RentalUpdateDTO bookDTO);
	
	void deleteRental(Long id);
}

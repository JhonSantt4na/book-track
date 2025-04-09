package com.santt4na.booktrack.service;

import com.santt4na.booktrack.dtos.reader.ReaderDTO;
import com.santt4na.booktrack.dtos.reader.ReaderResponseDTO;
import com.santt4na.booktrack.dtos.reader.ReaderUpdateDTO;

import java.util.List;

public interface ReaderService {
	
	ReaderResponseDTO createReader(ReaderDTO readerDTO);
	
	List<ReaderResponseDTO> listAllReaders();
	
	ReaderResponseDTO findById(Long id);
	
	ReaderUpdateDTO updateReader(Long id, ReaderDTO readerDTO);
	
	void deleteReader(Long id);
}

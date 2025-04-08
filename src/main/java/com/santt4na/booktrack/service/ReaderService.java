package com.santt4na.booktrack.service;

import com.santt4na.booktrack.dtos.reader.ReaderDTO;
import java.util.List;

public interface ReaderService {
	
	ReaderDTO createReader(ReaderDTO readerDTO);
	
	List<ReaderDTO> listAllReaders();
	
	ReaderDTO findById(Long id);
	
	ReaderDTO updateReader(Long id, ReaderDTO readerDTO);
	
	void deleteReader(Long id);
}

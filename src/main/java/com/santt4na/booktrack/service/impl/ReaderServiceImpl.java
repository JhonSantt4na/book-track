package com.santt4na.booktrack.service.impl;

import com.santt4na.booktrack.domain.Reader;
import com.santt4na.booktrack.dtos.reader.ReaderDTO;
import com.santt4na.booktrack.dtos.reader.ReaderResponseDTO;
import com.santt4na.booktrack.dtos.reader.ReaderUpdateDTO;
import com.santt4na.booktrack.mapper.ReaderMapper;
import com.santt4na.booktrack.repository.ReaderRepository;
import com.santt4na.booktrack.service.ReaderService;
import com.santt4na.booktrack.util.CpfValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderServiceImpl implements ReaderService {
	
	private final ReaderRepository repository;
	private final ReaderMapper mapper;
	private final CpfValidator cpfValidator;
	
	public ReaderServiceImpl(ReaderRepository repository, ReaderMapper mapper, CpfValidator cpfValidator) {
		this.repository = repository;
		this.mapper = mapper;
		this.cpfValidator = cpfValidator;
	}
	
	@Override
	@Transactional
	public ReaderResponseDTO createReader(ReaderDTO readerDTO){
		if (readerDTO == null) {
			throw new IllegalArgumentException("DTO can't be null");
		}
		
		if (cpfValidator.isCpfAlreadyRegistered(readerDTO.getCpf())) {
			throw new IllegalArgumentException("Invalid CPF");
		}
		
		Reader newReader = mapper.toEntity(readerDTO);
		Reader savedReader = repository.save(newReader);
		return mapper.toResponseDTO(savedReader);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ReaderResponseDTO> listAllReaders() {
		List<Reader> allReaders = repository.findAll();
		return allReaders.stream()
			.map(mapper::toResponseDTO)
			.collect(Collectors.toList());
	}
	
	@Override
	@Transactional(readOnly = true)
	public ReaderResponseDTO findById(Long id) {
		Reader reader = repository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Reader not found with ID: " + id));
		return mapper.toResponseDTO(reader);
	}
	
	@Override
	@Transactional
	public ReaderUpdateDTO updateReader(Long id, ReaderDTO readerDTO){
		Reader reader = repository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Reader not found with ID: " + id));
		
		if (cpfValidator.isCpfUsedByOther(id,readerDTO.getCpf())) {
			throw new IllegalArgumentException("Invalid CPF");
		}
		
		mapper.updateReaderFromDTO(readerDTO, reader);
		
		Reader updateReader = repository.save(reader);
		return mapper.toUpdateDTO(updateReader);
	}
	
	@Override
	@Transactional
	public void deleteReader(Long id){
		Reader reader = repository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Reader not found with ID: " + id));
		repository.delete(reader);
	}
}

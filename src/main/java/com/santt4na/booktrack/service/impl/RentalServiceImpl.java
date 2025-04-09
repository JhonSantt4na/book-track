package com.santt4na.booktrack.service.impl;

import com.santt4na.booktrack.domain.Book;
import com.santt4na.booktrack.domain.Reader;
import com.santt4na.booktrack.domain.Rental;
import com.santt4na.booktrack.dtos.rental.RentalDTO;
import com.santt4na.booktrack.dtos.rental.RentalResponseDTO;
import com.santt4na.booktrack.dtos.rental.RentalUpdateDTO;
import com.santt4na.booktrack.mapper.RentalMapper;
import com.santt4na.booktrack.repository.BookRepository;
import com.santt4na.booktrack.repository.ReaderRepository;
import com.santt4na.booktrack.repository.RentalRepository;
import com.santt4na.booktrack.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
	
	private final RentalRepository repository;
	private final RentalMapper mapper;
	private final BookRepository bookRepository;
	private final ReaderRepository readerRepository;
	
	public RentalServiceImpl(RentalRepository repository,
							 RentalMapper mapper,
							 BookRepository bookRepository,
							 ReaderRepository readerRepository) {
		this.repository = repository;
		this.mapper = mapper;
		this.bookRepository = bookRepository;
		this.readerRepository = readerRepository;
	}
	
	@Override
	public RentalResponseDTO createRental(RentalDTO rentalDTO) {
		Book book = bookRepository.findById(rentalDTO.getBookId())
			.orElseThrow(() -> new RuntimeException("Livro não encontrado"));
		
		if (!book.isAvailable()) {
			throw new RuntimeException("Livro não está disponível para aluguel");
		}
		
		Reader reader = readerRepository.findById(rentalDTO.getReaderId())
			.orElseThrow(() -> new RuntimeException("Leitor não encontrado"));
		
		Rental rental = new Rental();
		rental.setBook(book);
		rental.setReader(reader);
		rental.setStartDate(rentalDTO.getStartDate());
		rental.setEndDate(rentalDTO.getEndDate());
		rental.setReturned(false);
		rental.setFineAmount(0.0);
		
		book.setAvailable(false);
		book.addRental(rental);
		
		Rental saved = repository.save(rental);
		return mapper.toResponseDTO(saved);
	}
	
	@Override
	public List<RentalResponseDTO> listAllRental() {
		return repository.findAll()
			.stream()
			.map(mapper::toResponseDTO)
			.toList();
	}
	
	@Override
	public RentalResponseDTO findById(Long id) {
		Rental rental = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
		return mapper.toResponseDTO(rental);
	}
	
	@Override
	public RentalResponseDTO updateRental(Long id, RentalUpdateDTO updateDTO) {
		Rental rental = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
		
		if (updateDTO.isReturned()) {
			rental.closeRental();
			rental.setFineAmount(updateDTO.getFineAmount());
			rental.getBook().setAvailable(true);
		}
		
		Rental updated = repository.save(rental);
		return mapper.toResponseDTO(updated);
	}
	
	@Override
	public void deleteRental(Long id) {
		Rental rental = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
		
		rental.getBook().setAvailable(true);
		repository.delete(rental);
	}
}

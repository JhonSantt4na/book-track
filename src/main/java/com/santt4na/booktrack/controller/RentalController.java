package com.santt4na.booktrack.controller;

import com.santt4na.booktrack.dtos.rental.RentalResponseDTO;
import com.santt4na.booktrack.dtos.rental.RentalUpdateDTO;
import com.santt4na.booktrack.service.RentalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
	
	private final RentalService service;
	
	public RentalController(RentalService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<RentalResponseDTO> create(@Valid @RequestBody RentalCreateDTO dto) {
		RentalResponseDTO created = service.createRental(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@GetMapping
	public ResponseEntity<List<RentalResponseDTO>> findAll() {
		return ResponseEntity.ok(service.listAllRentals());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RentalResponseDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RentalResponseDTO> update(
		@PathVariable Long id,
		@Valid @RequestBody RentalUpdateDTO dto) {
		return ResponseEntity.ok(service.updateRental(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteRental(id);
		return ResponseEntity.noContent().build();
	}
}

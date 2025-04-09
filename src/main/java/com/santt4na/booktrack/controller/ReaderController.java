package com.santt4na.booktrack.controller;

import com.santt4na.booktrack.dtos.reader.ReaderDTO;
import com.santt4na.booktrack.dtos.reader.ReaderResponseDTO;
import com.santt4na.booktrack.dtos.reader.ReaderUpdateDTO;
import com.santt4na.booktrack.service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {
	
	private final ReaderService service;
	
	public ReaderController(ReaderService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<ReaderResponseDTO> create(@Valid @RequestBody ReaderDTO dto) {
		ReaderResponseDTO created = service.createReader(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@GetMapping
	public ResponseEntity<List<ReaderResponseDTO>> findAll() {
		return ResponseEntity.ok(service.listAllReaders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReaderResponseDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReaderUpdateDTO> update(
		@PathVariable Long id,
		@Valid @RequestBody ReaderDTO dto) {
		return ResponseEntity.ok(service.updateReader(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteReader(id);
		return ResponseEntity.noContent().build();
	}
}

package com.santt4na.booktrack.controller;

import com.santt4na.booktrack.dtos.ReaderDTO;
import com.santt4na.booktrack.service.ReaderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/reader")
public class ReaderController {
	
	private final ReaderService service;
	
	public ReaderController(ReaderService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ReaderDTO> createReader(@Valid @RequestBody  ReaderDTO readerDTO) {
		ReaderDTO newReader = service.createReader(readerDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(newReader);
	}
	
	@RequestMapping("/all")
	public ResponseEntity<List<ReaderDTO>> allReader(){
		List<ReaderDTO> listAll = service.listAllReaders();
		return ResponseEntity.ok(listAll);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<ReaderDTO> getById(@PathVariable Long id){
		ReaderDTO findedReader = service.findById(id);
		return  ResponseEntity.ok(findedReader);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReaderDTO> updeteReader(@PathVariable Long id, @Valid @RequestBody ReaderDTO readerDTO){
		ReaderDTO updatedReader = service.updateReader(id, readerDTO);
		return ResponseEntity.ok(updatedReader);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReader(@PathVariable Long id){
		service.deleteReader(id);
	}
}

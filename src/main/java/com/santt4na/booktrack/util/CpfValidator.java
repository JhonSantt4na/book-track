package com.santt4na.booktrack.util;

import com.santt4na.booktrack.repository.ReaderRepository;
import org.springframework.stereotype.Component;

@Component
public class CpfValidator {
	
	private final ReaderRepository repository;
	
	public CpfValidator(ReaderRepository repository) {
		this.repository = repository;
	}
	
	public boolean isCpfAlreadyRegistered(String cpf) {
		return repository.existsByCpf(cpf);
	}
	
	public boolean isCpfUsedByOther(Long id, String cpf) {
		return repository.existsByCpfAndIdNot(cpf, id);
	}
}
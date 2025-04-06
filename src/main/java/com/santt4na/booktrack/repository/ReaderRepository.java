package com.santt4na.booktrack.repository;

import com.santt4na.booktrack.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
	boolean existsByCpf(String cpf);
	boolean existsByCpfAndIdNot(String cpf, Long id);
}

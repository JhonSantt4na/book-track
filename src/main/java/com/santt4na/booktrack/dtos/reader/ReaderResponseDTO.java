package com.santt4na.booktrack.dtos.reader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReaderResponseDTO {
	private Long id;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String cpf;
}
package com.santt4na.booktrack.dtos.reader;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReaderUpdateDTO {
	
	@Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
	private String name;
	
	@Email(message = "Invalid email format")
	private String email;
	
	private String address;
	
	@Pattern(
		regexp = "^\\(?(\\d{2})\\)?[ .\\-]?(\\d{4,5})[ .\\-]?(\\d{4})$",
		message = "Invalid phone number format"
	)
	private String phone;
	
	@Pattern(
		regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$",
		message = "Invalid CPF format (expected: 000.000.000-00)"
	)
	private String cpf;
}
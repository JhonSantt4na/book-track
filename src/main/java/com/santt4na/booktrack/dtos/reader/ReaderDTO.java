package com.santt4na.booktrack.dtos.reader;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class ReaderDTO {
	
	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters long")
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Phone number is required")
	@Pattern(
		regexp = "^\\(?(\\d{2})\\)?[ .-]?(\\d{4,5})[ .-]?(\\d{4})$",
		message = "Invalid phone number format"
	)
	private String phone;
	
	@NotBlank(message = "CPF is required")
	@Pattern(
		regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$",
		message = "Invalid CPF format (expected: 000.000.000-00)"
	)
	private String cpf;
	
}

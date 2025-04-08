package com.santt4na.booktrack.dtos.rental;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {
	
	@NotNull(message = "Start date is required")
	private Instant startDate;
	
	@NotNull(message = "End date is required")
	@Future(message = "End date must be in the future")
	private Instant endDate;
	
	@NotNull(message = "Book ID is required")
	private Long bookId;
	
	@NotNull(message = "Reader ID is required")
	private Long readerId;
	
}

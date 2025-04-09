package com.santt4na.booktrack.dtos.rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RentalUpdateDTO {
	private Instant startDate;
	private Instant endDate;
	private Instant returnDate;
	private Double fineAmount;
	private Boolean returned;
	private Long bookId;
	private Long readerId;
}
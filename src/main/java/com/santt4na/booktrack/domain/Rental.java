package com.santt4na.booktrack.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant startDate;
	private Instant endDate;
	private Instant returnDate;
	private double fineAmount;
	
	@Column(name = "is_returned")
	private boolean returned;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reader_id")
	private Reader reader;
	
	public double calculateFine() {
		return 0L;
	}
	
	public void closeRental() {
		this.returned = true;
		this.returnDate = Instant.now();
	}
}
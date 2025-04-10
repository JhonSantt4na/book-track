package com.santt4na.booktrack.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
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
		if (this.returnDate == null || this.endDate == null) {
			return 0.0;
		}
		
		long daysLate = Duration.between(endDate, returnDate).toDays();
		
		if (daysLate > 0) {
			double dailyFine = 2.5;
			return daysLate * dailyFine;
		}
		
		return 0.0;
	}
	public void closeRental() {
		this.returned = true;
		this.returnDate = Instant.now();
		this.fineAmount = calculateFine();
	}
	
	public void assignBook(Book book) {
		this.book = book;
		if (!book.getRentals().contains(this)) {
			book.addRental(this);
		}
	}
}
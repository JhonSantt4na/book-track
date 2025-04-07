package com.santt4na.booktrack.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private LocalDateTime returnDate;
	private boolean isReturned;
	private double fineAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reader_id")
	private Reader reader;
	
	public Rental() {
	}
	
	public Rental(Book book, Reader reader, LocalDateTime startDate, LocalDateTime endDate) {
		this.book = book;
		this.reader = reader;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isReturned = false;
	}
	
	public double calculateFine() {
		return 0L;
	}
	
	public void closeRental() {
		this.isReturned = true;
		this.returnDate = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	public LocalDateTime getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	
	public boolean isReturned() {
		return isReturned;
	}
	
	public void setReturned(boolean returned) {
		isReturned = returned;
	}
	
	public double getFineAmount() {
		return fineAmount;
	}
	
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
}

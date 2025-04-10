package com.santt4na.booktrack.domain;

import com.santt4na.booktrack.enums.CategoryBook;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "book",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY,
		orphanRemoval = true)
	private List<Rental> rentals = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private CategoryBook category;
	
	private String name;
	private int page;
	private String author;
	private String editor;
	private String cover;
	private boolean available;
	
	public void addRental(Rental rental) {
		rentals.add(rental);
		rental.setBook(this);
	}
	
	public void removeRental(Rental rental) {
		rentals.remove(rental);
		rental.setBook(null);
	}
	
	public List<Rental> getRentals() {
		return Collections.unmodifiableList(rentals);
	}
	
}

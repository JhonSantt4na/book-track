package com.santt4na.booktrack.domain;

import com.santt4na.booktrack.enums.CategoryBook;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
	
	public void addRental(Rental rental){
		this.rentals.add(rental);
	}
	
	public void removeRental(Rental rental){
		this.rentals.remove(rental);
	}
	
	public List<Rental> getRentals(){
		return rentals.stream().toList();
	}
	
}

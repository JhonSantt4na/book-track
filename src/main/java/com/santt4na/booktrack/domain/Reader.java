package com.santt4na.booktrack.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String address;
	private String phone;
	
	@Column(unique = true)
	private String cpf;
	
	@OneToMany(mappedBy = "reader",
		cascade = CascadeType.ALL,
		fetch = FetchType.LAZY,
		orphanRemoval = true)
	private List<Rental> rentals = new ArrayList<>();
}

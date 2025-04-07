package com.santt4na.booktrack.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Reader {
	
	@Id
	@GeneratedValue()
	private UUID id;
	
	private String name;
	private String email;
	private String address;
	private String phone;
	
	@Column(unique = true)
	private String cpf;
	
	@OneToMany(mappedBy = "reader", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rental> rentals = new ArrayList<>();
	
	public Reader() {
	}
	
	public Reader(String name, String email, String address, String phone, String cpf) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.cpf = cpf;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}

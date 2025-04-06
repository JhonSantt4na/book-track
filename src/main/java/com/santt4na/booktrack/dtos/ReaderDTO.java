package com.santt4na.booktrack.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ReaderDTO {
	
	private  Long id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
	private String name;
	
	@NotBlank(message = "O email é obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotBlank(message = "O endereço é obrigatório")
	private String address;
	
	@NotBlank(message = "O telefone é obrigatório")
	@Pattern(regexp = "^\\(?(\\d{2})\\)?[ .-]?(\\d{4,5})[ .-]?(\\d{4})$", message = "Telefone inválido")
	private String phone;
	
	@NotBlank(message = "O CPF é obrigatório")
	@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "CPF inválido (formato: 000.000.000-00)")
	private String cpf;
	
	public ReaderDTO() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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

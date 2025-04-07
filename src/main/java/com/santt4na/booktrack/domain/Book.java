package com.santt4na.booktrack.domain;

import com.santt4na.booktrack.enums.CategoryBook;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int page;
	private CategoryBook category;
	private String author;
	private String editor;
	private String cover;
	private boolean Available;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rental> rentals = new ArrayList<>();
	
	public Book() {
	}
	
	public Book(Long id, String name, int page, CategoryBook category, String author, String editor, String cover, boolean available) {
		this.id = id;
		this.name = name;
		this.page = page;
		this.category = category;
		this.author = author;
		this.editor = editor;
		this.cover = cover;
		Available = available;
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
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public CategoryBook getCategory() {
		return category;
	}
	
	public void setCategory(CategoryBook category) {
		this.category = category;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getEditor() {
		return editor;
	}
	
	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	public String getCover() {
		return cover;
	}
	
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public boolean isAvailable() {
		return Available;
	}
	
	public void setAvailable(boolean available) {
		Available = available;
	}
}

package com.santt4na.booktrack.dtos;


import com.santt4na.booktrack.enums.CategoryBook;
import jakarta.validation.constraints.*;

public class BookDTO {
	private Long id;
	
	@NotBlank(message = "Name is required")
	@Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
	private String name;
	
	@Min(value = 1, message = "Page count must be at least 1")
	@Max(value = 10000, message = "Page count must be less than or equal to 10000")
	private int page;
	
	@NotNull(message = "Category is required")
	private CategoryBook category;
	
	@NotBlank(message = "Author is required")
	@Size(max = 100, message = "Author name must be at most 100 characters")
	private String author;
	
	@NotBlank(message = "Editor is required")
	@Size(max = 100, message = "Editor name must be at most 100 characters")
	private String editor;
	
	@NotBlank(message = "Cover is required")
	@Size(max = 255, message = "Cover URL must be at most 255 characters")
	private String cover;
	
	private boolean available;
	
	public BookDTO() {
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
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
}

package com.santt4na.booktrack.dtos.book;


import com.santt4na.booktrack.enums.CategoryBook;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	
	@NotBlank(message = "Book name is required")
	@Size(min = 2, max = 150, message = "Book name must be between 2 and 150 characters")
	private String name;
	
	@Min(value = 1, message = "Book must have at least 1 page")
	private int page;
	
	@NotNull(message = "Category is required")
	private CategoryBook category;
	
	@NotBlank(message = "Author name is required")
	private String author;
	
	@NotBlank(message = "Editor is required")
	private String editor;
	
	@NotBlank(message = "Cover image or URL is required")
	private String cover;
}
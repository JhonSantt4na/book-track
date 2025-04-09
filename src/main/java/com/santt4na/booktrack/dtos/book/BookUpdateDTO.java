package com.santt4na.booktrack.dtos.book;

import com.santt4na.booktrack.enums.CategoryBook;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateDTO {
	
	@Size(min = 2, max = 150, message = "Book name must be between 2 and 150 characters")
	private String name;
	
	@Min(value = 1, message = "Page must be at least 1")
	private Integer page;
	
	private CategoryBook category;
	
	private String author;
	
	private String editor;
	
	private String cover;
	
	private Boolean available;
}
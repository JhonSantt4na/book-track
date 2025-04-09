package com.santt4na.booktrack.dtos.book;

import com.santt4na.booktrack.enums.CategoryBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
	private Long id;
	private String name;
	private Integer page;
	private CategoryBook category;
	private String author;
	private String editor;
	private String cover;
	private Boolean available;
}
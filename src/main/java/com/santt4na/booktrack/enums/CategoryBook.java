package com.santt4na.booktrack.enums;

import lombok.Getter;
import java.util.Arrays;

@Getter
public enum CategoryBook {
	FICTION("Fiction"),
	NON_FICTION("Non-fiction"),
	SCIENCE("Science"),
	TECHNOLOGY("Technology"),
	HISTORY("History"),
	BIOGRAPHY("Biography"),
	FANTASY("Fantasy"),
	MYSTERY("Mystery"),
	ROMANCE("Romance"),
	HORROR("Horror"),
	SELF_HELP("Self-help"),
	EDUCATION("Education"),
	TRAVEL("Travel"),
	HEALTH("Health"),
	POETRY("Poetry");
	
	private final String displayName;
	
	CategoryBook(String displayName) {
		this.displayName = displayName;
	}
	
	public static CategoryBook fromDisplayName(String name) {
		return Arrays.stream(values())
			.filter(c -> c.displayName.equalsIgnoreCase(name))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Invalid category: " + name));
	}
}
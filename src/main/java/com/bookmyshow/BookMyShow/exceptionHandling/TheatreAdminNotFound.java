package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class TheatreAdminNotFound extends Exception {
	String message;

	public TheatreAdminNotFound(String message) {
		this.message = message;
	}

}

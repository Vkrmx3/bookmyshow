package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class TheatreNotFound extends Exception {
	String message;

	public TheatreNotFound(String message) {
		this.message = message;
	}

}

package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class MovieNotFound extends Exception {
	String message;

	public MovieNotFound(String message) {
		this.message = message;
	}

}

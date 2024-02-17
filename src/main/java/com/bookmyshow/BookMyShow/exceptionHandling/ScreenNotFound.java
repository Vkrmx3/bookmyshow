package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class ScreenNotFound extends Exception {
	String message;

	public ScreenNotFound(String message) {
		this.message = message;
	}

}

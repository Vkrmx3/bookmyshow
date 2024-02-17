package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class AdminNotFound extends Exception {
	String message;

	public AdminNotFound(String message) {
		this.message = message;
	}

}

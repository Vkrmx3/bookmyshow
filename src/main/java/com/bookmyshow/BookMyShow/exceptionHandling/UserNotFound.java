package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class UserNotFound extends Exception {
	String message;

	public UserNotFound(String message) {
		this.message = message;
	}

}

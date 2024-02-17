package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class CartNotFound extends Exception {
	String message;

	public CartNotFound(String message) {
		this.message = message;
	}

}

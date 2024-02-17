package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class SeatNotFound extends Exception {
	String message;

	public SeatNotFound(String message) {
		this.message = message;
	}

}

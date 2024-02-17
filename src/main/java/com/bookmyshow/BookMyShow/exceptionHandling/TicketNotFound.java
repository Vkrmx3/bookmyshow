package com.bookmyshow.BookMyShow.exceptionHandling;

import lombok.Getter;

@Getter
public class TicketNotFound extends Exception {
	String message;

	public TicketNotFound(String message) {
		this.message = message;
	}

}

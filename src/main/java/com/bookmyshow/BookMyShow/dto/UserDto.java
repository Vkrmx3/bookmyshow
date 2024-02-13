package com.bookmyshow.BookMyShow.dto;

import com.bookmyshow.BookMyShow.entity.Cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	private int userId;
	private String userName;
	private String userEmail;

	private Cart cart;

}

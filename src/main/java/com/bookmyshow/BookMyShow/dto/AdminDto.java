package com.bookmyshow.BookMyShow.dto;

import java.util.List;

import com.bookmyshow.BookMyShow.entity.Movie;
import com.bookmyshow.BookMyShow.entity.TheatreAdmin;
import com.bookmyshow.BookMyShow.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {

	private int adminId;
	private String adminName;
	private String adminEmail;

	private List<TheatreAdmin> theatreAdmin;
	private List<User> user;
	private List<Movie> movie;
}

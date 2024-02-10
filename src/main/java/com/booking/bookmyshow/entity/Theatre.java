package com.bookmyshow.BookMyShow.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;
	private String theatreName;
	
	@OneToMany
	private List<Screen> screen;
	
	@OneToMany
	private List<Movies> movies;
}

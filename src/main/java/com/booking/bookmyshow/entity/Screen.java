package com.bookmyshow.BookMyShow.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId;
	private String screenName;
	
	@OneToMany
	private List<Movies> movies;
	@OneToMany
	private List<Seats> seats;
	@OneToOne
	private List<Theatre> theatre;
}

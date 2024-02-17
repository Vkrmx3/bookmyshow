package com.bookmyshow.BookMyShow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
public class Theatre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreId;

	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be Blank")
	private String theatreName;

	@OneToMany
	private List<Screen> screen;
	@OneToMany
	private List<Movie> movie;
}

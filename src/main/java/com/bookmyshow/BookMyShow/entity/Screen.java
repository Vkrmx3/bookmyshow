package com.bookmyshow.BookMyShow.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId;

	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be Blank")
	private String screenName;

	private int totalNoOfSeats;
	private int availableSeats;
	@OneToOne
	private Movie movie;
	private Theatre theatre;
}

package com.bookmyshow.BookMyShow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Seats {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;
	private String seatType;
	private double seatCost;
}

package com.bookmyshow.BookMyShow.entity;

import com.bookmyshow.BookMyShow.dto.SeatType;

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
	private SeatType seatType;
	private double seatCost;
	public static final double seatCostSilver=50;
	public static final double seatCostGold=70;
	public static final double seatCostPlatinum=90;
}

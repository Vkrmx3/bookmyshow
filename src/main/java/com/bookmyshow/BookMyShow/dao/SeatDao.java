package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Seat;
import com.bookmyshow.BookMyShow.repo.SeatRepo;

@Repository
public class SeatDao {

	@Autowired
	SeatRepo repo;

	public Seat saveSeat(Seat seat) {
		return repo.save(seat);
	}

	public Seat findSeat(int seatId) {
		Optional<Seat> opSeats = repo.findById(seatId);
		if (opSeats.isPresent()) {
			return opSeats.get();
		}
		return null;
	}

	public Seat deleteSeat(int seatId) {
		Seat seat = findSeat(seatId);
		if (seat != null) {
			repo.delete(seat);
			return seat;
		}
		return null;
	}

	public Seat updateSeat(Seat seat, int seatId) {
		Seat exiSeat = findSeat(seatId);
		if (exiSeat != null) {
			seat.setSeatId(seatId);
			return repo.save(seat);
		}
		return null;
	}

	public List<Seat> getAllSeats() {
		return repo.findAll();
	}
}

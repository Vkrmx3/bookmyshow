package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Seats;
import com.bookmyshow.BookMyShow.repo.SeatsRepo;

@Repository
public class SeatsDao {

	@Autowired
	SeatsRepo sRepo;
	
	public Seats saveSeats(Seats seat) {
		return sRepo.save(seat);
	}
	
	public Seats findSeats(int seatId) {
		Optional<Seats> opSeats= sRepo.findById(seatId);
		if(opSeats.isPresent()) {
			return opSeats.get();
		}
		return null;
	}
	
	
	public Seats deleteSeats(int seatId) {
		Seats seats = findSeats(seatId);
		if(seats != null) {
			sRepo.delete(seats);
			return seats;
		}
		return null;
	}
	
	
	public Seats updateSeats(Seats seat, int seatId) {
		Seats exiSeats = findSeats(seatId);
		if(exiSeats!=null) {
			seat.setSeatId(seatId);
			return sRepo.save(seat);
		}
		return null;
	}
	
	
	public List<Seats> getAllSeats() {
		return sRepo.findAll();
	}
}

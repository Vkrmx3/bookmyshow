package com.bookmyshow.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.SeatDao;
import com.bookmyshow.BookMyShow.entity.Seat;
import com.bookmyshow.BookMyShow.exceptionHandling.SeatNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class SeatService {
	@Autowired
	SeatDao dao;

	public ResponseEntity<ResponseStructure<Seat>> saveSeat(Seat seat) {

		ResponseStructure<Seat> structure = new ResponseStructure();
		structure.setData(dao.saveSeat(seat));
		structure.setMessage("Seat Saved Successfully!!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Seat>> findSeat(int seatId) throws SeatNotFound {
		if (dao.findSeat(seatId) != null) {

			ResponseStructure<Seat> structure = new ResponseStructure();
			structure.setData(dao.findSeat(seatId));
			structure.setMessage("Seat Found Successfully!!");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		throw new SeatNotFound("Seat with id = " + seatId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(int seatId) throws SeatNotFound {
		Seat seat = dao.deleteSeat(seatId);
		if (seat != null) {
			ResponseStructure<Seat> structure = new ResponseStructure();
			structure.setData(seat);
			structure.setMessage("Seat with id = " + seatId + " is Successfully Removed!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new SeatNotFound("Seat with id = " + seatId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<Seat>> updateSeat(Seat seat, int seatId) throws SeatNotFound {
		Seat returnSeat = dao.updateSeat(seat, seatId);
		if (returnSeat != null) {

			ResponseStructure<Seat> structure = new ResponseStructure();
			structure.setData(returnSeat);
			structure.setMessage("Seat with id = " + seatId + "is Successfully Updated!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new SeatNotFound("Seat with id = " + seatId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<List<Seat>>> getAllSeats() {

		ResponseStructure<List<Seat>> structure = new ResponseStructure();
		structure.setData(dao.getAllSeats());
		structure.setMessage("Seats Retrived Successfully!!");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity(structure, HttpStatus.FOUND);
	}
}

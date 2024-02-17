package com.bookmyshow.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.TheatreDao;
import com.bookmyshow.BookMyShow.entity.Theatre;
import com.bookmyshow.BookMyShow.exceptionHandling.TheatreNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class TheatreService {
	@Autowired
	TheatreDao dao;

	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre) {

		ResponseStructure<Theatre> structure = new ResponseStructure();
		structure.setData(dao.saveTheatre(theatre));
		structure.setMessage("Theatre Saved Successfully!!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(int theatreId) throws TheatreNotFound {
		if (dao.findTheatre(theatreId) != null) {

			ResponseStructure<Theatre> structure = new ResponseStructure();
			structure.setData(dao.findTheatre(theatreId));
			structure.setMessage("Theatre Found Successfully!!");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		throw new TheatreNotFound("Theatre with id = " + theatreId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(int theatreId) throws TheatreNotFound {
		Theatre theatre = dao.deleteTheatre(theatreId);
		if (theatre != null) {
			ResponseStructure<Theatre> structure = new ResponseStructure();
			structure.setData(theatre);
			structure.setMessage("Theatre with id = " + theatreId + " is Successfully Removed!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new TheatreNotFound("Theatre with id = " + theatreId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(Theatre theatre, int theatreId)
			throws TheatreNotFound {
		Theatre returnTheatre = dao.updateTheatre(theatre, theatreId);
		if (returnTheatre != null) {

			ResponseStructure<Theatre> structure = new ResponseStructure();
			structure.setData(returnTheatre);
			structure.setMessage("Theatre with id = " + theatreId + "is Successfully Updated!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new TheatreNotFound("Theatre with id = " + theatreId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<List<Theatre>>> getAllTheatres() {

		ResponseStructure<List<Theatre>> structure = new ResponseStructure();
		structure.setData(dao.getAllTheatres());
		structure.setMessage("Theatres Retrived Successfully!!");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity(structure, HttpStatus.FOUND);
	}
}

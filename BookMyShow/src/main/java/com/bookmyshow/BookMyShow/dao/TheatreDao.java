package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Theatre;
import com.bookmyshow.BookMyShow.repo.TheatreRepo;

@Repository
public class TheatreDao {

	@Autowired
	TheatreRepo tRepo;
	
	public Theatre saveTheatre(Theatre theatre) {
		return tRepo.save(theatre);
	}
	
	public Theatre findTheatre(int theatreId) {
		Optional<Theatre> opTheatre = tRepo.findById(theatreId);
		if(opTheatre.isPresent()) {
			return opTheatre.get();
		}
		return null;
	}
	
	
	public Theatre deleteTheatre(int theatreId) {
		Theatre theatre = findTheatre(theatreId);
		if(theatre != null) {
			tRepo.delete(theatre);
			return theatre;
		}
		return null;
	}
	
	
	public Theatre updateTheatre(Theatre theatre, int theatreId) {
		Theatre exiTheatre = findTheatre(theatreId);
		if(exiTheatre!=null) {
			theatre.setTheatreId(theatreId);
			return tRepo.save(theatre);
		}
		return null;
	}
	
	
	public List<Theatre> getAllTheatre() {
		return tRepo.findAll();
	}
}

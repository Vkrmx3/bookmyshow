package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmyshow.BookMyShow.entity.TheatreAdmin;
import com.bookmyshow.BookMyShow.repo.TheatreAdminRepo;

public class TheatreAdminDao {

	@Autowired
	TheatreAdminRepo taRepo;
	
	public TheatreAdmin saveTheatreAdmin(TheatreAdmin theatreAdmin) {
		return taRepo.save(theatreAdmin);
	}
	
	public TheatreAdmin findTheatreAdmin(int theatreAdminId) {
		Optional<TheatreAdmin> opTheatreAdmin = taRepo.findById(theatreAdminId);
		if(opTheatreAdmin.isPresent()) {
			return opTheatreAdmin.get();
		}
		return null;
	}
	
	
	public TheatreAdmin deleteTheatreAdmin(int theatreAdminId) {
		TheatreAdmin theatreAdmin = findTheatreAdmin(theatreAdminId);
		if(theatreAdmin != null) {
			taRepo.delete(theatreAdmin);
			return theatreAdmin;
		}
		return null;
	}
	
	
	public TheatreAdmin updateTheatreAdmin(TheatreAdmin theatreAdmin, int theatreAdminId) {
		TheatreAdmin exiTheatreAdmin = findTheatreAdmin(theatreAdminId);
		if(exiTheatreAdmin!=null) {
			theatreAdmin.setTheatreAdminId(theatreAdminId);
			return taRepo.save(theatreAdmin);
		}
		return null;
	}
	
	
	public List<TheatreAdmin> getAllTheatreAdmin() {
		return taRepo.findAll();
	}
}

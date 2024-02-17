package com.bookmyshow.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.ScreenDao;
import com.bookmyshow.BookMyShow.entity.Screen;
import com.bookmyshow.BookMyShow.exceptionHandling.ScreenNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class ScreenService {
	@Autowired
	ScreenDao dao;

	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen screen) {

		ResponseStructure<Screen> structure = new ResponseStructure();
		structure.setData(dao.saveScreen(screen));
		structure.setMessage("Screen Saved Successfully!!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Screen>> findScreen(int screenId) throws ScreenNotFound {
		if (dao.findScreen(screenId) != null) {

			ResponseStructure<Screen> structure = new ResponseStructure();
			structure.setData(dao.findScreen(screenId));
			structure.setMessage("Screen Found Successfully!!");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		throw new ScreenNotFound("Screen with id = " + screenId + " does not Exxist");
	}

	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(int screenId) throws ScreenNotFound {
		Screen screen = dao.deleteScreen(screenId);
		if (screen != null) {
			ResponseStructure<Screen> structure = new ResponseStructure();
			structure.setData(screen);
			structure.setMessage("Screen with id = " + screenId + " is Successfully Removed!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new ScreenNotFound("Screen with id = " + screenId + " does not Exxist");
	}

	public ResponseEntity<ResponseStructure<Screen>> updateScreen(Screen screen, int screenId) throws ScreenNotFound {
		Screen returnScreen = dao.updateScreen(screen, screenId);
		if (returnScreen != null) {

			ResponseStructure<Screen> structure = new ResponseStructure();
			structure.setData(returnScreen);
			structure.setMessage("Screen with id = " + screenId + "is Successfully Updated!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new ScreenNotFound("Screen with id = " + screenId + " does not Exxist");
	}

	public ResponseEntity<ResponseStructure<List<Screen>>> getAllScreens() {

		ResponseStructure<List<Screen>> structure = new ResponseStructure();
		structure.setData(dao.getAllScreens());
		structure.setMessage("Screen Retrived Successfully!!");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity(structure, HttpStatus.FOUND);
	}
}

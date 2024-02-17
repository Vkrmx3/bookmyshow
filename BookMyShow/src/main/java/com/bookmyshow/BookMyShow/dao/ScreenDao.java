package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Screen;
import com.bookmyshow.BookMyShow.repo.ScreenRepo;

@Repository
public class ScreenDao {

	@Autowired
	ScreenRepo scRepo;
	
	public Screen saveScreen(Screen screen) {
		return scRepo.save(screen);
	}
	
	public Screen findScreen(int screenId) {
		Optional<Screen> opScreen = scRepo.findById(screenId);
		if(opScreen.isPresent()) {
			return opScreen.get();
		}
		return null;
	}
	
	
	public Screen deleteScreen(int screenId) {
		Screen screen = findScreen(screenId);
		if(screen != null) {
			scRepo.delete(screen);
			return screen;
		}
		return null;
	}
	
	
	public Screen updateScreen(Screen screen, int screenId) {
		Screen exiScreen = findScreen(screenId);
		if(exiScreen!=null) {
			screen.setScreenId(screenId);
			return scRepo.save(screen);
		}
		return null;
	}
	
	
	public List<Screen> getAllScreen() {
		return scRepo.findAll();
	}
}

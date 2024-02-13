package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Movies;
import com.bookmyshow.BookMyShow.repo.MoviesRepo;

@Repository
public class MoviesDao {

	@Autowired
	MoviesRepo mRepo;
	
	public Movies saveMovies(Movies movies) {
		return mRepo.save(movies);
	}
	
	public Movies findMovies(int moviesId) {
		Optional<Movies> opMovies = mRepo.findById(moviesId);
		if(opMovies.isPresent()) {
			return opMovies.get();
		}
		return null;
	}
	
	
	public Movies deleteMovies(int moviesId) {
		Movies movies = findMovies(moviesId);
		if(movies != null) {
			mRepo.delete(movies);
			return movies;
		}
		return null;
	}
	
	
	public Movies updateMovies(Movies movies, int moviesId) {
		Movies exiMovies = findMovies(moviesId);
		if(exiMovies!=null) {
			movies.setMovieId(moviesId);
			return mRepo.save(movies);
		}
		return null;
	}
	
	
	public List<Movies> getAllMovies() {
		return mRepo.findAll();
	}
}

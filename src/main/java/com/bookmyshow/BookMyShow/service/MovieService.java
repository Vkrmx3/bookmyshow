package com.bookmyshow.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.MovieDao;
import com.bookmyshow.BookMyShow.entity.Movie;
import com.bookmyshow.BookMyShow.exceptionHandling.MovieNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class MovieService {
	@Autowired
	MovieDao dao;

	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie movie) {

		ResponseStructure<Movie> structure = new ResponseStructure();
		structure.setData(dao.saveMovie(movie));
		structure.setMessage("Movie Saved Successfully!!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Movie>> findMovie(int movieId) throws MovieNotFound {
		if (dao.findMovie(movieId) != null) {

			ResponseStructure<Movie> structure = new ResponseStructure();
			structure.setData(dao.findMovie(movieId));
			structure.setMessage("Movie Found Successfully!!");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		throw new MovieNotFound("Movie with id = " + movieId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(int movieId) throws MovieNotFound {
		Movie movie = dao.deleteMovie(movieId);
		if (movie != null) {
			ResponseStructure<Movie> structure = new ResponseStructure();
			structure.setData(movie);
			structure.setMessage("Movie with id = " + movieId + " is Successfully Removed!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new MovieNotFound("Movie with id = " + movieId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<Movie>> updateMovie(Movie movie, int movieId) throws MovieNotFound {
		Movie returnMovie = dao.updateMovie(movie, movieId);
		if (returnMovie != null) {

			ResponseStructure<Movie> structure = new ResponseStructure();
			structure.setData(returnMovie);
			structure.setMessage("Movie with id = " + movieId + "is Successfully Updated!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new MovieNotFound("Movie with id = " + movieId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<List<Movie>>> getAllMovies() {

		ResponseStructure<List<Movie>> structure = new ResponseStructure();
		structure.setData(dao.getAllMovies());
		structure.setMessage("Movies Retrived Successfully!!");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity(structure, HttpStatus.FOUND);
	}
}

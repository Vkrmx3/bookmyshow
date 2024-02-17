package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Movie;
import com.bookmyshow.BookMyShow.repo.MovieRepo;

@Repository
public class MovieDao {

	@Autowired
	MovieRepo mRepo;

	public Movie saveMovie(Movie movie) {
		return mRepo.save(movie);
	}

	public Movie findMovie(int movieId) {
		Optional<Movie> opmovie = mRepo.findById(movieId);
		if (opmovie.isPresent()) {
			return opmovie.get();
		}
		return null;
	}

	public Movie deleteMovie(int movieId) {
		Movie movie = findMovie(movieId);
		if (movie != null) {
			mRepo.delete(movie);
			return movie;
		}
		return null;
	}

	public Movie updateMovie(Movie movie, int movieId) {
		Movie eximovie = findMovie(movieId);
		if (eximovie != null) {
			movie.setMovieId(movieId);
			return mRepo.save(movie);
		}
		return null;
	}

	public List<Movie> getAllMovies() {
		return mRepo.findAll();
	}
}

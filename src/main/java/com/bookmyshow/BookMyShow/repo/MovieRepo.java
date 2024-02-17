package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.BookMyShow.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}

package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.BookMyShow.entity.Movies;

public interface MoviesRepo extends JpaRepository<Movies, Integer>{

}

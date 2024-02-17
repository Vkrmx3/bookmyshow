package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.BookMyShow.entity.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre, Integer> {

}

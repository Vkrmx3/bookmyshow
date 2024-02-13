package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.BookMyShow.entity.Seats;

public interface SeatsRepo extends JpaRepository<Seats, Integer>{

}

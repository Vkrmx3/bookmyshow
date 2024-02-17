package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.BookMyShow.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {

}

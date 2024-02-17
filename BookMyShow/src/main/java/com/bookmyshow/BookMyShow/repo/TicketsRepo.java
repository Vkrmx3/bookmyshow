package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.BookMyShow.entity.Tickets;

public interface TicketsRepo extends JpaRepository<Tickets, Integer>{

}

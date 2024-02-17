package com.bookmyshow.BookMyShow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.BookMyShow.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}

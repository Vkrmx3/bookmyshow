package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Tickets;
import com.bookmyshow.BookMyShow.repo.TicketsRepo;

@Repository
public class TicketsDao {

	@Autowired
	TicketsRepo tiRepo;
	
	public Tickets saveTickets(Tickets ticket) {
		return tiRepo.save(ticket);
	}
	
	public Tickets findTickets(int ticketId) {
		Optional<Tickets> opTickets = tiRepo.findById(ticketId);
		if(opTickets.isPresent()) {
			return opTickets.get();
		}
		return null;
	}
	
	
	public Tickets deleteTickets(int ticketId) {
		Tickets ticket = findTickets(ticketId);
		if(ticket != null) {
			tiRepo.delete(ticket);
			return ticket;
		}
		return null;
	}
	
	
	public Tickets updateTickets(Tickets ticket, int ticketId) {
		Tickets exiTickets = findTickets(ticketId);
		if(exiTickets!=null) {
			ticket.setTicketId(ticketId);
			return tiRepo.save(ticket);
		}
		return null;
	}
	
	
	public List<Tickets> getAllTickets() {
		return tiRepo.findAll();
	}
}

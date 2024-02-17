package com.bookmyshow.BookMyShow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmyshow.BookMyShow.entity.Ticket;
import com.bookmyshow.BookMyShow.repo.TicketRepo;

@Repository
public class TicketDao {

	@Autowired
	TicketRepo repo;

	public Ticket saveTicket(Ticket ticket) {
		return repo.save(ticket);
	}

	public Ticket findTicket(int ticketId) {
		Optional<Ticket> opTickets = repo.findById(ticketId);
		if (opTickets.isPresent()) {
			return opTickets.get();
		}

		return null;
	}

	public Ticket deleteTicket(int ticketId) {
		Ticket ticket = findTicket(ticketId);
		if (ticket != null) {
			repo.delete(ticket);
			return ticket;
		}
		return null;
	}

	public Ticket updateTicket(Ticket ticket, int ticketId) {
		Ticket exiTickets = findTicket(ticketId);
		if (exiTickets != null) {
			ticket.setTicketId(ticketId);
			return repo.save(ticket);
		}
		return null;
	}

	public List<Ticket> getAllTickets() {
		return repo.findAll();
	}
}

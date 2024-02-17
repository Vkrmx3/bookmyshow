package com.bookmyshow.BookMyShow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookmyshow.BookMyShow.dao.TicketDao;
import com.bookmyshow.BookMyShow.entity.Ticket;
import com.bookmyshow.BookMyShow.exceptionHandling.TicketNotFound;
import com.bookmyshow.BookMyShow.util.ResponseStructure;

@Service
public class TicketService {
	@Autowired
	TicketDao dao;

	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket) {

		ResponseStructure<Ticket> structure = new ResponseStructure();
		structure.setData(dao.saveTicket(ticket));
		structure.setMessage("Ticket Saved Successfully!!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Ticket>> findTicket(int ticketId) throws TicketNotFound {
		if (dao.findTicket(ticketId) != null) {

			ResponseStructure<Ticket> structure = new ResponseStructure();
			structure.setData(dao.findTicket(ticketId));
			structure.setMessage("Ticket Found Successfully!!");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity(structure, HttpStatus.FOUND);
		}
		throw new TicketNotFound("Ticket with id = " + ticketId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(int ticketId) throws TicketNotFound {
		Ticket ticket = dao.deleteTicket(ticketId);
		if (ticket != null) {
			ResponseStructure<Ticket> structure = new ResponseStructure();
			structure.setData(ticket);
			structure.setMessage("Ticket with id = " + ticketId + " is Successfully Removed!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new TicketNotFound("Ticket with id = " + ticketId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(Ticket ticket, int ticketId) throws TicketNotFound {
		Ticket returnTicket = dao.updateTicket(ticket, ticketId);
		if (returnTicket != null) {

			ResponseStructure<Ticket> structure = new ResponseStructure();
			structure.setData(returnTicket);
			structure.setMessage("Ticket with id = " + ticketId + "is Successfully Updated!!");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity(structure, HttpStatus.OK);
		}
		throw new TicketNotFound("Ticket with id = " + ticketId + " does not Exist");
	}

	public ResponseEntity<ResponseStructure<List<Ticket>>> getAllTickets() {

		ResponseStructure<List<Ticket>> structure = new ResponseStructure();
		structure.setData(dao.getAllTickets());
		structure.setMessage("Ticket Retrived Successfully!!");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity(structure, HttpStatus.FOUND);
	}
}

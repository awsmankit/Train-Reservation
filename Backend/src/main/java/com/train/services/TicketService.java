package com.train.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.train.Entity.Ticket;
import com.train.dao.TicketDao;

@Transactional // Annotates the class to enable transaction management for all the methods of the class.
@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;

	// This method adds a new ticket to the ticketDao.
	public Ticket AddTicket(Ticket ticket) {
		return ticketDao.save(ticket);
	}

	// This method finds a ticket in the ticketDao by ticketNo.
	public Ticket FindTicketByNo(int no) {
		Ticket ticket = ticketDao.findTicketByNo(no);
		return ticket;
	}

	// This method finds a ticket in the ticketDao by passengerId.
	public Ticket FindTicketByPassId(int no) {
		Ticket ticket = ticketDao.findTicketByPassengerId(no);
		return ticket;
	}

	// This method finds ticket details in the ticketDao by ticketNo.
	public Object[] findTicketDetails(int id) {
		Object[] ticket = ticketDao.findTicketDetails(id);
		return ticket;
	}

	// This method finds past ticket details in the ticketDao by passengerId.
	public List<Object[]> findPastTicketDetails(int id) {
		List<Object[]> ticket = ticketDao.findPastTicketDetails(id);
		return ticket;
	}

	// This method finds upcoming ticket details in the ticketDao by passengerId.
	public List<Object[]> findUpcomingTicketDetails(int id) {
		List<Object[]> ticket = ticketDao.findUpcomingTicketDetails(id);
		return ticket;
	}

	// This method finds all ticket details in the ticketDao by passengerId.
	public List<Object[]> findAllTicketDetails(int id) {
		List<Object[]> ticket = ticketDao.findAllTicketDetails(id);
		return ticket;
	}

	// This method cancels a ticket in the ticketDao by passengerId.
	public Ticket cancelTicket(int id, String status) {
		Ticket ticket = ticketDao.findTicketByPassengerId(id);
		ticket.setPaymentStatus(status);
		Ticket result = ticketDao.save(ticket);

		return result;
	}

	// This method updates the status of a ticket in the ticketDao.
	public void BookCancelTicket(int uid, int Upid, String status, int pid) {
		ticketDao.UpdateCancelTicket(uid, Upid, status, pid);

	}

	// This method books an available ticket in the ticketDao.
	public void BookAvailableTicket(int TrainNo, int UId, int PId, String PaymentStatus, Date TrainDate) {
		ticketDao.BookAvailableTicket(TrainNo, UId, PId, PaymentStatus, TrainDate);
	}
}

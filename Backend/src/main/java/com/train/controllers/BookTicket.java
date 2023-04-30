package com.train.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.train.Entity.Passenger;
import com.train.services.BookTicketService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookTicket {

	@Autowired
	private BookTicketService bookticketService;

	// Constructor for BookTicket class
	public BookTicket() {
		System.out.println("in ctor of  " + getClass().getName());
	}

	// Endpoint to book a ticket for a train
	@PostMapping("/bookTicket/{TrainNo}/{date}/{userid}")
	public ResponseEntity<?> BookTicket(@RequestBody List<Passenger> psgr, @PathVariable("TrainNo") int tno,
			@PathVariable("date") Date date, @PathVariable("userid") int userid) {
		// Call the BookTicket method of the BookTicketService class and return the
		// response
		return Response.success(bookticketService.BookTicket(psgr, tno, date, userid));
	}
}
























//
//package com.train.controllers;
//
//import java.sql.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.train.Entity.Passenger;
//import com.train.dao.SeatsDao;
//import com.train.dao.TrainDao;
//import com.train.services.BookTicketService;
//import com.train.services.SeatServiceImpl;
//import com.train.services.TicketService;
//import com.train.services.TrainServiceImpl;
//import com.train.services.UserServiceImpl;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//public class BookTicket {
//
//	@Autowired
//	private BookTicketService bookticketService;
//
//	@Autowired
//	private UserServiceImpl userService;
//
//	@Autowired
//	private TrainServiceImpl trainService;
//
//	@Autowired
//	private TicketService ticketService;
//
//	@Autowired
//	private SeatsDao seatsDao;
//
//	@Autowired
//	private SeatServiceImpl seatService;
//
//	@Autowired
//	private TrainDao traindao;
//
//	public BookTicket() {
//		System.out.println("in ctor of  " + getClass().getName());
//	}
//
//	@PostMapping("/bookTicket/{TrainNo}/{date}/{userid}")
//	public ResponseEntity<?> BookTicket(@RequestBody List<Passenger> psgr, @PathVariable("TrainNo") int tno,
//			@PathVariable("date") Date date, @PathVariable("userid") int userid) {
//		return Response.success(bookticketService.BookTicket(psgr, tno, date, userid));
//
//	}
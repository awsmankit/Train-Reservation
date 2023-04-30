package com.train.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.train.Entity.Passenger;
import com.train.Entity.Seats;
import com.train.Entity.Train;
import com.train.controllers.Response;
import com.train.dao.SeatsDao;
import com.train.dao.TrainDao;

@Transactional
@Service
public class BookTicketService {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private TrainServiceImpl trainService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private SeatsDao seatsDao;

	@Autowired
	private SeatServiceImpl seatService;

	@Autowired
	private TrainDao traindao;

	public BookTicketService() {
		System.out.println("in ctor of  " + getClass().getName());
	}

	// This method books a ticket for the given passenger list, train number, date,
	// and user ID
	public ResponseEntity<?> BookTicket(List<Passenger> psgr, int tno, Date date, int userid) {
		// Passenger passenger= userService.AddPassenger(psgr);
		List<Passenger> passenger = new ArrayList(psgr);
		System.out.println(passenger.toArray());
		boolean check;
		int availableSeats = 0;

		for (int i = 0; i < passenger.size(); i++) {
			// passenger.set(i, userService.AddPassenger(psgr.get(i)));
			userService.AddPassenger(psgr.get(i));
			int UPid = passenger.get(i).getId();
			System.out.println(UPid);
			// Date trainDate=Date.valueOf("date") ;
			Date trainDate = date;
			int Uid = userid;
			int TrainNO = tno;
			String status = "sucess";

			int totalSeats = trainService.FindTrainByNo(TrainNO).getTotalSeats();

			// Counting seats that are neither booked nor canceled
			int countfinal = seatsDao.getCountwithoutStatus(TrainNO, trainDate);
			// Counting booked seats
			int count = seatsDao.getCount(TrainNO, trainDate);
			// Counting canceled seats
			int count2 = seatsDao.getCountforCancel(TrainNO, trainDate);
			availableSeats = totalSeats - (count + count2);
			int seatNo = countfinal + 1;

			List<Seats> seats = seatsDao.seatsByDateTrainNo(TrainNO, trainDate);

			Train train = trainService.FindTrainByNo(TrainNO);

			if (countfinal < train.getTotalSeats()) {
				// Adding available seat with status "success"
				seatService.AddAvailabelSeats(status, UPid, seatNo, TrainNO, trainDate);
				// Booking ticket with status "success"
				ticketService.BookAvailableTicket(TrainNO, Uid, UPid, status, trainDate);
				seatNo++;
				availableSeats = availableSeats - 1;
				// Updating the available seats count for the given train and date
				int update = trainService.UpdateAvailableSeats(availableSeats, TrainNO, trainDate);
				// count++ ;
				System.out.println("available seats booked  availableSeats= " + availableSeats);
				// Response.success("available seats booked!!! available
				// seats="+availableSeats);
				continue;
			}

			check = false;
			for (int j = 0; j < seats.size() && !check; j++) {
				// boolean check=seats.get(j).getSeatStatus().equals("cancel");
				int Pid = seats.get(j).getPassengerId();

				seatService.BookCancelSeat(status, UPid, Pid); // booking cancelled seat
				ticketService.BookCancelTicket(Uid, UPid, status, Pid); // booking cancelled ticket
				int update = trainService.UpdateAvailableSeats(availableSeats, TrainNO, trainDate); // updating
																									// available seats
				System.out.println("cancel seats booked");
				check = true;
			}

			if (count >= train.getTotalSeats()) {
				// If all the seats are already booked, print a message to notify the user
				System.out.println("Seats are not available to book all seats are booked!!   ");
			}
		}
		// Check if there are any available seats left
		if (availableSeats == 0) {
			// If no available seats left, return an error response with a message
			return Response.error("Seats are not available to book all seats are booked!! ");
		}

		// If available seats are still present, return a success response with a
		// message that the ticket is booked
		return Response.success("ticket is booked ");

	}
}

package com.train.services;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.Entity.Seats;
import com.train.dao.CalenderDao;
import com.train.dao.SeatsDao;

@Transactional
@Service
public class SeatServiceImpl {

	@Autowired
	private SeatsDao seatDao;

	@Autowired
	private CalenderDao calenderdao;

	// Adds a new seat to the database
	public Seats AddSeat(Seats seat) {
		return seatDao.save(seat);
	}

	// Cancels a seat based on the passenger id and updates the status
	public Seats cancelSeat(int id, String status) {
		Seats seat = seatDao.findSeatByPassengerId(id);
		seat.setSeatStatus(status);
		Seats result = seatDao.save(seat);

		return result;
	}

	// Updates the status of a booked seat to canceled
	public void BookCancelSeat(String status, int UPid, int Pid) {
		seatDao.UpdateCancelSeat(status, UPid, Pid);
	}

	// Adds a new available seat to the database
	public void AddAvailabelSeats(String SeatStatus, int PassengerId, int SeatNo, int TrainNo, Date trainDate) {
		seatDao.AddAvailabeSeat(SeatStatus, PassengerId, SeatNo, TrainNo, trainDate);
	}

	// Cancels a seat based on the seat number, train number and date
	// Updates the available seats for the train and date in the calendar
	public void CancelSeat2(String status, int seatNo, int trainNo, Date date) {
		seatDao.cancelSeat2(status, seatNo, trainNo, date);

		// Get the available seats for the train and date from the calendar
		int availableSeat2 = calenderdao.getAvailableseats(trainNo, date);

		// Update the available seats for the train and date in the calendar
		calenderdao.UpdateAvailableSeats((availableSeat2 + 1), trainNo, date);
	}
}

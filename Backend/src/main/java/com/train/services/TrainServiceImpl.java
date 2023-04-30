package com.train.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.train.Entity.Calender;
import com.train.Entity.Train;
import com.train.dao.CalenderDao;
import com.train.dao.TicketDao;
import com.train.dao.TrainDao;
import com.train.dtos.TrainDto;

@Transactional // Annotates the class to enable transaction management for all the methods of the class.
@Service // Indicates that this class is a service component in the application.
public class TrainServiceImpl {

	@Autowired // This annotation marks the trainDao as needing dependency injection.
	private TrainDao trainDao; // Injecting the trainDao dependency.

	@Autowired // This annotation marks the calenderDao as needing dependency injection.
	private CalenderDao calenderDao; // Injecting the calenderDao dependency.

	@Autowired // This annotation marks the ticketDao as needing dependency injection.
	private TicketDao ticketDao; // Injecting the ticketDao dependency.

	// This method returns all trains in the trainDao.
	public List<Train> ShowAllTrains() {
		return trainDao.findAll();
	}

	// This method searches for trains in the trainDao based on source, destination, and date.
	public List<Object[]> searchTrain(String source, String destination, Date date) {
		List<Object[]> train = trainDao.SearchTrain(source, destination, date);
		return train;
	}

	// This method adds a train to the trainDao.
	public Train AddTrain(Train train) {
		return trainDao.save(train);
	}

	// This method deletes a train from the trainDao.
	public int DeleteTrain(int no) {
		if (trainDao.existsById(no)) {
			ticketDao.deleteTicketByTrainNo(no);
			calenderDao.deleteCalenderByTrainNo(no);
			trainDao.deleteTrainByNo(no);
			return 1;
		}
		return 0;
	}

	// This method finds all trains in the trainDao by trainNo.
	public List<Train> FindTrainBytrainNo(int no) {
		List<Train> train = trainDao.findTrainBytrainNo(no);
		return train;
	}

	// This method finds a train in the trainDao by no.
	public Train FindTrainByNo(int no) {
		Train train = trainDao.findTrainByNo(no);
		return train;
	}

	// This method finds trains in the trainDao by date.
	public List<Object[]> findtrainByDate(Date date) {
		List<Object[]> train = trainDao.findTrainByDate(date);
		return train;
	}

	// This method updates a train in the trainDao based on trainNo.
	public Train EditTrain(int no, TrainDto traindto) {
		Train train = trainDao.findTrainByNo(no);
		if (train != null) {
			train.setArrivalTime(traindto.getArrivalTime());
			train.setDepartureTime(traindto.getDepartureTime());
			train.setTotalSeats(traindto.getTotalSeats());
			train.setFair(traindto.getFair());

			Train updatedTrain = trainDao.save(train);
			return updatedTrain;
		} else
			return null;
	}

	// This method adds a train calendar to the calenderDao.
	public Calender AddTrainCalender(Calender cal) {
		return calenderDao.save(cal);
	}

	// This method updates the available seats in the Calendar table for a given train number and date
	public int UpdateAvailableSeats(int seats, int trainNo, Date trainDate) {
		return calenderDao.UpdateAvailableSeats(seats, trainNo, trainDate);
	}

	// This method retrieves all distinct source stations from the Train table
	public List<String> getAllSources() {
		return trainDao.findDistinctSources();
	}

	// This method retrieves all distinct destination stations from the Train table
	public List<String> getAllDestinations() {
		return trainDao.findDistinctDestinations();
	}

	// This method retrieves all trains from the Train table for a given source and destination
	public List<Train> getTrainsBySourceAndDestination(String source, String destination) {
		return trainDao.findBySourceAndDestination(source, destination);
	}
}

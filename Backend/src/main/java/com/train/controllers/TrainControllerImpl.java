package com.train.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.Entity.Calender;
import com.train.Entity.Train;
import com.train.dtos.Response;
import com.train.dtos.SearchtrainDto;
import com.train.dtos.TrainDto;
import com.train.services.TrainServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/train")
@RestController
public class TrainControllerImpl {

	@Autowired
	private TrainServiceImpl trainService;

	// Returns a list of all trains
	@GetMapping("/all")
	public ResponseEntity<?> trainList() {
		List<Train> trainlist = trainService.ShowAllTrains();
		return Response.success(trainlist);
	}

	// Adds a train
	@PostMapping("/addtrain")
	public ResponseEntity<?> AddTrain(@RequestBody Train train) {
		Train result = trainService.AddTrain(train);
		return Response.success(result);
	}

	// Deletes a train
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<?> Deletetrain(@PathVariable("no") int no) {
		int count = trainService.DeleteTrain(no);
		return Response.success(count);
	}

	// Finds a train by train number
	@GetMapping("/trainByNo/{no}")
	public ResponseEntity<?> FindByNo(@PathVariable("no") int no) {
		List<Train> train = trainService.FindTrainBytrainNo(no);
		return Response.success(train);
	}

	// Finds trains by date
	@GetMapping("/trainByDate/{date}")
	public ResponseEntity<?> trainDate(@PathVariable("date") Date date) {
		List<Object[]> train = trainService.findtrainByDate(date);
		return ResponseEntity.ok(train);
	}

	// Edits a train
	@PatchMapping("/editTrain/{no}")
	public ResponseEntity<?> EditTrain(@PathVariable("no") int no, @RequestBody TrainDto train) {
		Train updatedTrain = trainService.EditTrain(no, train);
		return Response.success(updatedTrain);
	}

	// Searches for trains based on source, destination and date
	@GetMapping("/{source}/{destination}/{date}")
	public ResponseEntity<?> searchTrain(@PathVariable("source") String source,
			@PathVariable("destination") String destination, @PathVariable("date") Date date) {
		List<Object[]> train = trainService.searchTrain(source, destination, date);
		if (!train.isEmpty())
			return Response.success(train);
		return Response.error("train not found");
	}

	// Searches for trains based on search criteria
	@PostMapping("/search")
	public ResponseEntity<?> searchTrain2(@RequestBody SearchtrainDto searchTrain) {
		String source = searchTrain.getSource();
		String destination = searchTrain.getDestination();
		Date date = searchTrain.getDate();
		List<Object[]> train = trainService.searchTrain(source, destination, date);
		return Response.success(train);
	}

	// Returns a list of all sources
	@GetMapping("/sources")
	public List<String> getAllSources() {
		return trainService.getAllSources();
	}

	// Returns a list of all destinations
	@GetMapping("/destinations")
	public List<String> getAllDestinations() {
		return trainService.getAllDestinations();
	}

	// Adds a train to the calendar
	@PostMapping("/addtrainCalendar")
	public ResponseEntity<?> AddTrain(@RequestBody Calender Cal) {
		Calender result = trainService.AddTrainCalender(Cal);

		return Response.success(result);
	}
}

package com.train.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.train.Entity.Passenger;
import com.train.Entity.Train;
import com.train.Entity.User;
import com.train.dtos.UserDTO;
import com.train.services.TrainServiceImpl;
import com.train.services.UserServiceImpl;

// The request mapping annotation specifies the base URI for which the controller will handle requests
@RequestMapping("/user")
@RestController

// The cross-origin annotation allows cross-origin resource sharing (CORS) requests to be made to this controller from a specified origin
@CrossOrigin(origins = "http://localhost:3000")
public class UserControllerImpl {

	// This field is autowired and will be injected with a UserServiceImpl instance by Spring
	@Autowired
	private UserServiceImpl userService;

	// This field is autowired and will be injected with a TrainServiceImpl instance by Spring
	@Autowired
	private TrainServiceImpl trainService;

	// This GET mapping returns a list of all users
	@GetMapping("/all")
	public List<User> AllUsers() {
		return userService.findAllUsers();
	}

	// This POST mapping saves a new user to the database
	@PostMapping("/signup")
	public ResponseEntity<?> SaveUser(@RequestBody User user) {
		User result = userService.saveUser(user);
		return Response.success(result);
	}

	// This DELETE mapping deletes a user with a specified ID
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> DeleteUser(@PathVariable("id") int id) {
		int result = userService.DeleteUser(id);
		return Response.success(result);
	}

	// This POST mapping adds a passenger to a user's passenger list
	@PostMapping("/AddPassenger")
	public ResponseEntity<?> AddPassenger(@RequestBody Passenger psgr) {
		Passenger pas = userService.AddPassenger(psgr);
		return Response.success(pas);
	}

	// This GET mapping returns a user with a specified ID
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {
		User user = userService.findUserById(id);
		if (user.getId() == id)
			return Response.success(user);

		return Response.error(user);
	}

	// This GET mapping returns a list of all trains
	@GetMapping("/trainlist")
	public ResponseEntity<?> trainList() {
		List<Train> trainList = trainService.ShowAllTrains();
		return Response.error(trainList);
	}

	// This PUT mapping updates a user's information with a specified ID
	@PutMapping("/update/{id}")
	public ResponseEntity<?> UpdateUser(@PathVariable("id") int id, @RequestBody UserDTO user) {
		User updatedUser = userService.updateUser(id, user);
		return Response.success(updatedUser);
	}

	// This PATCH mapping changes a user's password with a specified ID
	@PatchMapping("/changepass/{id}")
	public ResponseEntity<?> ChangePass(@PathVariable("id") int id, @RequestBody UserDTO pass) {
		User ChangePass = userService.ChangePassword(id, pass);
		return Response.success(ChangePass);
	}

}




























//package com.train.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.train.Entity.Passenger;
//import com.train.Entity.Train;
//import com.train.Entity.User;
//import com.train.dtos.UserDTO;
//import com.train.services.TrainServiceImpl;
//import com.train.services.UserServiceImpl;
//
//@RequestMapping("/user")
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class UserControllerImpl {
//
//	@Autowired
//	private UserServiceImpl userService;
//
//	@Autowired
//	private TrainServiceImpl trainService;
//
//	// @RequestMapping(method=RequestMethod.GET, path="/users")
//	@GetMapping("/all")
//	public List<User> AllUsers() {
//		return userService.findAllUsers();
//	}
//
//	@PostMapping("/signup")
//	public ResponseEntity<?> SaveUser(@RequestBody User user) {
//		User result = userService.saveUser(user);
//		return Response.success(result);
//	}
//
//	@DeleteMapping("/deleteUser/{id}")
//	public ResponseEntity<?> DeleteUser(@PathVariable("id") int id) {
//		int result = userService.DeleteUser(id);
//
//		return Response.success(result);
//	}
//
//	@PostMapping("/AddPassenger")
//	public ResponseEntity<?> AddPassenger(@RequestBody Passenger psgr) {
//		Passenger pas = userService.AddPassenger(psgr);
//		return Response.success(pas);
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<?> findById(@PathVariable("id") int id) {
//		User user = userService.findUserById(id);
//		if (user.getId() == id)
//			return Response.success(user);
//
//		return Response.error(user);
//	}
//
//	@GetMapping("/trainlist")
//	public ResponseEntity<?> trainList() {
//		List<Train> trainList = trainService.ShowAllTrains();
//		return Response.error(trainList);
//	}
//
//	@PutMapping("/update/{id}")
//	public ResponseEntity<?> UpdateUser(@PathVariable("id") int id, @RequestBody UserDTO user) {
//		User updatedUser = userService.updateUser(id, user);
//		return Response.success(updatedUser);
//	}
//
//	@PatchMapping("/changepass/{id}")
//	public ResponseEntity<?> ChangePass(@PathVariable("id") int id, @RequestBody UserDTO pass) {
//		User ChangePass = userService.ChangePassword(id, pass);
//		return Response.success(ChangePass);
//
//	}
//
//}

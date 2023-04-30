package com.train.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.Entity.Role;
import com.train.Entity.Train;
import com.train.Entity.User;
import com.train.dao.UserDao;
import com.train.dtos.UserDTO;
import com.train.services.AdminServiceImpl;
import com.train.services.TrainServiceImpl;

@RestController
@RequestMapping("/admin") // set base URL for this controller
@CrossOrigin(origins = "http://localhost:3000") // allow CORS from localhost:3000
public class AdminControllerImpl {

	@Autowired
	private AdminServiceImpl adminService; // inject AdminServiceImpl bean

	@Autowired
	private TrainServiceImpl trainService; // inject TrainServiceImpl bean

	@Autowired
	private UserDao userDao; // inject UserDao bean

	@PostMapping("/addAdmin") // handle POST request to /admin/addAdmin
	public ResponseEntity<?> saveAdmin(@RequestBody UserDTO userDto) { // get request body as UserDTO object
		User user = new User(); // create User object
		user.setEmail(userDto.getEmail()); // set email from userDto
		user.setPassword(userDto.getPassword()); // set password from userDto
		user.setRole(Role.ADMIN); // set role as ADMIN

		User result = adminService.saveAdmin(user); // save User object using adminService
		if (result != null) { // if save successful
			return Response.success(result); // return success response with User object as body
		} else { // if save failed
			return Response.error("admin not added"); // return error response with message as body
		}
	}

	@GetMapping("/all") // handle GET request to /admin/all
	public ResponseEntity<?> allAdmins() { 
		List<User> admins = adminService.findAllAdmins(); // get list of all admins from adminService
		if (admins != null && !admins.isEmpty()) { // if list is not empty
			return Response.success(admins); // return success response with list as body
		} else { // if list is empty
			return Response.error("admin not found"); // return error response with message as body
		}
	}

	@PutMapping("/update/{id}") // handle PUT request to /admin/update/{id}
	public ResponseEntity<?> updateAdmin(@PathVariable("id") int id, @RequestBody UserDTO userDto) { // get {id} as int and request body as UserDTO object
		User user = userDao.getById(id); // get User object from userDao using id
		if (user != null && user.getRole() == Role.ADMIN) { // if User object exists and has ADMIN role
			user.setEmail(userDto.getEmail()); // set email from userDto
			user.setPassword(userDto.getPassword()); // set password from userDto
			User updatedAdmin = adminService.saveAdmin(user); // save User object using adminService
			return Response.success(updatedAdmin); // return success response with updated User object as body
		} else { // if User object not found or does not have ADMIN role
			return Response.error("admin not found"); // return error response with message as body
		}
	}

	@GetMapping("/trainlist") // handle GET request to /admin/trainlist
	public List<Train> trainList() {
		List<Train> trainlist = trainService.ShowAllTrains(); // get list of all trains

		return trainlist;
	}
}




















































//package com.train.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.train.Entity.Role;
//import com.train.Entity.Train;
//import com.train.Entity.User;
//import com.train.dao.UserDao;
//
//import com.train.dtos.UserDTO;
//import com.train.services.AdminServiceImpl;
//import com.train.services.TrainServiceImpl;
//
//@RestController
//@RequestMapping("/admin")
//@CrossOrigin(origins = "http://localhost:3000")
//public class AdminControllerImpl {
//
//    @Autowired
//    private AdminServiceImpl adminService;
//
//    @Autowired
//    private TrainServiceImpl trainService;
//
//    @Autowired
//    private UserDao userDao;
//
//    @PostMapping("/addAdmin")
//    public ResponseEntity<?> saveAdmin(@RequestBody UserDTO userDto) {
//        User user = new User();
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setRole(Role.ADMIN);
//
//        User result = adminService.saveAdmin(user);
//        if (result != null) {
//            return Response.success(result);
//        } else {
//            return Response.error("admin not added");
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<?> allAdmins() {
//        List<User> admins = adminService.findAllAdmins();
//        if (admins != null && !admins.isEmpty()) {
//            return Response.success(admins);
//        } else {
//            return Response.error("admin not found");
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateAdmin(@PathVariable("id") int id, @RequestBody AdminDto adminDto) {
//        User user = userDao.getById(id);
//        if (user != null && user.getRole() == Role.ADMIN) {
//            user.setEmail(adminDto.getEmail());
//            user.setPassword(adminDto.getPassword());
//            User updatedAdmin = adminService.saveAdmin(user);
//            return Response.success(updatedAdmin);
//        } else {
//            return Response.error("admin not found");
//        }
//    }
//
//    @GetMapping("/trainlist")
//    public List<Train> trainList() {
//        List<Train> trainlist = trainService.ShowAllTrains();
//        return trainlist;
//    }
//}

//package com.train.controllers;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.WebRequest;
//
//import com.train.Entity.Admin;
//import com.train.Entity.Train;
//import com.train.Entity.User;
//import com.train.dao.AdminDao;
//import com.train.dtos.AdminDto;
//import com.train.dtos.UserDTO;
//import com.train.exception.ErrorDetails;
//import com.train.services.AdminServiceImpl;
//import com.train.services.TrainServiceImpl;
//
//@RequestMapping("/admin")
//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//public class AdminControllerImpl {
//
//	@Autowired
//	private AdminServiceImpl adminService;
//	
//	@Autowired
//	private TrainServiceImpl trainService;
//	
//	
//	
//	@PostMapping("/addAdmin")
//	public ResponseEntity<?> SaveAdmin(@RequestBody Admin admin) {
//		Admin result= adminService.saveAdmin( admin);
//		if(result!=null) 
//			return Response.success(result);
//		else
//			return Response.error("admin not added");
//	}
//	
//	@GetMapping("/all")
//	public  ResponseEntity<?> AllAdmins()
//	{
//		List<Admin> admins=adminService.findAllAdmins();
//		if(admins!=null) 
//			return Response.success(admins);
//		else
//			return Response.error("admin not added");
//		
//	}
//	
//	@PutMapping("/update/{id}")
//	public ResponseEntity<?> UpdateAdmin(@PathVariable("id") int id, @RequestBody AdminDto admin  )
//	{
//		Admin updatedAdmin= adminService.UpdateAdmin(id, admin);
//		return  Response.success(updatedAdmin);
//	}
//	
//	@GetMapping("/trainlist")
//	public @ResponseBody List<Train> trainList()
//	{
//		List<Train> trainlist=trainService.ShowAllTrains();
//		
//		return trainlist;
//	}
//	
//	
//}

package com.train.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.train.Entity.Role;
import com.train.Entity.User;
import com.train.dtos.CredentialsDTO;
import com.train.services.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginControllerImpl {

    @Autowired
    private UserServiceImpl userService;

    // Endpoint to sign in a user with credentials
    @PostMapping("/user/login")
    public ResponseEntity<?> signInUser(@RequestBody CredentialsDTO cred) { // take into json in the body
        // Find user with given email and password
        User user = userService.findUserByEmailAndPassword(cred.getEmail(), cred.getPassword());

        // If user is not found, return error response
        if (user == null) {
            return Response.error("User not found");
        } 
        // If user is found but not a user type, return error response
        else if (user.getRole() != Role.USER) {
            return Response.error("User not allowed to sign in");
        } 
        // If user is found and is a user type, return success response with user object
        else {
            return Response.success(user);
        }
    }

    // Endpoint to sign in an admin with credentials
    @PostMapping("/admin/login")
    public ResponseEntity<?> signInAdmin(@RequestBody CredentialsDTO cred) {
        // Find user with given email and password
        User user = userService.findUserByEmailAndPassword(cred.getEmail(), cred.getPassword());

        // If user is not found or not an admin type, return error response
        if (user == null || user.getRole() != Role.ADMIN) {
            return Response.error("Admin not found");
        } 
        // If user is found and is an admin type, return success response with user object
        else {
            return Response.success(user);
        }
    }
}













//package com.train.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.train.Entity.Role;
//import com.train.Entity.User;
//import com.train.dtos.CredentialsDTO;
//import com.train.services.UserServiceImpl;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//public class LoginControllerImpl {
//
//	@Autowired
//	private UserServiceImpl userService;
//
//	@PostMapping("/user/login")
//	public ResponseEntity<?> signInUser(@RequestBody CredentialsDTO cred) {
//		User user = userService.findUserByEmailAndPassword(cred.getEmail(), cred.getPassword());
//		if (user == null) {
//			return Response.error("User not found");
//		} else if (user.getRole() != Role.USER) {
//			return Response.error("User not allowed to sign in");
//		} else {
//			return Response.success(user);
//		}
//	}
//
//	@PostMapping("/admin/login")
//	public ResponseEntity<?> signInAdmin(@RequestBody CredentialsDTO cred) {
//		User user = userService.findUserByEmailAndPassword(cred.getEmail(), cred.getPassword());
//
//		if (user != null && user.getRole() == Role.ADMIN) {
//			return Response.success(user);
//		} else {
//			return Response.error("Admin not found");
//		}
//	}
//}















//	@GetMapping( "/admin/login")
//	public ModelAndView login(Model model, Locale locale) {
//		System.out.println("Current Locale: " + locale);
//		CredentialsDTO cred = new CredentialsDTO("", "");
//		model.addAttribute("command", cred); // command obj or modelAttribute 
//		return new ModelAndView("login", "cred", cred);
//	}
//	
//	@PostMapping("/admin/login")
//	public String validate( @ModelAttribute("command") CredentialsDTO cred,Model model,HttpSession session) {
//		
//		Admin admin = adminService.findAdminByEmailAndPassword(cred.getEmail(), cred.getPassword());
//		if(admin == null)
//			return "failed";
//		session.setAttribute("admin", admin);
//		return "redirect:/trainlist";	
//	}

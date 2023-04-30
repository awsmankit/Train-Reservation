package com.train.services;

import java.util.List;
import java.util.Optional; //importing the Optional class

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.train.Entity.Passenger;
import com.train.Entity.User;
import com.train.dao.PassengerDao;
import com.train.dao.UserDao;
import com.train.dtos.UserDTO;

@Transactional
@Service
public class UserServiceImpl {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PassengerDao passengerDao;

	//find user by email
	public User findUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

	//find user by id
	public User findUserById(int id) {
		User user = userDao.findById(id);
		return user;
	}

	//save a user
	public User saveUser(User user) {
		return userDao.save(user);
	}

	//add a new passenger
	public Passenger AddPassenger(Passenger psgr) {
		return passengerDao.save(psgr);
	}

	//delete a user by id
	public int DeleteUser(int id) {
		if (userDao.existsById(id)) {
			userDao.deleteById(id);
			return 1;
		} else
			return 0;
	}

	//find all users
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	//find a user by email and password
	public User findUserByEmailAndPassword(String email, String password) {
		User user = userDao.findByEmail(email);
		if (user != null && password.equals(user.getPassword()))
			return user;
		return null;
	}

	//update a user by id by using optional class 
	public User updateUser(int id, UserDTO update) {
	    User user = userDao.findById(id);

	    Optional.ofNullable(update.getFirstName()).ifPresent(user::setFirstName);

	    Optional.ofNullable(update.getLastName()).ifPresent(user::setLastName);

	    Optional.ofNullable(update.getEmail()).ifPresent(user::setEmail);

	    Optional.ofNullable(update.getAddress()).ifPresent(user::setAddress);

	    Optional.ofNullable(update.getPhone()).ifPresent(user::setPhone);

	    User updatedUser = userDao.save(user);
	    return updatedUser;
	}
	
	// without optional class 
	
//	public User UpdateUser(int id, UserDTO update) {
//		User user = userDao.findById(id);
//
//		if (update.getFirstName() != null) {
//			user.setFirstName(update.getFirstName());
//		}
//
//		if (update.getLastName() != null) {
//			user.setLastName(update.getLastName());
//		}
//
//		if (update.getEmail() != null) {
//			user.setEmail(update.getEmail());
//		}
//
//		if (update.getAddress() == null) {
//			user.setAddress(update.getAddress());
//		}
//
//		if (update.getPhone() != null) {
//			user.setPhone(update.getPhone());
//		}
//
//		User updatedUser = userDao.save(user);
//		return updatedUser;
//
//	}

	//change password of a user
	public User ChangePassword(int id, UserDTO usr) {
		User user = userDao.findById(id);
		if (user != null) {
			user.setPassword(usr.getPassword());
			User ChangePass = userDao.save(user);
			return ChangePass;
		} else
			return null;
	}

}

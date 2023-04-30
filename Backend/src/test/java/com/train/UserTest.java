package com.train;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.train.dao.PassengerDao;
import com.train.services.UserServiceImpl;



@SpringBootTest
public class UserTest {

	@Autowired
	UserServiceImpl userservice;
	
	@Autowired
	PassengerDao passengerDao;
	
	@Test   //working
	void testfindByTicketNo() {
		Object pas= passengerDao.findByTicketNo(2);
		System.out.println(pas);
	}
}
	
	
	
//	@Test   //working
//	void testFindUserByEmail() {
//		User user=userDao.findByEmail("r@gmail.com");
//		System.out.println(user);
//	}
//	
//	@Test           //working
//	void testlogin()
//	{
//		User user =userservice.findUserByEmailAndPassword("r@gmail.com", "1234");
//		System.out.println(user);
//	}	
//	
//	@Test     //working
//	void testUserBYId() {
//		User user=userservice.findUserById(1);
//		System.out.println(user);
//	}
//	
//	@Test   //working
//	void testFindAll() {
//		List<User> list = userservice.findAllUsers();
//		list.forEach(System.out::println);
//		//assertThat(list).isNotEmpty();
//	}
//	
//	
//	@Test   //working
//	void testFindAllPass() {
//		List<Passenger> list = passengerDao.findAll();
//		list.forEach(System.out::println);
//	
//	}
	
	

package com.train;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.train.Entity.User;
import com.train.dao.UserDao;
import com.train.services.AdminServiceImpl;

@SpringBootTest
public class AdminTest {

	

	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private UserDao userDao;
	
	@Test
	void testadminbyemail() {
	User admin=userDao.findAdminByEmail("y@gmail.com");
		System.out.println("Admin="+admin);
		//assertThat(list).isNotEmpty();
	}
	
	@Test
	void testFindAll() {
		List<User> list = userDao.findAll();
		list.forEach(System.out::println);
		//assertThat(list).isNotEmpty();
	}
	
	
	
	@Test
	void testauthenticateadmin() {
	User admin=adminService.findAdminByEmailAndPassword("y@gmail.com", "1234");
		System.out.println("Admin="+admin);
		//assertThat(list).isNotEmpty();
	}
}

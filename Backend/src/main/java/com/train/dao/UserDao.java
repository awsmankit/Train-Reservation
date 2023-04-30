package com.train.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.train.Entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findById(int id);

	User findByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.email = ?1 AND u.role = 'ADMIN'")
	User findAdminByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.role = 'ADMIN'")
	List<User> findByRole(String string);

}

// User findUserById(int id);

//	@Query("select u.Email from User u WHERE u.FirstName=:n")
//	public User getUserByName(@Param("n") String name);
//	
//	@Query("SELECT u from User u WHERE u.email = ?1)
//	User findUserByEmail(String EMAIL);

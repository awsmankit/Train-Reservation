package com.train.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.train.Entity.Passenger;

@Repository
public interface  PassengerDao extends JpaRepository<Passenger, Integer>{

	//@Query(value = "select t.TicketNo, u.UserId  from Ticket t inner join User u ON t.UserId=u.UserId where u.FirstName=?1 ",nativeQuery = true)
	@Query(value= "select p.Name from Ticket t inner join Passenger p ON t.PassengerId=p.PassengerId WHERE t.TicketNo=?1", nativeQuery = true)
	public Object findByTicketNo(int id);
}

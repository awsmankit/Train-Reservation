package com.train;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.train.Entity.Ticket;
import com.train.dao.TicketDao;

@SpringBootTest
public class TicketTesting {
  
	@Autowired
	private TicketDao ticketDao;
	
	@Test   //working
	void testFindticketByUserid() {
		List<Ticket> tickets=ticketDao.findByUserId(1);
		tickets.forEach(System.out::println);
		//assertThat(list).isNotEmpty();
	}
	
	@Test   //working
	void testFindAlltickets() {
		List<Ticket> tickets=ticketDao.findAll();
		tickets.forEach(System.out::println);
		//assertThat(list).isNotEmpty();
	}
	
	@Test  //working
	void testFindticketByNo() {
		Ticket tickets=ticketDao.findTicketByNo(2);
		System.out.println("Ticket="+tickets);
		//assertThat(list).isNotEmpty();
	}
	
	@Test      //working
	void testFindticketByUserName() {
		List<Object []> tickets=ticketDao.findTicketByUserName("rohit");
		for(int i=0; i< tickets.size();i++)
		{
			Object[] obj = tickets.get(i);
			// System.out.println(obj.toString());
			 for(int j=0; j<obj.length; j++) {
				 System.out.print(obj[j]+"  ");
		}
		System.out.println();
		}
	}
	
//	@Test
//	void testTicketDetails() {
//		Object[] ticket=ticketDao.findTicketDetails(2);
//		for(int i=0; i< ticket.length;i++)
//		{
//			Object[] obj = ticket.length;
//			// System.out.println(obj.toString());
//			 for(int j=0; j<obj.length; j++) {
//				 System.out.print(obj[j]+"  ");
//		}
//		System.out.println();
//		
//	}
		
	
	//}
}

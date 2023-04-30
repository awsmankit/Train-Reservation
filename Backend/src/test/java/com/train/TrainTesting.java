package com.train;

import java.sql.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.train.dao.CalenderDao;

@SpringBootTest
public class TrainTesting {

	@Autowired
	private  CalenderDao calenderDao;
	
	
	 

	
//	@Test  //working
//	void testFindAllCal() {
//		List<Calender> list =calenderDao.findAll();
//		list.forEach(System.out::println);
//		//assertThat(list).isNotEmpty();
//	}
//	
//	
//	@Test  //working
//	void testFindAll() {
//		List<Train> list = trainDao.findAll();
//		list.forEach(System.out::println);
//		//assertThat(list).isNotEmpty();
//	}
//
//	
//	@Test  //working
//	void testfindbyno() {
//		Train train=trainDao.findTrainByNo(100);
//		System.out.println("source="+train);
//	}

//	@Test   //working
//	void testfindTrainDate() {
//		List<Object[]> train= trainDao.findTrainByDate(Date.valueOf("2020-02-10"));
//		for(int j=0; j<train.size(); j++) {
//		Object[] obj = train.get(j);
//		
//		for(int i=0; i<obj.length; i++) {
//		System.out.print(obj[i] +"  ");
//		}
//		System.out.println();
//	}
//	}
	
	@Test
	void testcountavilableseat() {
		System.out.println(calenderDao.getAvailableseats(101, Date.valueOf("2022-05-10")));
	}
	
}

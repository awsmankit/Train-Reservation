package com.train.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.train.Entity.Calender;

public interface CalenderDao extends JpaRepository<Calender, Date>{

	public Calender findByTrainNo(int no);
	
	public void deleteCalenderByTrainNo(int no);
	
	@Query(value="insert into calendar values (?1,?2,default)" , nativeQuery = true)
	public Calender AddTrainCalender( Date trainDate,int trainNo);
	
	@Modifying
	@Query(value="update calender set AvailableSeats=?1 where trainNo=?2 and traindate=?3",nativeQuery =true )
	public int UpdateAvailableSeats(int seats, int trainNo, Date trainDate);
	
	@Query(value="SELECT AvailableSeats FROM calendar WHERE TrainNo=?1 AND traindate=?2 ",nativeQuery = true)
	int getAvailableseats(int trainNO, Date date);
}

//
//package com.train.dao;
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.time.format.TextStyle;
//import java.util.Date;
//import java.util.Locale;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//
//import com.train.Entity.Calender;
//
//public interface CalenderDao extends JpaRepository<Calender, Date>{
//
//    public Calender findByTrainNo(int no);
//
//    public void deleteCalenderByTrainNo(int no);
//
//    @Query(value="insert into calender values (?1,?2,?3,default)" , nativeQuery = true)
//    public Calender AddTrainCalender(Date trainDate, int trainNo, String DayOfWeek);
//
//    @Modifying
//    @Query(value="update calender set AvailableSeats=?1 where trainNo=?2 and traindate=?3 and DayOfWeek=?4",nativeQuery =true )
//    public int UpdateAvailableSeats(int seats, int trainNo, Date trainDate, String DayOfWeek);
//
//    @Query(value="SELECT AvailableSeats FROM calender WHERE TrainNo=?1 AND traindate=?2 and DayOfWeek=?3",nativeQuery = true)
//    int getAvailableseats(int trainNO, Date date, String dayOfWeek);
//    
//    default String getDayOfWeekFromDate(Date date) {
//        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
//        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US);
//    }
//}

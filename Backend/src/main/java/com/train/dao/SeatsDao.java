package com.train.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.train.Entity.Seats;

public interface SeatsDao extends JpaRepository<Seats, Integer> {

//	@Query(value="UPDATE Seats SET SeatStatus=?2  where PassengerId=?1;",nativeQuery = true)
//	public Seats CancelSeat(int Tno, String status);

	public Seats findSeatBySeatNo(int id);

	public Seats findSeatByPassengerId(int id);

	@Modifying
	@Query(value = "UPDATE Seats SET SeatStatus=?1 , PassengerId=?2 where PassengerId=?3")
	public void UpdateCancelSeat(String status, int UpdatePid, int Pid);

	// SeatNo | SeatStatus | PassengerId | TrainNo
	@Modifying
	@Query(value = "insert into seats values (?1,?2,?3,?4,?5)", nativeQuery = true)
	public void AddAvailabeSeat(String SeatStatus, int PassengerId, int SeatNo, int TrainNo, Date trainDate);

	@Query(value = "select * from seats where TrainNo=?1 and TrainDate=?2 and SeatStatus='cancel'", nativeQuery = true)
	public List<Seats> seatsByDateTrainNo(int trainNo, Date date);

	@Modifying
	@Query(value = "UPDATE Seats SET  SeatStatus=?1 where seatNo=?2 and trainNo=?3 and trainDate=?4")
	public void cancelSeat2(String status, int seatNo, int trainNo, Date date);

	@Query(value = "SELECT COUNT(SeatNo) FROM seats WHERE TrainNo=?1 AND TrainDate=?2 and SeatStatus='sucess'", nativeQuery = true)
	int getCount(int trainNO, Date date);

	@Query(value = "SELECT COUNT(SeatNo) FROM seats WHERE TrainNo=?1 AND TrainDate=?2 ", nativeQuery = true)
	int getCountwithoutStatus(int trainNO, Date date);

	@Query(value = "SELECT COUNT(SeatNo) FROM seats WHERE TrainNo=?1 AND TrainDate=?2 and SeatStatus='cancel'", nativeQuery = true)
	int getCountforCancel(int trainNO, Date date);

}
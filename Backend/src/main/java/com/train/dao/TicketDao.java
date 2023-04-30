package com.train.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.train.Entity.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

//	@Query("SELECT t from Ticket t WHERE t.user.userId = ?1  ")
//	ArrayList<Ticket> findTicketsByUserId(int ID);

	public Ticket findByNo(int no);

	public Ticket findTicketByNo(int id);

	public Ticket findTicketByPassengerId(int id);

	void deleteTicketByTrainNo(int no);

	public List<Ticket> findByUserId(int id);

	@Query(value = "select t.TicketNo, u.UserId ,u.FirstName from Ticket t inner join User u ON t.UserId=u.UserId where u.FirstName=?1 ", nativeQuery = true)
	public List<Object[]> findTicketByUserName(String name);

	// TicketNo, Date ,Time,Route, TrainNo, PassName ,prise, status,seatNo
	@Query(value = "   select t.TicketNo , t.TrainDate , tr.ArrivalTime , tr.DepartureTime ,tr.Source , tr.Destination ,tr.Fair,s.SeatNo, p.Name ,t.PaymentStatus,tr.trainNo,p.PassengerId FROM\r\n"
			+ "			Ticket t left join Train tr ON t.TrainNo=tr.TrainNo \r\n"
			+ "		   left join Passenger p  ON t.PassengerId=p.PassengerId\r\n"
			+ "		left join	Seats s   ON s.PassengerId=p.PassengerId\r\n"
			+ "			WHERE t.TicketNo=?1  ;", nativeQuery = true)
	public Object[] findTicketDetails(int id);

	@Query(value = "UPDATE Ticket SET PaymentStatus=?2  where PassengerId=?1;", nativeQuery = true)
	public Ticket CancelTicket(int Tno, String status);

	@Query(value = "   select t.TicketNo , t.TrainDate , tr.ArrivalTime , tr.DepartureTime ,tr.Source , tr.Destination ,tr.Fare,s.SeatNo, p.Name ,t.PaymentStatus,tr.trainNo,p.PassengerId FROM\r\n"
			+ "			Ticket t left join Train tr ON t.TrainNo=tr.TrainNo \r\n"
			+ "		   left join Passenger p  ON t.PassengerId=p.PassengerId\r\n"

			+ "		left join	Seats s   ON s.PassengerId=p.PassengerId\r\n"
			+ "		 WHERE t.traindate <= CURRENT_DATE  AND t.UserId=?1", nativeQuery = true)
	public List<Object[]> findPastTicketDetails(int id);

	@Query(value = "   select t.TicketNo , t.TrainDate , tr.ArrivalTime , tr.DepartureTime ,tr.Source , tr.Destination ,tr.Fare,s.SeatNo, p.Name ,t.PaymentStatus,tr.trainNo,p.PassengerId FROM\r\n"
			+ "			Ticket t left join Train tr ON t.TrainNo=tr.TrainNo \r\n"
			+ "		   left join Passenger p  ON t.PassengerId=p.PassengerId\r\n"

			+ "		left join	Seats s   ON s.PassengerId=p.PassengerId\r\n"
			+ "		 WHERE t.traindate >= CURRENT_DATE  AND t.UserId=?1", nativeQuery = true)
	public List<Object[]> findUpcomingTicketDetails(int id);

	@Query(value = "   select t.TicketNo , t.TrainDate , tr.ArrivalTime , tr.DepartureTime ,tr.Source , tr.Destination ,tr.Fair,s.SeatNo, p.Name ,t.PaymentStatus,tr.trainNo,p.PassengerId FROM\r\n"
			+ "			Ticket t left join Train tr ON t.TrainNo=tr.TrainNo \r\n"
			+ "		   left join Passenger p  ON t.PassengerId=p.PassengerId\r\n"

			+ "		left join	Seats s   ON s.PassengerId=p.PassengerId\r\n"
			+ "		 WHERE t.UserId=?1", nativeQuery = true)
	public List<Object[]> findAllTicketDetails(int id);

	@Modifying
	@Query(value = "Update Ticket set UserId=?1 ,PassengerId=?2, PaymentStatus=?3 where PassengerId=?4")
	public void UpdateCancelTicket(int uid, int Updated_pid, String status, int pid);

	// TicketNo | TrainNo | UserId | BookDate | PassengerId | PaymentStatus
	@Modifying
	@Query(value = "INSERT into Ticket values (default,?1,?2,CURRENT_DATE,?3,?4,?5)", nativeQuery = true)
	public void BookAvailableTicket(int TrainNo, int UId, int PId, String PaymentStatus, Date trainDate);

}

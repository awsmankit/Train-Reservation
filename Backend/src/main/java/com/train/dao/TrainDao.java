package com.train.dao;

import java.util.Date;
//import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.train.Entity.Train;

public interface TrainDao extends JpaRepository<Train, Integer> {

	@Query(value = "SELECT * from train where TrainNo=?1", nativeQuery = true)
	List<Train> findTrainBytrainNo(int no);

	Train findTrainByNo(int no);

	@Query(value="delete from train WHERE TrainNo=?1", nativeQuery = true)
	void deleteTrainByNo(int no);

//	@Query(value="SELECT t.source from Train t WHERE t.TrainNo=?1",nativeQuery = true)
//	Train findtrainByNo(int no);

	@Query(value = "SELECT t.TrainNo , t.TrainName  ,c.TrainDate from train t inner join calendar c ON t.TrainNo=c.TrainNo where c.TrainDate=?1 ", nativeQuery = true)
	List<Object[]> findTrainByDate(Date date);

	// TrainNo | TrainName | Source | ArrivalTime | Destination | DepartureTime |
	// TotalSeats | Fair

	@Query(value = "  SELECT t.TrainNo, t.TrainName, t.Source, t.ArrivalTime,t.Destination,t.DepartureTime, t.TotalSeats, t.Fair, c.AvailableSeats\r\n"
			+ "      From Train  t inner join Calender c ON t.TrainNo=c.TrainNo"
			+ "       WHERE t.Source=?1 AND t.Destination=?2 AND c.TrainDate=?3 ", nativeQuery = true)
	List<Object[]> SearchTrain(String source, String Destination, Date date);

	@Query("SELECT DISTINCT t.source FROM Train t")
	List<String> findDistinctSources();

	@Query("SELECT DISTINCT t.destination FROM Train t")
	List<String> findDistinctDestinations();

	List<Train> findBySourceAndDestination(String source, String destination);
}

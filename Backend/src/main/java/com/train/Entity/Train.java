package com.train.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "train")
public class Train {

	@Id
	@Column(name = "TrainNo")
	private int no;
	@Column(name = "TrainName")
	private String trainName;
	@Column(name = "Source")
	private String source;
	@Column(name = "ArrivalTime")
	private String arrivalTime;
	@Column(name = "Destination")
	private String destination;
	@Column(name = "DepartureTime")
	private String departureTime;
	@Column(name = "TotalSeats")
	private int totalSeats;
	@Column(name = "Fair")
	private double fair;

	@OneToMany(mappedBy = "train")
	private List<Ticket> tickets;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "train_calender_map", joinColumns = @JoinColumn(name = "train_no", referencedColumnName = "TrainNo"), inverseJoinColumns = @JoinColumn(name = "sr_no", referencedColumnName = "srno"))
	private List<Calender> dateList;

	public Train() {
		super();
	}

//	public List<Ticket> getTickets() {
//		return tickets;
//	}
//
//	public void setTickets(List<Ticket> tickets) {
//		this.tickets = tickets;
//	}
//
//	public List<Calender> getDateList() {
//		return dateList;
//	}
//
//	public void setDateList(List<Calender> dateList) {
////		this.dateList = dateList;
//	}

	public Train(int no, String trainName, String source, String arrivalTime, String destination, String departureTime,
			int totalSeats, double fair) {
		super();
		this.no = no;
		this.trainName = trainName;
		this.source = source;
		this.arrivalTime = arrivalTime;
		this.destination = destination;
		this.departureTime = departureTime;
		this.totalSeats = totalSeats;
		this.fair = fair;
		this.tickets = new ArrayList<Ticket>();
		this.dateList = new ArrayList<Calender>();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public double getFair() {
		return fair;
	}

	public void setFair(double fair) {
		this.fair = fair;
	}

	@Override
	public String toString() {
		return "Train [no=" + no + ", trainName=" + trainName + ", source=" + source + ", arrivalTime=" + arrivalTime
				+ ", destination=" + destination + ", departureTime=" + departureTime + ", totalSeats=" + totalSeats
				+ ", fair=" + fair + "]";
	}

}

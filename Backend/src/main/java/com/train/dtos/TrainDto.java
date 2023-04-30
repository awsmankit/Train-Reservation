package com.train.dtos;

public class TrainDto {

	private int no;
	private String trainName;
	private String source;
	private String arrivalTime;
	private String destination;
	private String departureTime;
	private int totalSeats;
	private double fair;

	public TrainDto(int no, String trainName, String source, String arrivalTime, String destination,
			String departureTime, int totalSeats, double fair) {
		super();
		this.no = no;
		this.trainName = trainName;
		this.source = source;
		this.arrivalTime = arrivalTime;
		this.destination = destination;
		this.departureTime = departureTime;
		this.totalSeats = totalSeats;
		this.fair = fair;
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
		return "TrainDto [no=" + no + ", trainName=" + trainName + ", source=" + source + ", arrivalTime=" + arrivalTime
				+ ", destination=" + destination + ", departureTime=" + departureTime + ", totalSeats=" + totalSeats
				+ ", fair=" + fair + "]";
	}

}

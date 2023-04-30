package com.train.dtos;

import java.util.Date;


public class CalenderDTO {

	
	private Date trainDate ;
	
	public CalenderDTO() {
		// TODO Auto-generated constructor stub
	}

	
	public CalenderDTO(Date trainDate) {
		super();
		this.trainDate = trainDate;
	}

	public Date getTrainDate() {
		return trainDate;
	}

	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}

	@Override
	public String toString() {
		return "CalenderDTO [trainDate=" + trainDate + "]";
	}
	
	
}

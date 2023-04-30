package com.train.dtos;

import java.sql.Date;

public class CancelTicketDto {

	// {sno}/{status}/{TrainNO}/{trainDate}
	private int sno;
	private String status;
	private int TrainNO;
	private Date trainDate;
	private int passengerId;

	public CancelTicketDto() {
		// TODO Auto-generated constructor stub
	}

	public CancelTicketDto(int sno, String status, int trainNO, Date trainDate, int passengerId) {
		super();
		this.sno = sno;
		this.status = status;
		TrainNO = trainNO;
		this.trainDate = trainDate;
		this.passengerId = passengerId;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTrainNO() {
		return TrainNO;
	}

	public void setTrainNO(int trainNO) {
		TrainNO = trainNO;
	}

	public Date getTrainDate() {
		return trainDate;
	}

	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	@Override
	public String toString() {
		return "CancelTicketDto [sno=" + sno + ", status=" + status + ", TrainNO=" + TrainNO + ", trainDate="
				+ trainDate + ", passengerId=" + passengerId + "]";
	}

}

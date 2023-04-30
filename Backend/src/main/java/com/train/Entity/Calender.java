package com.train.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "calender")
public class Calender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srno;

	@Column(name = "TrainDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date trainDate;

	@Column(name = "TrainNo")
	private int trainNo;

	@ManyToMany(mappedBy = "dateList", fetch = FetchType.EAGER)
	private List<Train> trains;

	public Calender() {
		// TODO Auto-generated constructor stub
	}

	public Calender(int srno, Date trainDate, int trainNo) {
		super();
		this.srno = srno;
		this.trainDate = trainDate;
		this.trainNo = trainNo;
	}

	public int getSrno() {
		return srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
	}

	public Date getTrainDate() {
		return trainDate;
	}

	public void setTrainDate(Date trainDate) {
		this.trainDate = trainDate;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	@Override
	public String toString() {
		return "Calender [srno=" + srno + ", trainDate=" + trainDate + ", trainNo=" + trainNo + "]";
	}

}

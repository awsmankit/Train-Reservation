package com.train.Entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seats")
@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class Seats {

    @Id
    @Column(name = "SeatNo")
    private int seatNo;

    @Column(name = "TrainNo")
    private int trainNo;

    @Column(name = "SeatStatus")
    private String seatStatus;

    @Column(name = "PassengerId")
    private int passengerId;

    @Column(name = "TrainDate")
    private Date trainDate;

    @OneToOne
    @JoinColumn(name = "passengerId", referencedColumnName = "PassengerId")
    private Passenger passenger;

}

//package com.train.Entity;
//
//import java.io.Serializable;
//import java.sql.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "seats")
//public class Seats implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name = "SeatNo")
//	private int seatNo;
//
//	@Column(name = "TrainNo")
//	private int trainNo;
//
//	@Column(name = "SeatStatus")
//	private String seatStatus;
//
//	@Column(name = "PassengerId")
//	private int passengerId;
//
//	@Column(name = "TrainDate")
//	private Date trainDate;
//
//	@OneToOne()
//	@JoinColumn(name = "passengerId", referencedColumnName = "PassengerId")
//	private Passenger passenger;
//
//	public Seats() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Seats(int seatNo, int trainNo, String seatStatus, int passengerId) {
//		super();
//		this.seatNo = seatNo;
//		this.trainNo = trainNo;
//		this.seatStatus = seatStatus;
//		this.passengerId = passengerId;
//
//	}
//
//	public int getSeatNo() {
//		return seatNo;
//	}
//
//	public void setSeatNo(int seatNo) {
//		this.seatNo = seatNo;
//	}
//
//	public int getTrainNo() {
//		return trainNo;
//	}
//
//	public void setTrainNo(int trainNo) {
//		this.trainNo = trainNo;
//	}
//
//	public String getSeatStatus() {
//		return seatStatus;
//	}
//
//	public void setSeatStatus(String seatStatus) {
//		this.seatStatus = seatStatus;
//	}
//
//	public int getPassengerId() {
//		return passengerId;
//	}
//
//	public void setPassengerId(int passengerId) {
//		this.passengerId = passengerId;
//	}
//
//	public Passenger getPassenger() {
//		return passenger;
//	}
//
//	public void setPassenger(Passenger passenger) {
//		this.passenger = passenger;
//	}
//
//	@Override
//	public String toString() {
//		return "Seats [seatNo=" + seatNo + ", trainNo=" + trainNo + ", seatStatus=" + seatStatus + ", passengerId="
//				+ passengerId + ", passenger=" + passenger + "]";
//	}
//
//}

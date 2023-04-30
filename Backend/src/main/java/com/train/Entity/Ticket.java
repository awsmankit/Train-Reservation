package com.train.Entity;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketNo")
    private int no;

    @Column(name = "TrainNo")
    private int trainNo;

    @Column(name = "UserId")
    private int userId;

    @Column(name = "BookDate")
    private Date bookDate;

    @Column(name = "PassengerId")
    private int passengerId;

    @Column(name = "TrainDate")
    private Date trainDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "UserId", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainNo", insertable = false, updatable = false)
    private Train train;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "passengerId", insertable = false, updatable = false)
    private Passenger passenger;

    public void setPaymentStatus(String status) {
        // TODO Auto-generated method stub
    }

}


//package com.train.Entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "ticket")
//public class Ticket {
//
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id
//	@Column(name = "TicketNo")
//	private int no;
//
//	@Column(name = "TrainNo")
//	private int trainNo;
//
//	@Column(name = "UserId")
//	private int userId;
//
//	@Column(name = "BookDate")
//	private Date bookDate;
//
//	@Column(name = "PassengerId")
//	private int passengerId;
//
//	@Column(name = "TrainDate")
//	private Date trainDate;
//
//	@ManyToOne()
//	@JoinColumn(name = "userId", referencedColumnName = "UserId")
//	private User user;
//
//	@ManyToOne()
//	@JoinColumn(name = "trainNo")
//	private Train train;
//
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "passengerId")
//	private Passenger passenger;
//
//	public Ticket() {
//
//	}
//
//	public Ticket(int no, int userId) {
//		super();
//		this.no = no;
//		this.userId = userId;
//	}
//
//	public Date getTrainDate() {
//		return trainDate;
//	}
//
//	public void setTrainDate(Date trainDate) {
//		this.trainDate = trainDate;
//	}
//
//	public Ticket(int no, int trainNo, int userId, Date bookDate, int passengerId, Date trainDate, User user,
//			Train train, Passenger passenger) {
//		super();
//		this.no = no;
//		this.trainNo = trainNo;
//		this.userId = userId;
//		this.bookDate = bookDate;
//		this.passengerId = passengerId;
//		this.trainDate = trainDate;
//		this.user = user;
//		this.train = train;
//		this.passenger = passenger;
//	}
//
//	public int getNo() {
//		return no;
//	}
//
//	public void setNo(int no) {
//		this.no = no;
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
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public Date getBookDate() {
//		return bookDate;
//	}
//
//	public void setBookDate(Date bookDate) {
//		this.bookDate = bookDate;
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
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Train getTrain() {
//		return train;
//	}
//
//	public void setTrain(Train train) {
//		this.train = train;
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
//		return "Ticket [no=" + no + ", trainNo=" + trainNo + ", userId=" + userId + ", bookDate=" + bookDate
//				+ ", passengerId=" + passengerId + ", trainDate=" + trainDate + ", user=" + user + ", train=" + train
//				+ ", passenger=" + passenger + "]";
//	}
//
//	public void setPaymentStatus(String status) {
//		// TODO Auto-generated method stub
//
//	}
//
//}

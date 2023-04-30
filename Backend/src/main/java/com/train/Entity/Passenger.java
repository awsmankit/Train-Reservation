package com.train.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column (name="PassengerId")
	private int id;
	@Column (name="Name")
	private String name;
	@Column (name="Age")
	private int age;
	@Column (name="Gender")
	private String gender;
	@Column (name="Region")
	private String region;
	@Column (name="PhoneNo")
	private String phoneNo;
	
	@OneToOne(mappedBy = "passenger")
	private Ticket ticket;
	
	@OneToOne(mappedBy = "passenger" )
	private Seats seat;
	

	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(int id, String name, int age, String gender, String region, String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.region = region;
		this.phoneNo = phoneNo;
		//this.ticket=new Ticket();
	}

	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Seats getSeat() {
		return seat;
	}

	public void setSeat(Seats seat) {
		this.seat = seat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", region=" + region
				+ ", phoneNo=" + phoneNo + "]";
	}

	

	
}

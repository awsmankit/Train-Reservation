package com.train.dtos;

public class PassengerDTO {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String region;
	private String phoneNo;
	
	public PassengerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PassengerDTO(int id, String name, int age, String gender, String region, String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.region = region;
		this.phoneNo = phoneNo;
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
		return "PassengerDTO [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", region="
				+ region + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
}

package com.train.dtos;

import java.sql.Date;

public class SearchtrainDto {

	private String source ;
	
	private String destination;
	
	private Date date;

	public SearchtrainDto(String source, String destination, Date date) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SearchtrainDto [source=" + source + ", destination=" + destination + ", date=" + date + "]";
	}
	
	
	
}

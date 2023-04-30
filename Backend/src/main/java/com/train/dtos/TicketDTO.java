package com.train.dtos;

public class TicketDTO {

	private int TicketNo ;
	
	private int UserId;
	
	public TicketDTO() {
		// TODO Auto-generated constructor stub
	}

	public TicketDTO(int ticketNo, int userId) {
		super();
		TicketNo = ticketNo;
		UserId = userId;
	}

	public int getTicketNo() {
		return TicketNo;
	}

	public void setTicketNo(int ticketNo) {
		TicketNo = ticketNo;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	@Override
	public String toString() {
		return "TicketDTO [TicketNo=" + TicketNo + ", UserId=" + UserId + "]";
	}
	
}

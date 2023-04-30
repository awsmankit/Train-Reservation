package com.train.dtos;

import org.springframework.stereotype.Component;

import com.train.Entity.Calender;
import com.train.Entity.Ticket;

@Component
public class DtoToEntityConverter {

	public Calender toCalenderEntity(CalenderDTO dto) {
		Calender cal = new Calender();
		cal.setTrainDate(dto.getTrainDate());
		return cal;
	}

	public CalenderDTO toCalenderDto(Calender ent) {
		CalenderDTO calDto = new CalenderDTO();
		calDto.setTrainDate(ent.getTrainDate());
		return calDto;
	}

	public Ticket toticketEntity(TicketDTO dto) {
		Ticket tic = new Ticket();
		tic.setNo(dto.getTicketNo());
		tic.setUserId(dto.getUserId());
		return tic;

	}

	public TicketDTO toticketDto(Ticket tic) {
		TicketDTO tdto = new TicketDTO();
		tdto.setTicketNo(tic.getNo());
		tdto.setUserId(tic.getUserId());
		return tdto;

	}
}

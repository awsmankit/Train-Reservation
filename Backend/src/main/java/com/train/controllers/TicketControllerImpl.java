package com.train.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.dao.SeatsDao;
import com.train.services.SeatServiceImpl;
import com.train.services.TicketService;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/ticket")
@RestController
public class TicketControllerImpl {

    private TicketService ticketService;

    private SeatServiceImpl seatService;

    @Autowired
    public TicketControllerImpl(TicketService ticketService, SeatServiceImpl seatService, SeatsDao seatdao) {
        // Constructor to set the TicketService and SeatServiceImpl
        this.ticketService = ticketService;
        this.seatService = seatService;
    }

    // Endpoint to get ticket details by ticketNo
    @GetMapping("/details/{ticketNo}")
    public ResponseEntity<?> findTicketDetails(@PathVariable("ticketNo") int id) {
        Object[] ticket = ticketService.findTicketDetails(id);
        if (ticket != null) {
            return Response.success(ticket);
        }
        return Response.error("ticket not found");
    }

    // Endpoint to get past ticket details for a user
    @GetMapping("/past/{userid}")
    public ResponseEntity<?> findPastTicketDetailsUser(@PathVariable("userid") int id) {
        List<Object[]> ticket = ticketService.findPastTicketDetails(id);
        return Response.success(ticket);

    }

    // Endpoint to get upcoming ticket details for a user
    @GetMapping("/upcoming/{userid}")
    public ResponseEntity<?> findUpcomingTicketDetailsUser(@PathVariable("userid") int id) {
        List<Object[]> ticket = ticketService.findUpcomingTicketDetails(id);
        return Response.success(ticket);

    }

    // Endpoint to get all ticket details for a user
    @GetMapping("/all/{userid}")
    public ResponseEntity<?> findAllTicketDetailsUser(@PathVariable("userid") int id) {
        List<Object[]> ticket = ticketService.findAllTicketDetails(id);
        return Response.success(ticket);

    }

    // Endpoint to cancel a ticket
    @PutMapping("/cancelTicket/{sno}/{status}/{TrainNO}/{trainDate}/{pId}")
    public ResponseEntity<?> CancelTicket(@PathVariable("sno") int sno, @PathVariable("status") String status,
            @PathVariable("TrainNO") int TrainNO, @PathVariable("trainDate") Date trainDate,
            @PathVariable("pId") int pId) {

        // Call the CancelSeat2 method of the SeatServiceImpl class to update the seat status
        seatService.CancelSeat2(status, sno, TrainNO, trainDate);

        // Call the cancelTicket method of the TicketService class to cancel the ticket
        ticketService.cancelTicket(pId, status);

        // Return success response
        return Response.success("status changed");
    }
}


//	@PutMapping("/cancelTicket")
//	public ResponseEntity<?> CancelTicket(@RequestBody CancelTicketDto dto)
//	{
//		
//			
//		ticketService.cancelTicket(dto.getPassengerId(), dto.getStatus());
//		seatService.CancelSeat2(dto.getStatus(), dto.getSno(), dto.getTrainNO(), dto.getTrainDate());
//			
//		return ResponseEntity.ok("ststus changed");
//		
//		
//	}

//	@PutMapping("/cancelTicket/{pno}/{status}")
//	public ResponseEntity<?> CancelTicket(@PathVariable("pno") int no, @PathVariable("status") String status)
//	{
//		Ticket ticket= ticketService.FindTicketByPassId(no);
//		if(ticket.getPassengerId()==no)
//		{
//	
//			ticketService.cancelTicket(no, status);
//			seatService.cancelSeat(no, status);
//			return ResponseEntity.ok("ststus changed");
//		}
//		else 
//			return ResponseEntity.ok("ticket not found");
//		
//	}

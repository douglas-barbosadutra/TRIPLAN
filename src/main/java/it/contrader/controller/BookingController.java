package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.BookingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.BookingService;

@CrossOrigin
@RestController
@RequestMapping("/Booking")
public class BookingController {

	private final BookingService bookingService;

	@Autowired
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	@RequestMapping(value="/showBooking" , method= RequestMethod.GET)
	public List<BookingDTO> showBooking() {		
		return bookingService.getAllBooking();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void delete(@RequestParam(value = "idBooking") int id) {
		this.bookingService.deleteBookingById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public void update(@RequestBody BookingDTO booking) {
		bookingService.updateBooking(booking);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert(@RequestBody BookingDTO booking) {
		bookingService.insertBooking(booking);
	}
}


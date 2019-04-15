package it.contrader.controller;

import java.util.List;

import it.contrader.dto.BookingDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Booking;
import it.contrader.service.BookingService;

public class BookingController implements Controller {

    private static String sub_package = "booking.";
	private BookingService bookingService;
	

	public BookingController() {
		this.bookingService = new BookingService();
	}

	public List<Booking> getAllBooking() {
		return this.bookingService.getAllBooking();
	}

	public BookingDTO readBooking(int idbooking) {
		return this.bookingService.readBooking(idbooking);
	}

	public boolean insertBooking(BookingDTO bookingDTO) {
		return this.bookingService.insertBooking(bookingDTO);
	}
	
	public boolean updateBooking(BookingDTO bookingDTO) {
		return this.bookingService.updateBooking(bookingDTO);
	}

	public boolean deleteBooking(Integer idbooking) {
		return this.bookingService.deleteBooking(idbooking);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Booking", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "BookingRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "BookingInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "BookingUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "BookingDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
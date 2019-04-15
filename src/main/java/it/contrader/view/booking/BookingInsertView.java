package it.contrader.view.booking;

import java.util.Scanner;

import it.contrader.controller.BookingController;
import it.contrader.controller.Request;
import it.contrader.dto.BookingDTO;
import it.contrader.dto.CityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class BookingInsertView implements View {

	private BookingController bookingController;
	private Request request;

	public BookingInsertView() {
		this.bookingController = new BookingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idbooking;
<<<<<<< HEAD
		String nomebooking;
		
		System.out.println("Digita lo username della prenotazione: ");
		nomebooking = getInput();
		bookingController.insertBooking(new BookingDTO(nomebooking));
=======
		String usernamebooking;
		
		System.out.println("Digita il dell'utente: ");
		usernamebooking = getInput();
		bookingController.insertBooking(new BookingDTO(usernamebooking));
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Booking", "doControl", request);
	}

}



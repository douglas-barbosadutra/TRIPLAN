package it.contrader.view;

import java.util.List;
import java.util.Scanner;


import it.contrader.controller.Request;
import it.contrader.controller.BookingController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Booking;

public class BookingView implements View {

	private BookingController bookingController;
	private Request request;
	private String choice;
	
	public BookingView() {
		this.bookingController = new BookingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		
		System.out.println("ID\tViaggio Prenotato");
		System.out.print("------------------");
		List<Booking> prenotazione = bookingController.getAllBooking();
		System.out.println();
		prenotazione.forEach(booking -> System.out.println(booking.toString()));
		System.out.println();
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [E]sci");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("Booking", "doControl", this.request);
	}

}





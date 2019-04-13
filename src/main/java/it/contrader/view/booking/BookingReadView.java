package it.contrader.view.booking;

import java.util.Scanner;

import it.contrader.controller.BookingController;
import it.contrader.controller.Request;
import it.contrader.dto.BookingDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class BookingReadView implements View {

	private BookingController bookingController;
	private Request request;

	public BookingReadView() {
		this.bookingController = new BookingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idbookingToRead;

		System.out.println("Inserisci l'ID dela prenotazione:");

		try {
			idbookingToRead = Integer.parseInt(getInput());
			BookingDTO bookingDB = bookingController.readBooking(idbookingToRead);

			System.out.println("Id Prenotazione: " + bookingDB.getIdBooking());
			System.out.println("Nome Prenotazione: " + bookingDB.getUsernameBooking());
			
			
			//Wait prenotazione to show
			System.out.println("Premi un tasto per continuare");
			try {
				getInput();
			} catch (Exception e) {
				
			}

		} catch (Exception e) {
			System.out.println("Valore inserito errato.");
		}

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



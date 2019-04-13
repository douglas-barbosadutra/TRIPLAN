package it.contrader.view.booking;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.BookingController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Booking;
import it.contrader.view.View;

public class BookingDeleteView implements View {
	

	

		private BookingController bookingController;
		private Request request;

		public BookingDeleteView() {
			this.bookingController = new BookingController();
		}

		@Override
		public void showResults(Request request) {
		}

		@Override
		public void showOptions() {
			//List<Booking> cirt;
			//String idbooking;

			//Booking = bookingController.getAllBooking();
			System.out.println("Inserisci l'ID dela prenotazione da cancellare : ");
			//System.out.println();
			//progetto.forEach(city -> System.out.println(city));
			//System.out.println();
			//System.out.println("Digita l'ID della prenotazione:");
			String idbooking = getInput();

			if (idbooking != null && StringUtils.isStrictlyNumeric(idbooking)) {
				bookingController.deleteBooking(Integer.parseInt(idbooking));
			} else {
				System.out.println("Valore inserito errato");
			}
		}

		@Override
		public String getInput() {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextLine();
		}

		@Override
		public void submit() {
			request = new Request();
			request.put("mode", "menu");
			request.put("choice", "");
			MainDispatcher.getInstance().callAction("City", "doControl", request);
		}

	}



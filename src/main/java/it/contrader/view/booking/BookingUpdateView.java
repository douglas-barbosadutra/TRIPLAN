package it.contrader.view.booking;

import java.util.Scanner;

import it.contrader.controller.BookingController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.BookingDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class BookingUpdateView implements View {

	private BookingController bookingController;
	private Request request;

	public BookingUpdateView() {
		this.bookingController = new BookingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idbookingToUpdate;
<<<<<<< HEAD
		String nomebooking;
=======
		String usernamebooking;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f

		/*
		 * List<City> city; Integer idcity; city = cityController.getAllCity();
		 * 
		 */
		System.out.println("\n----- Seleziona la prenotazione da modificare  -----\n");
		// System.out.println();
		// city.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		BookingDTO bookingDTO = new BookingDTO();

		System.out.println("Digita l'Id della prenotazione da modificare:");
		try {
			idbookingToUpdate = Integer.parseInt(getInput());
			if (idbookingToUpdate != 0) {
				bookingDTO.setIdBooking(idbookingToUpdate);

				System.out.println("Digita il nuovo Nome della prenotazione:");
<<<<<<< HEAD
				nomebooking = getInput();
				if (!nomebooking.equals(""))
					bookingDTO.setNomeBooking(nomebooking);
=======
				usernamebooking = getInput();
				if (!usernamebooking.equals(""))
					bookingDTO.setUsernameBooking(usernamebooking);
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f

				bookingController.updateBooking(bookingDTO);

			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
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
		MainDispatcher.getInstance().callAction("City", "doControl", request);
	}

}



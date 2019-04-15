package it.contrader.view.places;

import java.util.Scanner;

import it.contrader.controller.PlacesController;
import it.contrader.controller.Request;
import it.contrader.dto.PlacesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class PlacesReadView implements View {

	private PlacesController placesController;
	private Request request;

	public PlacesReadView() {
		this.placesController = new PlacesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idplacesToRead;

		System.out.println("Inserisci l'ID del monumento:");

		try {
			idplacesToRead = Integer.parseInt(getInput());
			PlacesDTO placesDB = placesController.readPlaces(idplacesToRead);

			System.out.println("Id monumento: " + placesDB.getIdPlaces());
			System.out.println("Nome monumento: " + placesDB.getNomePlaces());
			
			
			//Wait places to show
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
		MainDispatcher.getInstance().callAction("Places", "doControl", request);
	}

}



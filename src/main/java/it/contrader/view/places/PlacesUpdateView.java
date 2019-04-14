package it.contrader.view.places;

import java.util.Scanner;

import it.contrader.controller.PlacesController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.PlacesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class PlacesUpdateView implements View {

	private PlacesController placesController;
	private Request request;

	public PlacesUpdateView() {
		this.placesController = new PlacesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idplacesToUpdate;
		String nomeplaces;
		String latplaces;
		String longplaces;
		
		/*
		 * List<Places> places; Integer idplaces; places = placesController.getAllPlaces();
		 * 
		 */
		System.out.println("\n----- Seleziona l'attrazione da modificare  -----\n");
		// System.out.println();
		// places.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		PlacesDTO placesDTO = new PlacesDTO();

		System.out.println("Digita l'Id dell'attrazione da modificare:");
		try {
			idplacesToUpdate = Integer.parseInt(getInput());
			if (idplacesToUpdate != 0) {
				placesDTO.setIdPlaces(idplacesToUpdate);

				System.out.println("Digita la nuova attrazione:");
				nomeplaces = getInput();
				if (!nomeplaces.equals(""))
					placesDTO.setNomePlaces(nomeplaces);

				placesController.updatePlaces(placesDTO);
				
				System.out.println("Digita la nuova latitudine:");
				latplaces = getInput();
				if (!latplaces.equals(""))
					placesDTO.setLatPlaces(latplaces);

				placesController.updatePlaces(placesDTO);
				
				System.out.println("Digita la nuova longitudine:");
				longplaces = getInput();
				if (!longplaces.equals(""))
					placesDTO.setLongPlaces(longplaces);

				placesController.updatePlaces(placesDTO);

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
		MainDispatcher.getInstance().callAction("Places", "doControl", request);
	}

}



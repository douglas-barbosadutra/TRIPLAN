package it.contrader.view.places;

import java.util.Scanner;

import it.contrader.controller.PlacesController;
import it.contrader.controller.Request;
import it.contrader.dto.PlacesDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class PlacesInsertView implements View {

	private PlacesController placesController;
	private Request request;

	public PlacesInsertView() {
		this.placesController = new PlacesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idplaces;
		String nomeplaces;
        String longplaces;
        String latplaces;
		
		
		System.out.println("Digita il nome dell'attrazione: ");
		nomeplaces = getInput();
		System.out.println("Digita la latitudine: ");
		longplaces = getInput();
		System.out.println("Digita la longitudine: ");
		latplaces = getInput();
	
			placesController.insertPlaces(new PlacesDTO());
		
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



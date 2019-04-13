package it.contrader.view;

import java.util.List;
import java.util.Scanner;


import it.contrader.controller.Request;
import it.contrader.controller.PlacesController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Places;

public class PlacesView implements View {

	private PlacesController placesController;
	private Request request;
	private String choice;
	
	public PlacesView() {
		this.placesController = new PlacesController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Scegli cosa modficare -------\n");
		
		System.out.println("ID\tNome Attrazione\t\tLatitudine\tLongitudine");
		System.out.print("------------------------------------------------------");
		List<Places> placess = placesController.getAllPlaces();
		System.out.println();
		placess.forEach(places -> System.out.println(places.toString()));
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
		    MainDispatcher.getInstance().callAction("Places", "doControl", this.request);
	}

}





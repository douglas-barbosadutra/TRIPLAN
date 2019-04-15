package it.contrader.view;

import java.util.List;
import java.util.Scanner;


import it.contrader.controller.Request;
import it.contrader.controller.PlacesController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Places;

public class Places2View implements View {

	private PlacesController placesController;
	private Request request;
	private String choice;
	

	@Override
	public void showResults(Request request) {
		
		
		
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Scegli cosa visitare -------\n");
		
		System.out.println("ID\tNome_Monumeto");
		System.out.print("------------------------------------------------------");
		
		Integer idPlace = (Integer) request.get("id");
		List<Places> placess = placesController.getAllPlaces();
		System.out.println();
		placess.forEach(places -> System.out.println(places.toString()));
		System.out.println();
		
		System.out.println("\n---- Scegli gli Id delle attrazioni da visitare -----\n");
		
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





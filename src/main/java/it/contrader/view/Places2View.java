package it.contrader.view;

import java.util.List;
import java.util.Scanner;


import it.contrader.controller.Request;
import it.contrader.controller.PlacesController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.City;
import it.contrader.model.Places;

public class Places2View implements View {

	private PlacesController placesController;
	private Request request;
	private String choice;
	
	public Places2View() {
		this.placesController = new PlacesController();
	}

	@Override
	public void showResults(Request request) {
		List<Places> places = placesController.getCityPlaces((Integer)request.get("id"));
		System.out.println();
		places.forEach(place -> System.out.println(place.toString()));
		System.out.println();
		System.out.println("\t Scegli le attrazioni");
	}

	@Override
	public void showOptions() {
		
		
	
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





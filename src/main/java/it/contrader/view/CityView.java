package it.contrader.view;

import java.util.List;
import java.util.Scanner;


import it.contrader.controller.Request;
import it.contrader.controller.CityController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.City;

public class CityView implements View {

	private CityController cityController;
	private Request request;
	private String choice;
	
	public CityView() {
		this.cityController = new CityController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		
		System.out.println("ID\tCitt�");
		System.out.print("------------------------------------------------------");
		List<City> citta = cityController.getAllCity();
		System.out.println();
		citta.forEach(city -> System.out.println(city.toString()));
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
		    MainDispatcher.getInstance().callAction("Progetto", "doControl", this.request);
	}

}





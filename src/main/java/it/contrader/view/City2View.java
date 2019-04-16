package it.contrader.view;

import java.util.List;
import java.util.Scanner;


import it.contrader.controller.Request;
import it.contrader.dto.CityDTO;
import it.contrader.controller.CityController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.City;


public class City2View implements View {

	private CityController cityController;
	private Request request;
	private String choice;
	
	public City2View() {
		this.cityController = new CityController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idcityToRead;	
		
		System.out.println("ID\tCittà");
		System.out.print("------------------");
		List<City> città = cityController.getAllCity();
		System.out.println();
		città.forEach(city -> System.out.println(city.toString()));
		System.out.println();
		
		System.out.println("Dove vuoi andare?");
		System.out.println("Scegli l'ID della città");
		try {
			idcityToRead = Integer.parseInt(getInput());
			CityDTO cityDB = cityController.readCity(idcityToRead);

			System.out.println("Id Città: " + cityDB.getIdCity());
			System.out.println("Nome Città: " + cityDB.getName_City());
			
			
			//Wait progetto to show
			System.out.println("\nCosa vuoi visitare?:");
			
			request = new Request();
			request.put("id",idcityToRead );
			MainDispatcher.getInstance().callView("Places2", request);
			
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
		MainDispatcher.getInstance().callAction("City", "doControl", request);
	}

}





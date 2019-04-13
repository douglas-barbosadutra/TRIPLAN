package it.contrader.view.city;

import java.util.Scanner;

import it.contrader.controller.CityController;
import it.contrader.controller.Request;
import it.contrader.dto.CityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class CityInsertView implements View {

	private CityController cityController;
	private Request request;

	public CityInsertView() {
		this.cityController = new CityController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idcity;
		String nomecity;
  	
		
		System.out.println("Digita il nome della città: ");
		nomecity = getInput();
		
	
			cityController.insertCity(new CityDTO(nomecity));
		
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



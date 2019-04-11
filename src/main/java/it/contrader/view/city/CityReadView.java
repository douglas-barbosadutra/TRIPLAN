package it.contrader.view.city;

import java.util.Scanner;

import it.contrader.controller.CityController;
import it.contrader.controller.Request;
import it.contrader.dto.CityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class CityReadView implements View {

	private CityController cityController;
	private Request request;

	public CityReadView() {
		this.cityController = new CityController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idcityToRead;

		System.out.println("Inserisci l'ID dela città:");

		try {
			idcityToRead = Integer.parseInt(getInput());
			CityDTO cityDB = cityController.readCity(idcityToRead);

			System.out.println("Id Città: " + cityDB.getIdCity());
			System.out.println("Nome Città: " + cityDB.getNameCity());
			
			
			//Wait progetto to show
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
		MainDispatcher.getInstance().callAction("City", "doControl", request);
	}

}



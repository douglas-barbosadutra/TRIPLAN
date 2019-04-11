package it.contrader.view.city;

import java.util.Scanner;

import it.contrader.controller.CityController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.CityDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class CityUpdateView implements View {

	private CityController cityController;
	private Request request;

	public CityUpdateView() {
		this.cityController = new CityController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int idcityToUpdate;
		String namecity;

		/*
		 * List<City> city; Integer idcity; city = progettoController.getAllCity();
		 * 
		 */
		System.out.println("\n----- Seleziona la cittaà da modificare  -----\n");
		// System.out.println();
		// city.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		CityDTO cityDTO = new CityDTO();

		System.out.println("Digita l'Id della città da modificare:");
		try {
			idcityToUpdate = Integer.parseInt(getInput());
			if (idcityToUpdate != 0) {
				cityDTO.setIdCity(idcityToUpdate);

				System.out.println("Digita il nuovo Nome della città:");
				namecity = getInput();
				if (!namecity.equals(""))
					cityDTO.setNameCity(namecity);

				cityController.updateCity(cityDTO);

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
		MainDispatcher.getInstance().callAction("City", "doControl", request);
	}

}



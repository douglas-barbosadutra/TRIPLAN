package it.contrader.view;

import java.util.List;
import java.util.Scanner;


import it.contrader.controller.Request;
import it.contrader.dto.CityDTO;
<<<<<<< HEAD
import it.contrader.dto.PlacesDTO;
=======
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
import it.contrader.controller.CityController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.City;


public class City2View implements View {

	private CityController cityController;
<<<<<<< HEAD
	//private Places2Controller places2Controller;
=======
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
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
<<<<<<< HEAD

		
		try {
			idcityToRead = Integer.parseInt(getInput());
			request = new Request();
			request.put("mode", "viewListPlaces");
			request.put("choice","Z");
			request.put("id",idcityToRead);
			CityDTO cityDB = cityController.readCity(idcityToRead);
			MainDispatcher.getInstance().callView("Places2",request);
			//MainDispatcher.getInstance().callAction("Places", "doControl",request);
		} catch (Exception e) {
		System.out.println("Valore inserito errato.");
		}}


=======
		try {
			idcityToRead = Integer.parseInt(getInput());
			CityDTO cityDB = cityController.readCity(idcityToRead);

			System.out.println("Id Città: " + cityDB.getIdCity());
			System.out.println("Nome Città: " + cityDB.getName_City());
			
			

			System.out.println("\nAttrazioni:");
			MainDispatcher.getInstance().callView("Places2", request);
			
		} catch (Exception e) {
			System.out.println("Valore inserito errato.");
		}

	}
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

<<<<<<< HEAD
	@Override
	public void submit() {
		// TODO Auto-generated method stub
		
=======
	
	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("City", "doControl", request);
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	}

}





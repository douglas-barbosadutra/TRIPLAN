package it.contrader.view;

import java.util.List;
import java.util.Scanner;


import it.contrader.controller.Request;
import it.contrader.controller.PlacesController;
import it.contrader.main.MainDispatcher;
<<<<<<< HEAD
import it.contrader.model.Places;
=======
import it.contrader.model.Places2;
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f

public class Places2View implements View {

	private PlacesController placesController;
	private Request request;
	private String choice;
	
<<<<<<< HEAD

	@Override
	public void showResults(Request request) {
		
		
		
=======
	public Places2View() {
		this.placesController = new PlacesController();
	}

	@Override
	public void showResults(Request request) {
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Scegli cosa visitare -------\n");
		
<<<<<<< HEAD
		System.out.println("ID\tNome_Monumeto");
		System.out.print("------------------------------------------------------");
		
		Integer idPlace = (Integer) request.get("id");
		List<Places> placess = placesController.getAllPlaces();
		System.out.println();
		placess.forEach(places -> System.out.println(places.toString()));
		System.out.println();
		
		System.out.println("\n---- Scegli gli Id delle attrazioni da visitare -----\n");
		
=======
		System.out.println("ID\tNome Attrazione");
		System.out.print("------------------------------------------------------");
		List<Places2> placess2 = placesController.getSelectPlaces();
		System.out.println();
		placess2.forEach(places2 -> System.out.println(places2.toString()));
		System.out.println();
		
		System.out.println("\n---- Scegli gli Id delle attrazioni da visitare -----\n");
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
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





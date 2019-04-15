package it.contrader.view.places;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.PlacesController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Places;
import it.contrader.view.View;

public class PlacesDeleteView implements View {
	

	

		private PlacesController placesController;
		private Request request;

		public PlacesDeleteView() {
			this.placesController = new PlacesController();
		}

		@Override
		public void showResults(Request request) {
		}

		@Override
		public void showOptions() {
			//List<Places> places;
			//String idplaces;

			//progetto = placesController.getAllPlaces();
			System.out.println("Inserisci l'ID del monumento da cancellare : ");
			//System.out.println();
			//progetto.forEach(places -> System.out.println(places));
			//System.out.println();
			//System.out.println("Digita l'ID Places:");
			String idplaces = getInput();

			if (idplaces != null && StringUtils.isStrictlyNumeric(idplaces)) {
				placesController.deletePlaces(Integer.parseInt(idplaces));
				
			} else {
				System.out.println("Valore inserito errato");
			}
		}

		@Override
		public String getInput() {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextLine();
		}

		@Override
		public void submit() {
			request = new Request();
			request.put("mode", "menu");
			request.put("choice", "");
			MainDispatcher.getInstance().callAction("Places", "doControl", request);
		}

	}



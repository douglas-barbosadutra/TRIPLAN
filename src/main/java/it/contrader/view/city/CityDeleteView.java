package it.contrader.view.city;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.CityController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.City;
import it.contrader.view.View;

public class CityDeleteView implements View {
	

	

		private CityController cityController;
		private Request request;

		public CityDeleteView() {
			this.cityController = new CityController();
		}

		@Override
		public void showResults(Request request) {
		}

		@Override
		public void showOptions() {
			//List<Progetto> cirt;
			//String idcity;

			//city = cityController.getAllCity();
			System.out.println("Inserisci l'ID dela citta da cancellare : ");
			//System.out.println();
			//progetto.forEach(progetto -> System.out.println(progetto));
			//System.out.println();
			//System.out.println("Digita l'ID Progetto:");
			String idcity = getInput();

			if (idcity != null && StringUtils.isStrictlyNumeric(idcity)) {
				cityController.deleteCity(Integer.parseInt(idcity));
				
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
			MainDispatcher.getInstance().callAction("City", "doControl", request);
		}

	}



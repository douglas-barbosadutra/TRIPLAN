/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeBOView implements View {

    private String choice;

    public void showResults(Request request) {
    	System.out.println("Benvenuto in Triplan "+request.get("nomeUtente").toString());
    }


    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Cosa vuoi fare?:");
        System.out.println("[V]iaggia [P]renotazioni [E]sci");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("V")) {
        	MainDispatcher.getInstance().callView("City", null);
        }
        if (choice.equalsIgnoreCase("P")) {
        	MainDispatcher.getInstance().callView("Booking", null);
        }
        if (choice.equalsIgnoreCase("L"))
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}

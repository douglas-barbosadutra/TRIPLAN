/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView implements View {

    private String choice;

    public void showResults(Request request) {
    	System.out.println("Benvenuto in Triplan "+request.get("nomeUtente").toString());
    }


    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Seleziona cosa vuoi gestire:");
<<<<<<< HEAD
System.out.println("[U]tenti [C]itt� [A]ttrazioni [P]renotazioni [E]sci");
=======
System.out.println("[U]tenti [C]itt� [A]ttrazioni [E]sci");
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("U")) {
        	MainDispatcher.getInstance().callView("User", null);
        }
        if (choice.equalsIgnoreCase("C")) {
        	MainDispatcher.getInstance().callView("City", null);
        }
        if (choice.equalsIgnoreCase("A")) {
        	MainDispatcher.getInstance().callView("Places", null);
<<<<<<< HEAD
        }	
        if (choice.equalsIgnoreCase("P")) {
            	MainDispatcher.getInstance().callView("Booking", null);
        }

=======
        }
        if (choice.equalsIgnoreCase("P")) {
        	MainDispatcher.getInstance().callView("Booking", null);
        }        
>>>>>>> da47f7a87b5e44a5e8262e05cb280c70e51fbc2f
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

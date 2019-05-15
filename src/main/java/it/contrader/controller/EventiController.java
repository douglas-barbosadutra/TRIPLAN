package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.EventiDTO;
import it.contrader.model.Eventi;


@RestController
@RequestMapping("/eventi")
@CrossOrigin(origins = "http://localhost:4200")
public class EventiController extends AbstractController<Eventi, EventiDTO> {

	//ALL crud methods in AbstractController
}

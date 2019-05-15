package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.HotelDTO;
import it.contrader.model.Hotel;


@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController extends AbstractController<Hotel, HotelDTO> {

	//ALL crud methods in AbstractController
}

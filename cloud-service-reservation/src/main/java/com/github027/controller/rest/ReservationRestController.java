package com.github027.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/reservations")
@RestController
public class ReservationRestController {
	
	@GetMapping("/{id}")
	public String read(@PathVariable Long id) {
		return "hello this is ReservationRestController.read() #" + id;
	}

}

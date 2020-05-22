package it.AleValeProject.Esame2k20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.AleValeProject.Esame2k20.webServices.DataService;
import it.AleValeProject.Esame2k20.webServices.DataServiceImpl;

@RestController
public class Controller {
	
	@Autowired
	private DataService serviziodati;
	
	@GetMapping("/GetMetadata")
	public ResponseEntity<Object> getMetaD(){
		return new ResponseEntity<>(serviziodati.VisulizzaMetadata(),HttpStatus.OK);
	}
	
	@GetMapping("/GetData")
	
	
	@GetMapping("/GetDataWithFilter/")
	
	
	@GetMapping("/GetFieldStats")
	
	
	@GetMapping("/GetStats")
	
	
	@GetMapping("/GetStatsWithFilters")
	
	
	@GetMapping("/GetFieldStatsWithFilter")
	
	
}

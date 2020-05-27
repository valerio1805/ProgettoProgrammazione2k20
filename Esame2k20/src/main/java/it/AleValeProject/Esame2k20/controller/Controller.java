package it.AleValeProject.Esame2k20.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.AleValeProject.Esame2k20.exception.FilterException;
import it.AleValeProject.Esame2k20.webServices.DataService;
import it.AleValeProject.Esame2k20.webServices.DataServiceImpl;

@RestController
public class Controller {
	
	@Autowired
	private DataService dataservice;
	
	@GetMapping("/GetInstructions")
	public ResponseEntity<Object> getInstruction(){
		return new ResponseEntity<>(dataservice.VisulizzaIstruzioni(),HttpStatus.OK);
	}
	
	@GetMapping("/GetMetadata")
	public ResponseEntity<Object> getMetadata(){
		return new ResponseEntity<>(dataservice.VisulizzaMetadata(),HttpStatus.OK);
	}
	
	@GetMapping("/GetData")
	public ResponseEntity<Object> getData(){
		return new ResponseEntity<>(dataservice.VisualizzaData(),HttpStatus.OK);	
	}
	
	@PostMapping("/GetData")
	public ResponseEntity<Object> getFilteredData(@RequestBody String filter) throws FilterException{
		return new ResponseEntity<>(dataservice.VisualizzaData(filter),HttpStatus.OK);
			
	}
	
	@GetMapping("/GetStats")
	public ResponseEntity<Object> getStatistics(){
		return new ResponseEntity<>(dataservice.VisualizzaStatistiche(),HttpStatus.OK);	
	}
	
	@PostMapping("/GetStats")
	public ResponseEntity<Object> getFilteredStatistics(@RequestBody String filter) throws FilterException{
		return new ResponseEntity<>(dataservice.VisualizzaStatistiche(filter),HttpStatus.OK);
			
	}
	
	@PostMapping("/GetStats2")
	public ResponseEntity<Object> getFilteredFieldedStatistic(@RequestBody String filtro, @RequestParam(name="field")String campo ){
		return new ResponseEntity<>(dataservice.VisualizzaStatistiche(filtro,campo),HttpStatus.OK);
	}	
}

package it.AleValeProject.Esame2k20.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.AleValeProject.Esame2k20.webServices.DataService;
import it.AleValeProject.Esame2k20.webServices.DataServiceImpl;

@RestController
public class Controller {
	
	@Autowired
	private DataService serviziodati;
	
	@GetMapping("/GetInstructions")
	public ResponseEntity<Object> getinst(){
		return new ResponseEntity<>(serviziodati.VisulizzaIstruzioni(),HttpStatus.OK);
	}
	
	@GetMapping("/GetMetadata")
	public ResponseEntity<Object> getMetaD(){
		return new ResponseEntity<>(serviziodati.VisulizzaMetadata(),HttpStatus.OK);
	}
	
	@GetMapping("/GetData")
	public ResponseEntity<Object> getData(){
		return new ResponseEntity<>(serviziodati.VisalizzaData(),HttpStatus.OK);
	}
	
	@GetMapping("/GetDataFilter")
	public ResponseEntity<Object> getData(@RequestParam(name="filter")String filtro){
		if(filtro==null)
			return new ResponseEntity<>(serviziodati.VisalizzaData(),HttpStatus.OK);
		else
			return new ResponseEntity<>(serviziodati.VisulizzaData(filtro),HttpStatus.OK);
	}
	
	@GetMapping("/GetStats")
	public ResponseEntity<Object> getStats(){
		return new ResponseEntity<>(serviziodati.VisulizzaStatistiche(),HttpStatus.OK);	
	}
	
	@GetMapping("/GetStatsField&Filter")
	public ResponseEntity<Object> getStats(@RequestParam(name="filter")String filtro,@RequestParam(name="field")String campo ){
		if(filtro==null&&campo==null)
			return new ResponseEntity<>(serviziodati.VisulizzaStatistiche(),HttpStatus.OK);	
		else
			return new ResponseEntity<>(serviziodati.VisulizzaStatistiche(filtro,campo),HttpStatus.OK);
	}	
}

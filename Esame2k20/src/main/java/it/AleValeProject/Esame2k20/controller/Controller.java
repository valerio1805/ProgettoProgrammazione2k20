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

import it.AleValeProject.Esame2k20.eccezioni.FilterException;
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
	
	@PostMapping("/GetData")
	public ResponseEntity<Object> getMetaD(@RequestBody String filtro) throws FilterException{
		return new ResponseEntity<>(serviziodati.VisualizzaData(filtro),HttpStatus.OK);
			
	}
	
	@GetMapping("/GetData")
	public ResponseEntity<Object> getProva(){
		return new ResponseEntity<>(serviziodati.VisualizzaData(),HttpStatus.OK);	
	}
	
	@GetMapping("/GetStats")
	public ResponseEntity<Object> getStats(){
		return new ResponseEntity<>(serviziodati.VisualizzaStatistiche(),HttpStatus.OK);	
	}
	
	@PostMapping("/GetStats")
	public ResponseEntity<Object> getStatsFiltrate(@RequestBody String filtro) throws FilterException{
		return new ResponseEntity<>(serviziodati.VisualizzaStatistiche(filtro),HttpStatus.OK);
			
	}
	
	@PostMapping("/GetStats2")
	public ResponseEntity<Object> getStatsFieldFiltra(@RequestBody String filtro, @RequestParam(name="field")String campo ){
		return new ResponseEntity<>(serviziodati.VisualizzaStatistiche(filtro,campo),HttpStatus.OK);
	}	
}

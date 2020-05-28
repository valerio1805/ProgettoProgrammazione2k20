package it.AleValeProject.Esame2k20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.AleValeProject.Esame2k20.exception.FieldException;
import it.AleValeProject.Esame2k20.exception.FormatException;
import it.AleValeProject.Esame2k20.exception.MismatchTypeFilterException;
import it.AleValeProject.Esame2k20.exception.OperatorException;
import it.AleValeProject.Esame2k20.webServices.DataService;

@RestController
public class Controller {
	
	@Autowired
	private DataService dataservice;
	
	@GetMapping("/GetInstructions")
	public ResponseEntity<Object> getInstruction(){
		return new ResponseEntity<>(dataservice.DisplayInstructions(),HttpStatus.OK);
	}
	
	@GetMapping("/GetMetadata")
	public ResponseEntity<Object> getMetadata(){
		return new ResponseEntity<>(dataservice.DisplayMetadata(),HttpStatus.OK);
	}
	
	@GetMapping("/GetData")
	public ResponseEntity<Object> getData(){
		return new ResponseEntity<>(dataservice.DisplayData(),HttpStatus.OK);	
	}
	
	@PostMapping("/GetData")
	public ResponseEntity<Object> getFilteredData(@RequestBody String filter) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException{
		return new ResponseEntity<>(dataservice.DisplayData(filter),HttpStatus.OK);
			
	}
	
	@GetMapping("/GetStats")
	public ResponseEntity<Object> getStatistics(){
		return new ResponseEntity<>(dataservice.DisplayStatistics(),HttpStatus.OK);	
	}
	
	@PostMapping("/GetStats")
	public ResponseEntity<Object> getFilteredStatistics(@RequestBody String filter) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException{
		return new ResponseEntity<>(dataservice.DisplayStatistics(filter),HttpStatus.OK);
			
	}
	
	@PostMapping("/GetStats2")
	public ResponseEntity<Object> getFilteredFieldedStatistic(@RequestBody String filtro, @RequestParam(name="field")String campo ) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException{
		return new ResponseEntity<>(dataservice.DisplayStatistics(filtro,campo),HttpStatus.OK);
	}	
}

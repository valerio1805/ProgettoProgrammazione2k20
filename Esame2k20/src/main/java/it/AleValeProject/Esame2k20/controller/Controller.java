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
import it.AleValeProject.Esame2k20.exception.StatsParamException;
import it.AleValeProject.Esame2k20.webServices.DataService;

/**
 * 
 * @author vale&ale
 * The controller of the project; here you can see the different roots of the project
 *
 */
@RestController
public class Controller {
	
	/**
	 * The dataservice that provides all the request
	 */
	@Autowired
	private DataService dataservice;
	
	/**
	 * The root where you can see the manual of the app
	 * @return the class that contains the instructions
	 */
	@GetMapping("/GetInstructions")
	public ResponseEntity<Object> getInstruction(){
		return new ResponseEntity<>(dataservice.DisplayInstructions(),HttpStatus.OK);
	}
	
	/**
	 * The root where you can see the association between variabile, type and a description
	 * @return the class that contains the metadata
	 */
	
	@GetMapping("/GetMetadata")
	public ResponseEntity<Object> getMetadata(){
		return new ResponseEntity<>(dataservice.DisplayMetadata(),HttpStatus.OK);
	}
	
	
	/**
	 * The root where you can see the complete set of data
	 * @return the class that contains the data
	 */
	@GetMapping("/GetData")
	public ResponseEntity<Object> getData(){
		return new ResponseEntity<>(dataservice.DisplayData(),HttpStatus.OK);	
	}
	
	
	/**
	 * The root where you can see the group of data selected by the filter added in the body
	 * @return the class that contains the data filtered
	 */
	@PostMapping("/GetData")
	public ResponseEntity<Object> getFilteredData(@RequestBody String filter) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException{
		return new ResponseEntity<>(dataservice.DisplayData(filter),HttpStatus.OK);
			
	}
	
	
	/**
	 * The root where you can see the stats of the data 
	 * @return the class that contains the stats
	 */
	@GetMapping("/GetStats")
	public ResponseEntity<Object> getStatistics(){
		return new ResponseEntity<>(dataservice.DisplayStatistics(),HttpStatus.OK);	
	}
	
	
	/**
	 * The root where you can see the stats of a group of data selected by the filter added in the body
	 * @return the class that contains the stats of the data filtered
	 */
	@PostMapping("/GetStats")
	public ResponseEntity<Object> getFilteredStatistics(@RequestBody String filter) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException{
		return new ResponseEntity<>(dataservice.DisplayStatistics(filter),HttpStatus.OK);
			
	}
	
	
	/**
	 * The root where you can see the stats of a particular field
	 * @return the class that contains the stats of the field selected
	 */
	@GetMapping("/GetFieldStats")
	public ResponseEntity<Object> getFieldedStatistic(@RequestParam(name="field")String campo ) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException{
		return new ResponseEntity<>(dataservice.DisplayFieldStatistics(campo),HttpStatus.OK);
	}
	
	/**
	 * The root where you can see the stats of a particular field of a group of data
	 * @return the class that contains the stats of the field selected of the data that satisfy the filtered
	 */
	@PostMapping("/GetFieldStats")
	public ResponseEntity<Object> getFilteredFieldedStatistic(@RequestParam(name="field")String campo,@RequestBody String filtro ) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException{
		return new ResponseEntity<>(dataservice.DisplayFieldStatistics(filtro,campo),HttpStatus.OK);
	}	
	

}

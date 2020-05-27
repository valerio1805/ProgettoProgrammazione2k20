package it.AleValeProject.Esame2k20.exception;

import org.json.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public class FilterException extends Exception {
	public FilterException(String error) {
		super("CORREGERE FILTRO: " + error);
		//new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filtro scritto male");
	}
}

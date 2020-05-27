package it.AleValeProject.Esame2k20.exception;

public class FilterException extends Exception {
	public FilterException(String error) {
		super("CORREGERE FILTRO: " + error);
	}
}

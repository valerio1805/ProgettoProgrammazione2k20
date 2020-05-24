package it.AleValeProject.Esame2k20.eccezioni;

public class FilterException extends Exception {
	public FilterException(String errore) {
		super("CORREGERE FILTRO: " + errore);
	}
}

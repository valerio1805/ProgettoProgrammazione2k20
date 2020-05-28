package it.AleValeProject.Esame2k20.exception;

public class FieldException extends Exception {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public FieldException (String toDisplay) {
	super("Campo "+toDisplay);
}
}

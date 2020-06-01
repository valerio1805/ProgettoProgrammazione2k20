package it.AleValeProject.Esame2k20.exception;

/**
 * The exception of a not valid field
 * @author Di Biase Alessandro, Donnini Valerio
 * 
 */
public class FieldException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The constructor of the class
	 * @param toDisplay The String to show to the user in case of problem
	 */
	public FieldException (String toDisplay) {
		super("Field "+toDisplay);
	}
}

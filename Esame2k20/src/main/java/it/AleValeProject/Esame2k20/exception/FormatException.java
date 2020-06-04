package it.AleValeProject.Esame2k20.exception;
/**
 * The exception of a not valid filter added
 * @author Di Biase Alessandro, Donnini Valerio
 * 
 */

public class FormatException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * One constructor of the class
	 * @param wrongField The field that is not correct
	 * @param wrongValue The value that is not correct
	 */
	public FormatException(String wrongField, int wrongValue) {
		super("For the field "+wrongField+" the expression is not valid: wrong parameter number ("+wrongValue+")");
	}
	
	/**
	 * One constructor of the class
	 * @param toDisplay The String to show to the user in case of problem
	 */
	public FormatException(String toDisplay) {
		super (toDisplay);
	}
}

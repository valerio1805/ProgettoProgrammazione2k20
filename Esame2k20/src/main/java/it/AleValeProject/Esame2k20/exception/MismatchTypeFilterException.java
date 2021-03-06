package it.AleValeProject.Esame2k20.exception;

/**
 * The exception of a mismatch between value and field
 * @author Di Biase Alessandro, Donnini Valerio
 *
 *
 */
public class MismatchTypeFilterException extends Exception {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the class
	 * @param toDisplay The String to show to the user in case of problem
	 */
	public MismatchTypeFilterException(String toDisplay) {
		 super(toDisplay);
	 }
}

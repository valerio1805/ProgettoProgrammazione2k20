package it.AleValeProject.Esame2k20.exception;

/**
 * 
 * @author vale&ale
 * The exception of a mismatch between value and field
 *
 */
public class MismatchTypeFilterException extends Exception {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the class
	 * @param toDiplay The String to show to the user in case of problem
	 */
	public MismatchTypeFilterException(String toDisplay) {
		 super(toDisplay);
	 }
}

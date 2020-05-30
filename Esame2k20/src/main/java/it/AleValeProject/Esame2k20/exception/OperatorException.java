package it.AleValeProject.Esame2k20.exception;

/**
 * 
 * @author vale&ale
 * The exception of a not valid operator added in the filter
 */
public class OperatorException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The constructor of the class
	 * @param wrongOperator The String to show to the user in case of problem
	 */
	public OperatorException(String wrongOperator) {
		super("The operator "+wrongOperator+" isn't correct");
	}


}

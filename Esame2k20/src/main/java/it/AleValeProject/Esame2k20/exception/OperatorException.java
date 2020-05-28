package it.AleValeProject.Esame2k20.exception;

public class OperatorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperatorException(String wrongOperator) {
		super("L'operatore "+wrongOperator+" non è corretto");
	}


}

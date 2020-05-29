package it.AleValeProject.Esame2k20.exception;

public class FormatException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FormatException(String wrongField, int wrongValue) {
		super("For the field "+wrongField+" the expression is not valid: wrong parameter number ("+wrongValue+")");
		//new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filtro scritto male");
	}
	public FormatException(String toDisplay) {
		super (toDisplay);
	}
}

package it.AleValeProject.Esame2k20.exception;

/**
 * The exception for a not found file
 * @author Di Biase Alessandro, Donnini Valerio
 *
 */
public class DeleteFileException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the class
	 * @param toDiplay The String to show to the user in case of problem
	 */
	public DeleteFileException(String toDiplay)
	{
		super(toDiplay);
	}
}

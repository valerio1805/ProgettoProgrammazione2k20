package it.AleValeProject.Esame2k20.exception;

/**
 * 
 * @author vale&ale
 * The exception for a not found file
 */
public class DeleteFileException extends Exception{

	/**
	 * The constructor of the class
	 * @param toDiplay The String to show to the user in case of problem
	 */
	public DeleteFileException(String toDiplay)
	{
		super(toDiplay);
	}
}

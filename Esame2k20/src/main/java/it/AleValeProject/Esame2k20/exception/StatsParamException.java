package it.AleValeProject.Esame2k20.exception;
/**
 * The exception of a not valid field added for the stats
 * @author Di Biase Alessandro, Donnini Valerio
 * 
 *
 */

public class StatsParamException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the class
	 * @param toDisplay The String to show to the user in case of problem
	 */
	public StatsParamException(String toDisplay)
	{
		super(toDisplay);
	}

}

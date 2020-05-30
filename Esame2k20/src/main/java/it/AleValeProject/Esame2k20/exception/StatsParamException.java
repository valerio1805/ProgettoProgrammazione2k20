package it.AleValeProject.Esame2k20.exception;
/**
 * 
 * @author vale&ale
 * The exception of a not valid field added for the stats
 *
 */

public class StatsParamException extends Exception{
	
	/**
	 * The constructor of the class
	 * @param toDiplay The String to show to the user in case of problem
	 */
	public StatsParamException(String toDisplay)
	{
		super(toDisplay);
	}

}

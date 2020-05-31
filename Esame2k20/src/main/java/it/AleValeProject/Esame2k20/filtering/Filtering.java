package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * 
 * @author vale&ale
 * Interface for the control of the filtering operation
 *
 */
public interface Filtering {

	/**
	 * The function that return true or false if the the value of recordToPass satisfy the fieldToPass and the valueTopass
	 * @param valueToPass The value of the filter
	 * @param recordToPass The record where control the field and the value
	 * @return true/false according to if the record satisfy the filter or not
	 */
	public abstract Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass);

	/**
	 * Getter for the variabile operator
	 * @return the value of operator
	 */
	public abstract String getOperator();

	/**
	 * Getter for the variabile field
	 * @return the value of field
	 */
	public abstract String getField();
}

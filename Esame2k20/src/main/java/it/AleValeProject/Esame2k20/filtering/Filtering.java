package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

interface Filtering {
	/**
	 * Description of the method FilterFunction.
	 */
	public abstract Boolean FilterFunction(String fieldToPass, ArrayList<String> valueToPass, SingleRecordInfo recordToPass);

	public abstract String getOperator();

	public abstract String getField();
}

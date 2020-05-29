package it.AleValeProject.Esame2k20.filtering.aritm;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioBetHash implements Filtering {

	// Start of user code (user defined attributes for FiltraggioBetw)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioBetHash() {
		// Start of user code constructor for FiltraggioBetw)
		super();
		// End of user code
	}
	private String field = "hashtags[]";

	public String getField() {
		return field;
	}

	private String operator = "$bt";

	public String getOperator() {
		return operator;
	}

	/**
	 * Description of the method Filtra: Boolean.
	 * 
	 * @param fieldToPass
	 * @param valueToPass
	 * @param recordToPass
	 */
	public Boolean FilterFunction(String fieldToPass, ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		double num1 = Double.parseDouble(valueToPass.get(0));
		double num2 = Double.parseDouble(valueToPass.get(1));
		double min;
		double max;
		if (num1 > num2) {
			max = num1;
			min = num2;
		} else {
			max = num2;
			min = num1;
		}
		if (recordToPass.getHashtags().size() < max && recordToPass.getHashtags().size() > min)
			return true;
		else
			return false;
	}

	// Start of user code (user defined methods for FiltraggioBetw)

	// End of user code

}

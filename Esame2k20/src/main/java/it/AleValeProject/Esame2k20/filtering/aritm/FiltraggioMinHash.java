package it.AleValeProject.Esame2k20.filtering.aritm;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioMinHash implements Filtering {

	// Start of user code (user defined attributes for FiltraggioMin)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioMinHash() {
		// Start of user code constructor for FiltraggioMin)
		super();
		// End of user code
	}

	private String field = "hashtags[]";

	public String getField() {
		return field;
	}
	private String operator = "$lt";

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
		if (recordToPass.getHashtags().size() < Double.parseDouble(valueToPass.get(0)))
			return true;
		else
			return false;
	}

	// Start of user code (user defined methods for FiltraggioMin)

	// End of user code
}

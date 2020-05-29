package it.AleValeProject.Esame2k20.filtering.aritm;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioMagHash implements Filtering {

	// Start of user code (user defined attributes for FiltraggioMag)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioMagHash() {
		// Start of user code constructor for FiltraggioMag)
		super();
		// End of user code
	}

	private String operator = "$gt";

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
		if (fieldToPass.equals("hashtags[]"))
			if (recordToPass.getHashtags().size() > Double.parseDouble(valueToPass.get(0)))
				return true;
			else
				return false;
		return true;
	}
}

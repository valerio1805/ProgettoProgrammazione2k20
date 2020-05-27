package it.AleValeProject.Esame2k20.filtering.logic;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioNot implements Filtering {

	// Start of user code (user defined attributes for FiltraggioNot)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioNot() {
		// Start of user code constructor for FiltraggioNot)
		super();
		// End of user code
	}

	/**
	 * Description of the method Filtra: Boolean.
	 * @param fieldToPass
	 * @param valueToPass
	 * @param recordToPass
	 */
	public Boolean FilterFunction(String fieldToPass, ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		for(int j=0; j<recordToPass.getHashtags().size();j++)
			if(recordToPass.getHashtags().get(j).equals(valueToPass.get(0)))
				return false;
		return true;
	}

	// Start of user code (user defined methods for FiltraggioNot)

	// End of user code

}

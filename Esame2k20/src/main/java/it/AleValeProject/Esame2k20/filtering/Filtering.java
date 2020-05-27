package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public interface Filtering {
	// Start of user code (user defined attributes for Filtraggio)

	// End of user code

	/**
	 * Description of the method Filtra.
	 */
	public abstract Boolean FilterFunction(String fieldToPass, ArrayList<String> valueToPass, SingleRecordInfo recordToPass);

	// Start of user code (user defined methods for Filtraggio)

	// End of user code
}

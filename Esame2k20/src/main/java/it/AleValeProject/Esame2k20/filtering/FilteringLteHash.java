package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * The class that implements filtering for the field "hashtags[]" and the operator "$lte"
 * @author Di Biase Alessandro, Donnini Valerio
 * 
 */
public class FilteringLteHash implements Filtering {
	
	private String field = "hashtags[]";
	private String operator = "$lte";
	
	/**
	 * {@inheritDoc}
	 */
	public String getField() {
		return field;
	}


	/**
	 * {@inheritDoc}
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
			if (recordToPass.getHashtags().size() <= Double.parseDouble(valueToPass.get(0)))
				return true;
			else
				return false;
	}
}

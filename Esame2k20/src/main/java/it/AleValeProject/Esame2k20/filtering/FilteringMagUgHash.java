package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

class FilteringMagUgHash implements Filtering {
	private String operator = "$gte";

	private String field = "hashtags[]";

	public String getField() {
		return field;
	}
	public String getOperator() {
		return operator;
	}

	/**
	 * Description of the method Filtra: Boolean.
	 * 
	 * @param valueToPass
	 * @param recordToPass
	 */
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		if (recordToPass.getHashtags().size() >= Double.parseDouble(valueToPass.get(0)))
			return true;
		else
			return false;
	}
}

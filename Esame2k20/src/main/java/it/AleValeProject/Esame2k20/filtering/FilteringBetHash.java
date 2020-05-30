package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * 
 * @author vale&ale
 * The class that implements filtering for the field "hashtags[]" and the operator "$bt"
 */
class FilteringBetHash implements Filtering {
	private String field = "hashtags[]";
	private String operator = "$bt";

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
}

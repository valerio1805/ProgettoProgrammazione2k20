package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * The class that implements filtering for the field "width" and the operator "$bt"
 * @author Di Biase Alessandro, Donnini Valerio
 * 
 */
public class FilteringBetWidth implements Filtering {

	private String operator = "$bt";
	private String field = "width";

	/**
	 * {@inheritDoc}
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getField() {
		return field;
	}
	@Override
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
			
		for (int i = 0; i < recordToPass.getImages().size(); i++)
			if (!(min < recordToPass.getImages().get(i).getWidth()
					&& max > recordToPass.getImages().get(i).getWidth()))
				return false;
		return true;
	}
}

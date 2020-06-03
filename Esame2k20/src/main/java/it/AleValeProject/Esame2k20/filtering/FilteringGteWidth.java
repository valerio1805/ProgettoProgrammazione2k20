package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * The class that implements filtering for the field "width" and the operator "$gte"
 * @author Di Biase Alessandro, Donnini Valerio
 * 
 */
public class FilteringGteWidth implements Filtering {
	
	private String field = "width";
	private String operator = "$gte";

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
	/**
	 * {@inheritDoc}
	 */
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		for (int i = 0; i < recordToPass.getImages().size(); i++)
			if (!(Double.parseDouble(valueToPass.get(0)) <= recordToPass.getImages().get(i).getWidth()))
				return false;
		return true;
	}
}

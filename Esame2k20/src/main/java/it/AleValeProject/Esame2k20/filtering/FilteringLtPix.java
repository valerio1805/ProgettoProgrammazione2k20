package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * The class that implements filtering for the field "megapixel" and the operator "$lt"
 * @author Di Biase Alessandro, Donnini Valerio
 * 
 */
public class FilteringLtPix implements Filtering {
	
	private String field = "megapixel";
	private String operator ="$lt";
	
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
		// TODO Auto-generated method stub
		return this.operator;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		for (int i = 0; i < recordToPass.getImages().size(); i++)
			if (!(Double.parseDouble(valueToPass.get(0)) >= recordToPass.getImages().get(i).getMegapixel()))
				return false;
		return true;
	}

}

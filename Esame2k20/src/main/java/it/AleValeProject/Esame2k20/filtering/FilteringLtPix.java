package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * 
 * @author valeAle;
 * The class that implements filtering for the field "megapixel" and the operator "$lt"
 */
public class FilteringLtPix implements Filtering {

	@Override
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		for (int i = 0; i < recordToPass.getImages().size(); i++)
			if (!(Double.parseDouble(valueToPass.get(0)) >= recordToPass.getImages().get(i).getMegapixel()))
				return false;
		return true;
	}

	private String field = "megapixel";

	public String getField() {
		return field;
	}
	private String operator ="$lte";
	@Override
	public String getOperator() {
		// TODO Auto-generated method stub
		return this.operator;
	}

}

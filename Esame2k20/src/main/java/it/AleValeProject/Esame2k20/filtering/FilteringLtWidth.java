package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

class FilteringLtWidth implements Filtering {

	@Override
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		for (int i = 0; i < recordToPass.getImages().size(); i++)
			if (!(Double.parseDouble(valueToPass.get(0)) >= recordToPass.getImages().get(i).getWidth()))
				return false;
		return true;
	}

	private String field = "width";

	public String getField() {
		return field;
	}
	public String operator = "$lt";
	@Override
	public String getOperator() {
		// TODO Auto-generated method stub
		return this.operator;
	}

}
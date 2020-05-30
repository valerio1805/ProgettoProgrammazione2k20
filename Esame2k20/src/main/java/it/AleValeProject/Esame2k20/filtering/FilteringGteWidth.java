package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

class FilteringGteWidth implements Filtering {
	private String operator = "$gte";

	public String getOperator() {
		return operator;
	}

	private String field = "width";

	public String getField() {
		return field;
	}
	@Override
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		for (int i = 0; i < recordToPass.getImages().size(); i++)
			if (!(Double.parseDouble(valueToPass.get(0)) <= recordToPass.getImages().get(i).getWidth()))
				return false;
		return true;
	}
}

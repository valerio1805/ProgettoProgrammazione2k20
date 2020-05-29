package it.AleValeProject.Esame2k20.filtering.aritm;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioMinUgPix implements Filtering {

	@Override
	public Boolean FilterFunction(String fieldToPass, ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
			for (int i = 0; i < recordToPass.getImmagini().size(); i++)
				if (!(recordToPass.getImmagini().get(i).getMegapixel()<=Double.parseDouble(valueToPass.get(0))))
					return false;
		return true;
	}

	private String field = "megapixel";
	private String operator ="$lte";

	public String getField() {
		return field;
	}
	@Override
	public String getOperator() {
		// TODO Auto-generated method stub
		return this.operator;
	}

}

package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FilteringNot implements Filtering {
	private String operator="$not";
	private String field="hashtags[]";
	public String getField(){
		return this.field;
	}
	public String getOperator() {
		return operator;
	}
	/**
	 * Description of the method Filtra: Boolean.
	 * @param fieldToPass
	 * @param valueToPass
	 * @param recordToPass
	 */
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		boolean find=true;
		for(int i =0;i<valueToPass.size();i++) {
			if(find)
				find=false;
			else
				break;
			for(int j=0; j<recordToPass.getHashtags().size();j++)
				if((recordToPass.getHashtags().get(j).equals(valueToPass.get(i))))
					find=true;
		}
		if(find)
			return false;
		return true;
	}
}

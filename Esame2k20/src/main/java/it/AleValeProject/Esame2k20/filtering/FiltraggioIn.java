package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

class FiltraggioIn implements Filtering {
	private String field="hashtags[]";
	public String getField(){
		return this.field;
	}
	private String operator="$in";
	public String getOperator() {
		return operator;
	}

	/**
	 * Description of the method Filtra: Boolean.
	 * @param fieldToPass
	 * @param valueToPass
	 * @param recordToPass
	 */
	public Boolean FilterFunction(String fieldToPass, ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		
		for(int i =0;i<valueToPass.size();i++)
			for(int j=0; j<recordToPass.getHashtags().size();j++)
				if(recordToPass.getHashtags().get(j).equals(valueToPass.get(i)))
					return true;
		return false;
		}

	// Start of user code (user defined methods for FiltraggioIn)

	// End of user code

}

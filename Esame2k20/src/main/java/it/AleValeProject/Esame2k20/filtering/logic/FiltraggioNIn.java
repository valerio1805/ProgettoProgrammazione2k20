package it.AleValeProject.Esame2k20.filtering.logic;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioNIn implements Filtering {
	// Start of user code (user defined attributes for FiltraggioNIn)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioNIn() {
		// Start of user code constructor for FiltraggioNIn)
		super();
		// End of user code
	}
	private String operator="$nin";
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
	public Boolean FilterFunction(String fieldToPass, ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		for(int i =0;i<valueToPass.size();i++)
			for(int j=0; j<recordToPass.getHashtags().size();j++)
				if(recordToPass.getHashtags().get(j).equals(valueToPass.get(i)))
					return false;
		return true;
	}

	// Start of user code (user defined methods for FiltraggioNIn)

	// End of user code
	
}

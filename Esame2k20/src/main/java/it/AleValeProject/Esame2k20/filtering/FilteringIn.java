package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * The class that implements filtering for the field "hashtags[]" and the operator "$in"
 * @author Di Biase Alessandro, Donnini Valerio
 * 
 */
public class FilteringIn implements Filtering {
	
	private String field="hashtags[]";
	private String operator="$in";
	
	/**
	 * {@inheritDoc}
	 */
	public String getField(){
		return this.field;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * {@inheritDoc}
	 */
	public Boolean FilterFunction(ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		
		for(int i =0;i<valueToPass.size();i++)
			for(int j=0; j<recordToPass.getHashtags().size();j++)
				if(recordToPass.getHashtags().get(j).equals(valueToPass.get(i)))
					return true;
		return false;
		}

	// Start of user code (user defined methods for FiltraggioIn)

	// End of user code

}

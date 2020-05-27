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

	/**
	 * Description of the method Filtra: Boolean.
	 * @param field1
	 * @param value
	 * @param x
	 */
	public Boolean Filtra(String field1, ArrayList<String> value, SingleRecordInfo x) {
		for(int i =0;i<value.size();i++)
			for(int j=0; j<x.getHashtags().size();j++)
				if(x.getHashtags().get(j).equals(value.get(j)))
					return false;
		return true;
	}

	// Start of user code (user defined methods for FiltraggioNIn)

	// End of user code
	
}

package it.AleValeProject.Esame2k20.filtraggio.logic;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtraggio.Filtraggio;
import it.AleValeProject.Esame2k20.model.RecordInfo;

public class FiltraggioNot implements Filtraggio {

	// Start of user code (user defined attributes for FiltraggioNot)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioNot() {
		// Start of user code constructor for FiltraggioNot)
		super();
		// End of user code
	}

	/**
	 * Description of the method Filtra: Boolean.
	 * @param field1
	 * @param value
	 * @param x
	 */
	public Boolean Filtra(String field1, ArrayList<String> value, RecordInfo x) {
		for(int j=0; j<x.getHashtags().size();j++)
			if(x.getHashtags().get(j).equals(value.get(0)))
				return false;
		return true;
	}

	// Start of user code (user defined methods for FiltraggioNot)

	// End of user code

}

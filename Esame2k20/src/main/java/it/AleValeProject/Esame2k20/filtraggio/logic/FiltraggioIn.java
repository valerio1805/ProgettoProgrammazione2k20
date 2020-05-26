package it.AleValeProject.Esame2k20.filtraggio.logic;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtraggio.Filtraggio;
import it.AleValeProject.Esame2k20.model.RecordInfo;

public class FiltraggioIn implements Filtraggio {

	// Start of user code (user defined attributes for FiltraggioIn)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioIn() {
		// Start of user code constructor for FiltraggioIn)
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
		
		for(int i =0;i<value.size();i++)
			for(int j=0; j<x.getHashtags().size();j++)
				if(x.getHashtags().get(j).equals(value.get(j)))
					return true;
		return false;
		}

	// Start of user code (user defined methods for FiltraggioIn)

	// End of user code

}

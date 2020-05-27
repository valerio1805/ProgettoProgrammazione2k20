package it.AleValeProject.Esame2k20.filtering.aritm;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioMag implements Filtering {

	// Start of user code (user defined attributes for FiltraggioMag)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioMag() {
		// Start of user code constructor for FiltraggioMag)
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
		
		if(field1.equals("altezza"))
			for(int i =0;i<x.getImmagini().size();i++)
				if(Double.parseDouble(value.get(0))<x.getImmagini().get(i).getAltezza())
					return true;
		if(field1.equals("larghezza"))
			for(int i =0;i<x.getImmagini().size();i++)
				if(Double.parseDouble(value.get(0))<x.getImmagini().get(i).getLarghezza())
					return true;
		if(field1.equals("megapixel"))
			for(int i =0;i<x.getImmagini().size();i++)
				if(Double.parseDouble(value.get(0))<x.getImmagini().get(i).getMegapixel())
					return true;
		return false;}

	// Start of user code (user defined methods for FiltraggioMag)

	// End of user code

	
}

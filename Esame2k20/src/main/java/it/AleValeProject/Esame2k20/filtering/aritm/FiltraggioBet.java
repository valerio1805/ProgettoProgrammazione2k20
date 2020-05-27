package it.AleValeProject.Esame2k20.filtering.aritm;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioBet implements Filtering {

	// Start of user code (user defined attributes for FiltraggioBetw)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioBet() {
		// Start of user code constructor for FiltraggioBetw)
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
		double num1=Double.parseDouble(value.get(0));
		double num2=Double.parseDouble(value.get(1));
		double min;
		double max;
		if(num1>num2) {
			max=num1;
			min=num2;
		}
		else {
			max=num2;
			min=num1;
		}
		if(field1.equals("altezza"))
			for(int i =0;i<x.getImmagini().size();i++)
				if(min<x.getImmagini().get(i).getAltezza() && max>x.getImmagini().get(i).getAltezza())
					return true;
		if(field1.equals("larghezza"))
			for(int i =0;i<x.getImmagini().size();i++)
				if(min<x.getImmagini().get(i).getLarghezza() && max>x.getImmagini().get(i).getLarghezza())
					return true;
		if(field1.equals("megapixel"))
			for(int i =0;i<x.getImmagini().size();i++)
				if(min<x.getImmagini().get(i).getMegapixel() && max>x.getImmagini().get(i).getMegapixel())
					return true;
		return false;
		}

	// Start of user code (user defined methods for FiltraggioBetw)

	// End of user code
	
}

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
	 * @param fieldToPass
	 * @param valueToPass
	 * @param recordToPass
	 */
	public Boolean FilterFunction(String fieldToPass, ArrayList<String> valueToPass, SingleRecordInfo recordToPass) {
		double num1=Double.parseDouble(valueToPass.get(0));
		double num2=Double.parseDouble(valueToPass.get(1));
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
		if(fieldToPass.equals("altezza"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(!(min<recordToPass.getImmagini().get(i).getHeight() && max>recordToPass.getImmagini().get(i).getHeight()))
					return false;
		if(fieldToPass.equals("larghezza"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(!(min<recordToPass.getImmagini().get(i).getWidth() && max>recordToPass.getImmagini().get(i).getWidth()))
					return false;
		if(fieldToPass.equals("megapixel"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(!(min<recordToPass.getImmagini().get(i).getMegapixel() && max>recordToPass.getImmagini().get(i).getMegapixel()))
					return false;
		return true;
		}

	// Start of user code (user defined methods for FiltraggioBetw)

	// End of user code
	
}

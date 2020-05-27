package it.AleValeProject.Esame2k20.filtering.aritm;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioMin implements Filtering {

	// Start of user code (user defined attributes for FiltraggioMin)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioMin() {
		// Start of user code constructor for FiltraggioMin)
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
		if(fieldToPass.equals("altezza"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(Double.parseDouble(valueToPass.get(0))>=recordToPass.getImmagini().get(i).getHeight())
					return true;
		if(fieldToPass.equals("larghezza"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(Double.parseDouble(valueToPass.get(0))>=recordToPass.getImmagini().get(i).getWidth())
					return true;
		if(fieldToPass.equals("megapixel"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(Double.parseDouble(valueToPass.get(0))>=recordToPass.getImmagini().get(i).getMegapixel())
					return true;
		return false;}

	// Start of user code (user defined methods for FiltraggioMin)

	// End of user code
}

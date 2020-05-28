package it.AleValeProject.Esame2k20.filtering.aritm;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class FiltraggioMinUg implements Filtering {

	// Start of user code (user defined attributes for FiltraggioMinUg)

	// End of user code

	/**
	 * The constructor.
	 */
	public FiltraggioMinUg() {
		// Start of user code constructor for FiltraggioMinUg)
		super();
		// End of user code
	}

	private String operator="$lte";
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
		if(fieldToPass.equals("altezza"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(!(Double.parseDouble(valueToPass.get(0))>recordToPass.getImmagini().get(i).getHeight()))
					return false;
		if(fieldToPass.equals("larghezza"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(!(Double.parseDouble(valueToPass.get(0))>recordToPass.getImmagini().get(i).getWidth()))
					return false;
		if(fieldToPass.equals("megapixel"))
			for(int i =0;i<recordToPass.getImmagini().size();i++)
				if(!(Double.parseDouble(valueToPass.get(0))>recordToPass.getImmagini().get(i).getMegapixel()))
					return false;
		if(fieldToPass.equals("hashtags[]"))
			if(recordToPass.getHashtags().size() <= Double.parseDouble(valueToPass.get(0)))
					return true;
			else
				return false;
		return true;
		}

	// Start of user code (user defined methods for FiltraggioMinUg)

	// End of user code
}

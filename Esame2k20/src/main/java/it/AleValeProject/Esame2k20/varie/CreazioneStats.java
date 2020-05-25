package it.AleValeProject.Esame2k20.varie;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.Immagine;
import it.AleValeProject.Esame2k20.model.RecordInfo;

public class CreazioneStats {

	// Start of user code (user defined attributes for CreazioneStats)

	// End of user code

	/**
	 * The constructor.
	 */
	public CreazioneStats() {
		// Start of user code constructor for CreazioneStats)
		super();
		// End of user code
	}

	/**
	 * Description of the method calcoloMedia.
	 * 
	 * @param data
	 * @param campo
	 */
	public double calcoloMedia(ArrayList<RecordInfo> data, String campo) {
		// dibi thought it could be smaller and faster with less memory to initialize

		boolean contr = false;
		if (campo.equals("larghezza"))
			contr = true;

		// but what if we use calcoloSomma?
		return calcoloSomma(data, campo) / ValueListOfImmagini(data, contr).size();

	}

	/**
	 * Description of the method calcoloSomma.
	 * 
	 * @param data
	 * @param campo
	 */
	public double calcoloSomma(ArrayList<RecordInfo> data, String campo) {
		// Start of user code for method calcoloMedia
		// End of user code

		boolean contr = false;
		double somma = 0;
		if (campo.equals("larghezza"))
			contr = true;
		for (int i = 0; i < ValueListOfImmagini(data, contr).size(); i++)
			somma += ValueListOfImmagini(data, contr).get(i);
		return somma;

	}

	/**
	 * Description of the method calcoloMax.
	 * 
	 * @param data
	 * @param campo
	 */
	public double calcoloMax(ArrayList<RecordInfo> data, String campo) {
		// Start of user code for method calcoloMax
		// End of user code
		boolean contr = false;
		if (campo.equals("larghezza"))
			contr = true;

		double max = Double.MIN_VALUE;
		ArrayList<Integer> appoggio = ValueListOfImmagini(data, contr);
		for (int i = 0; i < appoggio.size(); i++) {
			if (appoggio.get(i) > max)
				max = appoggio.get(i);
		}
		return max;
	}

	/**
	 * Description of the method calcoloMin.
	 * 
	 * @param data
	 * @param campo
	 */
	public double calcoloMin(ArrayList<RecordInfo> data, String campo) {
		// Start of user code for method calcoloMin
		// End of user code
		boolean contr = false;
		if (campo.equals("larghezza"))
			contr = true;

		double min = Double.MAX_VALUE;
		ArrayList<Integer> appoggio = ValueListOfImmagini(data, contr);
		for (int i = 0; i < appoggio.size(); i++) {
			if (appoggio.get(i) < min)
				min = appoggio.get(i);
		}
		return min;
	}

	/**
	 * Description of the method calcoloVar.
	 * 
	 * @param data
	 * @param field
	 */
	public double calcoloVar(ArrayList<RecordInfo> data, String field) {
		// Start of user code for method calcoloVar
		// End of user code
		double media = calcoloMedia(data, field);
		boolean contr = false;
		//int ne = 0;
		if (field.equals("larghezza"))
			contr = true;
		double varianza = 0;

		ArrayList<Integer> appoggio = ValueListOfImmagini(data, contr);
		for (int i=0; i<appoggio.size();i++) {
			varianza += Math.pow((appoggio.get(i) + media), 2);
		}
		return varianza / appoggio.size();
	}

	public ArrayList<Integer> ValueListOfImmagini(ArrayList<RecordInfo> data,boolean truewithaltezza){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i =0; i < data.size();i++) {
			for(int j=0;j<data.get(i).getImmagini().size();j++)
				if(truewithaltezza)
					result.add(data.get(i).getImmagini().get(j).getAltezza());
				else
					result.add(data.get(i).getImmagini().get(j).getLarghezza());
		}
		return result;
	}

	// Start of user code (user defined methods for CreazioneStats)

	// End of user code
}

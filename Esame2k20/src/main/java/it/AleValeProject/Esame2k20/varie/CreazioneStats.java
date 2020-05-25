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

		return calcoloSomma(data, campo) / ValueListOfImmagini(data, campo).size();

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

		double somma = 0;
		for (int i = 0; i < ValueListOfImmagini(data, campo).size(); i++)
			somma += ValueListOfImmagini(data, campo).get(i);
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

		double max = Double.MIN_VALUE;
		ArrayList<Double> appoggio = ValueListOfImmagini(data, campo);
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

		double min = Double.MAX_VALUE;
		ArrayList<Double> appoggio = ValueListOfImmagini(data, campo);
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
	public double calcoloVar(ArrayList<RecordInfo> data, String campo) {
		// Start of user code for method calcoloVar
		// End of user code
		double media = calcoloMedia(data, campo);
		double varianza = 0;

		ArrayList<Double> appoggio = ValueListOfImmagini(data, campo);
		for (int i=0; i<appoggio.size();i++) {
			varianza += Math.pow((appoggio.get(i) + media), 2);
		}
		return varianza / appoggio.size();
	}

	public ArrayList<Double> ValueListOfImmagini(ArrayList<RecordInfo> data, String campo){
		ArrayList<Double> result = new ArrayList<Double>();
		for(int i =0; i < data.size();i++) {
			for(int j=0;j<data.get(i).getImmagini().size();j++)
				if(campo.equals("altezza"))
					result.add((double)data.get(i).getImmagini().get(j).getAltezza());
				else if(campo.equals("larghezza"))
					result.add((double)data.get(i).getImmagini().get(j).getLarghezza());
				else if(campo.equals("megapixel"))
					result.add(data.get(i).getImmagini().get(j).getMegapixel());
		}
		return result;
	}

	// Start of user code (user defined methods for CreazioneStats)

	// End of user code
}

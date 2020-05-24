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
	 * @param data 
	 * @param campo 
	 */
	public double calcoloMedia(ArrayList<RecordInfo> data, String campo) {
		boolean contr=false;
		int ne=0;
		if(campo.equals("larghezza"))
			contr=true;
		double somma=0;
		RecordInfo x = new RecordInfo();
		Immagine imm;
		ArrayList<Immagine> app;
		for(int i =0; i < data.size();i++) {
			x=data.get(i);
			app=x.getImmagini();
			for(int j =0;j<x.getImmagini().size();j++) {
				imm=app.get(j);
				ne++;
				if(contr)
					somma=imm.getLarghezza();
				else
					somma=imm.getAltezza();
			}
				
		}
		return somma/ne;
		
	}
	
	
	
	
	/**
	 * Description of the method calcoloSomma.
	 * @param data 
	 * @param campo 
	 */
	public double calcoloSomma(ArrayList<RecordInfo> data, String campo) {
		// Start of user code for method calcoloMedia
		// End of user code
		boolean contr=false;
		if(campo.equals("larghezza"))
			contr=true;
		double somma=0;
		RecordInfo x = new RecordInfo();
		Immagine imm;
		ArrayList<Immagine> app;
		for(int i =0; i < data.size();i++) {
			x=data.get(i);
			app=x.getImmagini();
			for(int j =0;j<x.getImmagini().size();j++) {
				imm=app.get(j);
				if(contr)
					somma=imm.getLarghezza();
				else
					somma=imm.getAltezza();
			}
				
		}
		return somma;
	}

	/**
	 * Description of the method calcoloMax.
	 * @param data 
	 * @param campo 
	 */
	public double calcoloMax(ArrayList<RecordInfo> data, String campo) {
		// Start of user code for method calcoloMax
		// End of user code
		boolean contr=false;
		if(campo.equals("larghezza"))
			contr=true;
		double max=0;
		double num=0;
		RecordInfo x = new RecordInfo();
		Immagine imm;
		ArrayList<Immagine> app;
		for(int i =0; i < data.size();i++) {
			x=data.get(i);
			app=x.getImmagini();
			for(int j =0;j<x.getImmagini().size();j++) {
				imm=app.get(j);
				if(contr)
					num=imm.getLarghezza();
				else
					num=imm.getAltezza();
				if(num>max)
					max=num;
			}
				
		}
		return max;
	}

	/**
	 * Description of the method calcoloMin.
	 * @param data 
	 * @param campo 
	 */
	public double calcoloMin(ArrayList<RecordInfo> data, String campo) {
		// Start of user code for method calcoloMin
		// End of user code
		boolean contr=false;
		if(campo.equals("larghezza"))
			contr=true;
		double min=Double.MAX_VALUE;
		double num=0;
		RecordInfo x = new RecordInfo();
		Immagine imm;
		ArrayList<Immagine> app;
		for(int i =0; i < data.size();i++) {
			x=data.get(i);
			app=x.getImmagini();
			for(int j =0;j<x.getImmagini().size();j++) {
				imm=app.get(j);
				if(contr)
					num=imm.getLarghezza();
				else
					num=imm.getAltezza();
				if(num<min)
					min=num;
			}
				
		}
		return min;
	}


	/**
	 * Description of the method calcoloVar.
	 * @param data 
	 * @param field 
	 */
	public double calcoloVar(ArrayList<RecordInfo> data, String field) {
		// Start of user code for method calcoloVar
		// End of user code
		double media = calcoloMedia(data, field);
		boolean contr=false;
		int ne=0;
		if(field.equals("larghezza"))
			contr=true;
		double somma=0;
		RecordInfo x = new RecordInfo();
		Immagine imm;
		ArrayList<Immagine> app;
		for(int i =0; i < data.size();i++) {
			x=data.get(i);
			app=x.getImmagini();
			for(int j =0;j<x.getImmagini().size();j++) {
				imm=app.get(j);
				ne++;
				if(contr)
					somma=Math.pow((imm.getLarghezza()+media),2);
				else
					somma=Math.pow((imm.getAltezza()+media),2);
			}
				
		}
		return somma/ne;
		
	}

	// Start of user code (user defined methods for CreazioneStats)

	// End of user code
}

package it.AleValeProject.Esame2k20.varie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import it.AleValeProject.Esame2k20.model.CampoMetaD;

public class MetaData {

	/**
	 * Description of the property metaDati.
	 */
	private ArrayList<CampoMetaD> metaDati = new ArrayList<CampoMetaD>();

	// Start of user code (user defined attributes for MetaData)

	// End of user code

	/**
	 * The constructor.
	 */
	public MetaData() {
		// Start of user code constructor for MetaData)
		CampoMetaD campi;
		BufferedReader lettore;
		int i=0;
		int j=0;
		String app;
		String[] metaDatiImportati = new String[50];
		try {
			lettore = new BufferedReader(new FileReader("MetaData.txt"));
			app = lettore.readLine();
			metaDatiImportati= app.split(",");
			while(j<metaDatiImportati.length) {
				campi = new CampoMetaD();
				campi.setAlias(metaDatiImportati[j]);
				j++;
				campi.setSourceField(metaDatiImportati[j]);
				j++;
				campi.setType(metaDatiImportati[j]);
				i++;
				j++;
				metaDati.add(campi);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// End of user code
	}

	// Start of user code (user defined methods for MetaData)

	// End of user code
	/**
	 * Returns metaDati.
	 * @return metaDati 
	 */
	public ArrayList<CampoMetaD> getMetaDati() {
		return this.metaDati;
	}
}

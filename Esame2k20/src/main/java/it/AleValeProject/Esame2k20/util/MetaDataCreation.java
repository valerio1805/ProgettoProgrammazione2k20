package it.AleValeProject.Esame2k20.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import it.AleValeProject.Esame2k20.model.SingleMetaData;

public class MetaDataCreation {

	/**
	 * Description of the property metaDati.
	 */
	private ArrayList<SingleMetaData> metaDati = new ArrayList<SingleMetaData>();

	// Start of user code (user defined attributes for MetaData)

	// End of user code

	/**
	 * The constructor.
	 */
	public MetaDataCreation() {
		// Start of user code constructor for MetaData)
		SingleMetaData campi;
		BufferedReader lettore;
		int j=0;
		try {
			lettore = new BufferedReader(new FileReader("MetaData.txt"));
			String[] metaDatiImportati= lettore.readLine().split(",");
			while(j<metaDatiImportati.length) {
				campi = new SingleMetaData();
				campi.setAlias(metaDatiImportati[j]);
				j++;
				campi.setSourceField(metaDatiImportati[j]);
				j++;
				campi.setType(metaDatiImportati[j]);
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
	public ArrayList<SingleMetaData> getMetaDati() {
		return this.metaDati;
	}
}
package it.AleValeProject.Esame2k20.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleMetadata;
/**
 * The class that creatas all the metadata to display
 * @author valeAle;
 *
 */

public class MetadataCreation {

	/**
	 * The array of the single Metadata
	 */
	private ArrayList<SingleMetadata> metadata = new ArrayList<SingleMetadata>();

	/**
	 * The constructor. Where the array is built, fetching the metadata from a file.
	 */
	public MetadataCreation() {
		
		//how this function work is very similar to the function that is contained in InstructionCreation
		
		SingleMetadata toAdd;
		BufferedReader reader;
		int j=0;
		try {
			
			reader = new BufferedReader(new FileReader("Metadata.txt"));
			String[] metadataImported= reader.readLine().split(",");
			while(j<metadataImported.length) {
				toAdd = new SingleMetadata();
				toAdd.setAlias(metadataImported[j]);
				j++;
				toAdd.setSourceField(metadataImported[j]);
				j++;
				toAdd.setType(metadataImported[j]);
				j++;
				metadata.add(toAdd);
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Returns metadata.
	 * @return metadata 
	 */
	public ArrayList<SingleMetadata> getMetadata() {
		return this.metadata;
	}
}

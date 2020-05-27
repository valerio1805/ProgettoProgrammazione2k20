package it.AleValeProject.Esame2k20.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleMetaData;
import it.AleValeProject.Esame2k20.model.SingleInstruction;

public class InstructionCreation {

	/**
	 * Description of the property librettoDelleIstruzioni.
	 */
	private ArrayList<SingleInstruction> librettoDelleIstruzioni = new ArrayList<SingleInstruction>();

	/**
	 * The constructor.
	 */
	public InstructionCreation() {
		SingleInstruction toadd;
		try {
			BufferedReader lettore = new BufferedReader(new FileReader("Istruzioni.txt"));
			String[] tutteLeIstruzioni=lettore.readLine().split("£");
			int j=0;
			while(j<tutteLeIstruzioni.length) {
				toadd = new SingleInstruction();
				toadd.setIntro(tutteLeIstruzioni[j]);
				j++;
				String[] appoggio=tutteLeIstruzioni[j].split(";");
				toadd.setPossibilità(appoggio);
				j++;
				librettoDelleIstruzioni.add(toadd);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the librettoDelleIstruzioni
	 */
	public ArrayList<SingleInstruction> getLibrettoDelleIstruzioni() {
		return librettoDelleIstruzioni;
	}
}

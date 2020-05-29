package it.AleValeProject.Esame2k20.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleMetadata;
import it.AleValeProject.Esame2k20.model.SingleIstruction;

public class InstructionCreation {

	/**
	 * Description of the property istructionsManual.
	 */
	private ArrayList<SingleIstruction> istructionsManual = new ArrayList<SingleIstruction>();

	/**
	 * The constructor.
	 */
	public InstructionCreation() {
		SingleIstruction toadd;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Istruction.txt"));
			String[] allTheIstructions=reader.readLine().split("£");
			int j=0;
			while(j<allTheIstructions.length) {
				toadd = new SingleIstruction();
				toadd.setIntroduction(allTheIstructions[j]);
				j++;
				String[] support=allTheIstructions[j].split(";");
				toadd.setPossibility(support);
				j++;
				istructionsManual.add(toadd);
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
	 * @return the istructionsManual
	 */
	public ArrayList<SingleIstruction> getInstructionsManual() {
		return istructionsManual;
	}
}

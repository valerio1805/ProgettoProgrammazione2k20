package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

/**
 * The class that describes an instruction
 * @author Di Biase Alessandro, Donnini Valerio
 *
 */
public class SingleInstruction {
	/**
	 * The introduction of the instruction.
	 */
	private String introduction = "";

	/**
	 * An array with the different possibilities.
	 */
	private ArrayList<String> possibilities = new ArrayList<String>();

	/**
	 * Getter for variable introduction
	 * @return introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * Setter for variable introduction
	 * @param intro the intro to set
	 */
	 public void setIntroduction(String intro) {
		this.introduction = intro;
	}

	/**
	 * Getter for the ArrayList possibilities
	 * @return possibilities
	 */
	public ArrayList<String> getPossibility() {
		return possibilities;
	}

	/**
	 * Setter for the ArrayList possibilities
	 * @param possibility to add at the end of the array
	 */
	 public void setPossibility(String[] possibility) {
		for(int i=0;i<possibility.length;i++)
			this.possibilities.add(possibility[i]);
	}
	
	
}

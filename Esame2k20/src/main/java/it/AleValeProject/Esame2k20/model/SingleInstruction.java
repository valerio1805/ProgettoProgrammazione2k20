package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

/**
 * The class that describes an instruction
 * @author valeAle;
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
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param intro the intro to set
	 */
	 public void setIntroduction(String intro) {
		this.introduction = intro;
	}

	/**
	 * @return the possibilities
	 */
	public ArrayList<String> getPossibility() {
		return possibilities;
	}

	/**
	 * @param possibility to add a possibility to the array
	 */
	 public void setPossibility(String[] possibility) {
		for(int i=0;i<possibility.length;i++)
			this.possibilities.add(possibility[i]);
	}
	
	
}

package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

public class SingleInstruction {
	/**
	 * Description of the property intro.
	 */
	private String introduction = "";

	/**
	 * Description of the property possibilità.
	 */
	private ArrayList<String> possibilities = new ArrayList<String>();

	/**
	 * @return the intro
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
	 * @return the possibilità
	 */
	public ArrayList<String> getPossibility() {
		return possibilities;
	}

	/**
	 * @param possibility the possibilità to set
	 */
	 public void setPossibility(String[] possibility) {
		for(int i=0;i<possibility.length;i++)
			this.possibilities.add(possibility[i]);
	}
	
	
}

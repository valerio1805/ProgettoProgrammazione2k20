package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

public class SingleInstruction {
	/**
	 * Description of the property alias.
	 */
	private String intro = "";

	/**
	 * Description of the property sourceField.
	 */
	private ArrayList<String> possibilità = new ArrayList<String>();

	/**
	 * @return the intro
	 */
	public String getIntroduction() {
		return intro;
	}

	/**
	 * @param intro the intro to set
	 */
	public void setIntroduction(String intro) {
		this.intro = intro;
	}

	/**
	 * @return the possibilità
	 */
	public ArrayList<String> getPossibility() {
		return possibilità;
	}

	/**
	 * @param possibility the possibilità to set
	 */
	public void setPossibility(String[] possibility) {
		for(int i=0;i<possibility.length;i++)
			this.possibilità.add(possibility[i]);
	}
	
	
}

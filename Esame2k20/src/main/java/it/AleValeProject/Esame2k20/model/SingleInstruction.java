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
	public String getIntro() {
		return intro;
	}

	/**
	 * @param intro the intro to set
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/**
	 * @return the possibilità
	 */
	public ArrayList<String> getPossibilità() {
		return possibilità;
	}

	/**
	 * @param possibilità the possibilità to set
	 */
	public void setPossibilità(String[] possibilità) {
		for(int i=0;i<possibilità.length;i++)
			this.possibilità.add(possibilità[i]);
	}
	
	
}

package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

public class SingleIstruction {
	/**
	 * Description of the property intro.
	 */
	private String introduzione = "";

	/**
	 * Description of the property possibilità.
	 */
	private ArrayList<String> possibilità = new ArrayList<String>();

	/**
	 * @return the intro
	 */
	public String getIntroduction() {
		return introduzione;
	}

	/**
	 * @param intro the intro to set
	 */
	 public void setIntroduction(String intro) {
		this.introduzione = intro;
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

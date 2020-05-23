package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

public class Filter2 {

	/**
	 * Description of the property campo.
	 */
	private String campo = "";

	/**
	 * Description of the property operatore.
	 */
	private String operatore = "";

	/**
	 * Description of the property valori.
	 */
	private ArrayList<String> valori = new ArrayList<String>();

	// Start of user code (user defined attributes for Filter2)

	// End of user code

	/**
	 * The constructor.
	 */
	public Filter2() {
		// Start of user code constructor for Filter2)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Filter2)

	// End of user code
	/**
	 * Returns campo.
	 * 
	 * @return campo
	 */
	public String getCampo() {
		return this.campo;
	}

	/**
	 * Sets a value to attribute campo.
	 * 
	 * @param newCampo
	 */
	public void setCampo(String newCampo) {
		this.campo = newCampo;
	}

	/**
	 * Returns operatore.
	 * 
	 * @return operatore
	 */
	public String getOperatore() {
		return this.operatore;
	}

	/**
	 * Sets a value to attribute operatore.
	 * 
	 * @param newOperatore
	 */
	public void setOperatore(String newOperatore) {
		this.operatore = newOperatore;
	}

	/**
	 * Returns valori.
	 * 
	 * @return valori
	 */
	public ArrayList<String> getValori() {
		return this.valori;
	}
	/**
	 * Sets a value to attribute valori.
	 * 
	 * @param newValori
	 */
	public void setValori (String[] newValori){
		for(String toadd : newValori)
		this.valori.add(toadd);
	}
}

/**
 * 
 */
package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

/**
 * @author vale
 *
 */
public class Record {

	/**
	 * Description of the property id.
	 */
	private Integer id = Integer.valueOf(0);

	/**
	 * Description of the property idAutore.
	 */
	private Integer idAutore = Integer.valueOf(0);

	/**
	 * Description of the property dataCreazione.
	 */
	private String dataCreazione = "";

	/**
	 * Description of the property linguaggio.
	 */
	private String linguaggio = "";

	/**
	 * Description of the property sorgente.
	 */
	private String sorgente = "";

	/**
	 * Description of the property hashtags.
	 */
	private ArrayList<String> hashtags = new ArrayList<String>();

	/**
	 * Description of the property immagini.
	 */
	private ArrayList<Immagine> immagini = new ArrayList<Immagine>();

	// Start of user code (user defined attributes for Record)

	// End of user code

	/**
	 * The constructor.
	 */
	public Record() {
		// Start of user code constructor for Record)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Record)

	// End of user code
	/**
	 * Returns id.
	 * @return id 
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(Integer newId) {
		this.id = newId;
	}

	/**
	 * Returns idAutore.
	 * @return idAutore 
	 */
	public Integer getIdAutore() {
		return this.idAutore;
	}

	/**
	 * Sets a value to attribute idAutore. 
	 * @param newIdAutore 
	 */
	public void setIdAutore(Integer newIdAutore) {
		this.idAutore = newIdAutore;
	}

	/**
	 * Returns dataCreazione.
	 * @return dataCreazione 
	 */
	public String getDataCreazione() {
		return this.dataCreazione;
	}

	/**
	 * Sets a value to attribute dataCreazione. 
	 * @param newDataCreazione 
	 */
	public void setDataCreazione(String newDataCreazione) {
		this.dataCreazione = newDataCreazione;
	}

	/**
	 * Returns linguaggio.
	 * @return linguaggio 
	 */
	public String getLinguaggio() {
		return this.linguaggio;
	}

	/**
	 * Sets a value to attribute linguaggio. 
	 * @param newLinguaggio 
	 */
	public void setLinguaggio(String newLinguaggio) {
		this.linguaggio = newLinguaggio;
	}

	/**
	 * Returns sorgente.
	 * @return sorgente 
	 */
	public String getSorgente() {
		return this.sorgente;
	}

	/**
	 * Sets a value to attribute sorgente. 
	 * @param newSorgente 
	 */
	public void setSorgente(String newSorgente) {
		this.sorgente = newSorgente;
	}

	/**
	 * Returns hashtags.
	 * @return hashtags 
	 */
	public ArrayList<String> getHashtags() {
		return this.hashtags;
	}

	/**
	 * Returns immagini.
	 * @return immagini 
	 */
	public ArrayList<Immagine> getImmagini() {
		return this.immagini;
	}
}

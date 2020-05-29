/**
 * 
 */
package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

/**
 * @author vale
 *
 */
public class SingleRecordInfo {

	/**
	 * Description of the property id.
	 */
	private String id = "";

	/**
	 * Description of the property idAutore.
	 */
	private String idAutore = "";

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
	 * Description of the property text.
	 */
	private String text = "";

	/**
	 * Description of the property hashtags.
	 */
	private ArrayList<String> hashtags = new ArrayList<String>();

	/**
	 * Description of the property immagini.
	 */
	private ArrayList<SingleImage> immagini = new ArrayList<SingleImage>();
	/**
	 * The constructor.
	 */
	public SingleRecordInfo() {
		super();
	}
	/**
	 * Returns id.
	 * @return id 
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(String newId) {
		this.id = newId;
	}

	/**
	 * Returns idAutore.
	 * @return idAutore 
	 */
	public String getIdAutore() {
		return this.idAutore;
	}

	/**
	 * Sets a value to attribute idAutore. 
	 * @param newIdAutore 
	 */
	public void setIdAutore(String newIdAutore) {
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
	 * Returns text.
	 * @return text
	 */
	public String getTest() {
		return this.text;
	}


	public void setText(String text) {
		this.text = text;
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
	public ArrayList<SingleImage> getImmagini() {
		return this.immagini;
	}
	
	public void setHashtag(String s)
	{
		if(!(hashtags.contains(s)))
			hashtags.add(s);
	}
	public void setImmagini(SingleImage imm)
	{
		immagini.add(imm);
	}
}

/**
 * 
 */
package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

/**
 * @author vale
 *
 */
public class RecordInfo {

	/**
	 * Description of the property id.
	 */
	private Double id = Double.valueOf(0);

	/**
	 * Description of the property idAutore.
	 */
	private Double idAutore = Double.valueOf(0);

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
	private ArrayList<Immagine> immagini = new ArrayList<Immagine>();

	// Start of user code (user defined attributes for Record)

	// End of user code

	/**
	 * The constructor.
	 */
	public RecordInfo() {
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
	public Double getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(Double newId) {
		this.id = newId;
	}

	/**
	 * Returns idAutore.
	 * @return idAutore 
	 */
	public Double getIdAutore() {
		return this.idAutore;
	}

	/**
	 * Sets a value to attribute idAutore. 
	 * @param newIdAutore 
	 */
	public void setIdAutore(Double newIdAutore) {
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
	public ArrayList<Immagine> getImmagini() {
		return this.immagini;
	}
	
	public void setHashatg(String s)
	{
		if(!(hashtags.contains(s)))
			hashtags.add(s);
		//else
			//lancioEccezione
	}
	public void setImmagini(Immagine imm)
	{
		immagini.add(imm);
	}

	@Override
	public String toString() {
		String rit="\nRecordInfo\n [id=" + id + ", idAutore=" + idAutore + ", dataCreazione=" + dataCreazione + ", linguaggio="
				+ linguaggio + ", sorgente=" + sorgente + ", text=" + text + ", hashtags=" + hashtags + ", immagini="
				+ immagini + "]";
		
		for(int i =0;i<immagini.size();i++)
			rit+="\n\t"+immagini.get(i).toString();
		return rit;
	}
	
	
}

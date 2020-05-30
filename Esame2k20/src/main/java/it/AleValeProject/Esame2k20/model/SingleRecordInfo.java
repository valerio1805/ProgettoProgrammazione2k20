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
	private String idAuthor = "";

	/**
	 * Description of the property dataCreazione.
	 */
	private String dataCreation = "";

	/**
	 * Description of the property linguaggio.
	 */
	private String language = "";

	/**
	 * Description of the property sorgente.
	 */
	private String source = "";
	
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
	private ArrayList<SingleImage> images = new ArrayList<SingleImage>();
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
	public String getIdAuthor() {
		return this.idAuthor;
	}

	/**
	 * Sets a value to attribute idAutore. 
	 * @param newIdAuthor 
	 */
	public void setIdAuthor(String newIdAuthor) {
		this.idAuthor = newIdAuthor;
	}

	/**
	 * Returns dataCreazione.
	 * @return dataCreazione 
	 */
	public String getDataCreation() {
		return this.dataCreation;
	}
	
	/**
	 * Returns text.
	 * @return text
	 */
	public String getTest() {
		return this.text;
	}


	public void setText(String newText) {
		this.text = newText;
	}
	
	/**
	 * Sets a value to attribute dataCreazione. 
	 * @param newDataCreazione 
	 */
	public void setDataCreation(String newDataCreazione) {
		this.dataCreation = newDataCreazione;
	}

	/**
	 * Returns linguaggio.
	 * @return linguaggio 
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * Sets a value to attribute linguaggio. 
	 * @param newLanguage 
	 */
	public void setLanguage(String newLanguage) {
		this.language = newLanguage;
	}

	/**
	 * Returns sorgente.
	 * @return sorgente 
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * Sets a value to attribute sorgente. 
	 * @param newSorgente 
	 */
	public void setSource(String newSource) {
		this.source = newSource;
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
	public ArrayList<SingleImage> getImages() {
		return this.images;
	}
	
	public void setHashtag(String s)
	{
		if(!(hashtags.contains(s)))
			hashtags.add(s);
	}
	public void setImages(SingleImage newImage)
	{
		images.add(newImage);
	}
}

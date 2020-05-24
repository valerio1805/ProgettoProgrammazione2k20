package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;
import java.util.HashMap;

import it.AleValeProject.Esame2k20.varie.CreazioneStats;

public class Stats {

	/**
	 * Description of the property media.
	 */
	private String campo;

	private HashMap<String, Double> stat = new HashMap<String, Double>();
	private CreazioneStats creator = new CreazioneStats();;
	
	public Stats(ArrayList<RecordInfo> rec,String field) {
		this.campo=field;
		stat.put("min", creator.calcoloMax(rec, this.campo));
		stat.put("max", creator.calcoloMin(rec, this.campo));
		stat.put("somma", creator.calcoloSomma(rec, this.campo));
		stat.put("media", creator.calcoloMedia(rec, this.campo));
		stat.put("varianza", creator.calcoloVar(rec, this.campo));
	}
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public HashMap<String, Double> getStat() {
		return stat;
	}
	public void setStat(HashMap<String, Double> stat) {
		this.stat = stat;
	}
	
	

//	private double media = 0D;
//
//	/**
//	 * Description of the property varianza.
//	 */
//	private double varianza = 0D;
//
//	/**
//	 * Description of the property min.
//	 */
//	private Integer min = Integer.valueOf(0);
//
//	/**
//	 * Description of the property max.
//	 */
//	private Integer max = Integer.valueOf(0);
//
//	/**
//	 * Description of the property field.
//	 */
//	private String field = "";
//
//	// Start of user code (user defined attributes for Stats)
//
//	// End of user code
//
//	/**
//	 * The constructor.
//	 */
//	public Stats() {
//		// Start of user code constructor for Stats)
//		super();
//		// End of user code
//	}
//
//	// Start of user code (user defined methods for Stats)
//
//	// End of user code
//	/**
//	 * Returns media.
//	 * @return media 
//	 */
//	public double getMedia() {
//		return this.media;
//	}
//
//	/**
//	 * Sets a value to attribute media. 
//	 * @param newMedia 
//	 */
//	public void setMedia(double newMedia) {
//		this.media = newMedia;
//	}
//
//	/**
//	 * Returns varianza.
//	 * @return varianza 
//	 */
//	public double getVarianza() {
//		return this.varianza;
//	}
//
//	/**
//	 * Sets a value to attribute varianza. 
//	 * @param newVarianza 
//	 */
//	public void setVarianza(double newVarianza) {
//		this.varianza = newVarianza;
//	}
//
//	/**
//	 * Returns min.
//	 * @return min 
//	 */
//	public Integer getMin() {
//		return this.min;
//	}
//
//	/**
//	 * Sets a value to attribute min. 
//	 * @param newMin 
//	 */
//	public void setMin(Integer newMin) {
//		this.min = newMin;
//	}
//
//	/**
//	 * Returns max.
//	 * @return max 
//	 */
//	public Integer getMax() {
//		return this.max;
//	}
//
//	/**
//	 * Sets a value to attribute max. 
//	 * @param newMax 
//	 */
//	public void setMax(Integer newMax) {
//		this.max = newMax;
//	}
//
//	/**
//	 * Returns field.
//	 * @return field 
//	 */
//	public String getField() {
//		return this.field;
//	}
//
//	/**
//	 * Sets a value to attribute field. 
//	 * @param newField 
//	 */
//	public void setField(String newField) {
//		this.field = newField;
//	}
	
}

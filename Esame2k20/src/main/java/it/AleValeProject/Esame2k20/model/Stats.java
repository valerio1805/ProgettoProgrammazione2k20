package it.AleValeProject.Esame2k20.model;

public class Stats {

	/**
	 * Description of the property media.
	 */
	private double media = 0D;

	/**
	 * Description of the property varianza.
	 */
	private double varianza = 0D;

	/**
	 * Description of the property min.
	 */
	private Integer min = Integer.valueOf(0);

	/**
	 * Description of the property max.
	 */
	private Integer max = Integer.valueOf(0);

	/**
	 * Description of the property field.
	 */
	private String field = "";

	// Start of user code (user defined attributes for Stats)

	// End of user code

	/**
	 * The constructor.
	 */
	public Stats() {
		// Start of user code constructor for Stats)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Stats)

	// End of user code
	/**
	 * Returns media.
	 * @return media 
	 */
	public double getMedia() {
		return this.media;
	}

	/**
	 * Sets a value to attribute media. 
	 * @param newMedia 
	 */
	public void setMedia(double newMedia) {
		this.media = newMedia;
	}

	/**
	 * Returns varianza.
	 * @return varianza 
	 */
	public double getVarianza() {
		return this.varianza;
	}

	/**
	 * Sets a value to attribute varianza. 
	 * @param newVarianza 
	 */
	public void setVarianza(double newVarianza) {
		this.varianza = newVarianza;
	}

	/**
	 * Returns min.
	 * @return min 
	 */
	public Integer getMin() {
		return this.min;
	}

	/**
	 * Sets a value to attribute min. 
	 * @param newMin 
	 */
	public void setMin(Integer newMin) {
		this.min = newMin;
	}

	/**
	 * Returns max.
	 * @return max 
	 */
	public Integer getMax() {
		return this.max;
	}

	/**
	 * Sets a value to attribute max. 
	 * @param newMax 
	 */
	public void setMax(Integer newMax) {
		this.max = newMax;
	}

	/**
	 * Returns field.
	 * @return field 
	 */
	public String getField() {
		return this.field;
	}

	/**
	 * Sets a value to attribute field. 
	 * @param newField 
	 */
	public void setField(String newField) {
		this.field = newField;
	}
}

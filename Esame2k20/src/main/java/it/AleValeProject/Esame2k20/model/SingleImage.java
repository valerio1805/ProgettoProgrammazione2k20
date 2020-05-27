package it.AleValeProject.Esame2k20.model;

public class SingleImage {

	/**
	 * Description of the property width.
	 */
	private Integer width = Integer.valueOf(0);

	/**
	 * Description of the property height.
	 */
	private Integer height = Integer.valueOf(0);
	
	/**
	 * Description of the property megapixel.
	 */
	private Double megapixel = Double.valueOf(0);

	/**
	 * Description of the property type.
	 */
	private String type = "";

	/**
	 * Description of the property idImage.
	 */
	private String idImage = "";

	/**
	 * Description of the property url.
	 */
	private String url = "";

	// Start of user code (user defined attributes for Immagine)

	// End of user code

	/**
	 * The constructor.
	 */
	public SingleImage() {
		// Start of user code constructor for Immagine)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Immagine)

	// End of user code
	/**
	 * Returns width.
	 * @return width 
	 */
	public Integer getLarghezza() {
		return this.width;
	}

	/**
	 * Sets a value to attribute larghezza. 
	 * @param newLarghezza 
	 */
	public void setLarghezza(Integer newLarghezza) {
		this.width = newLarghezza;
	}

	/**
	 * Returns altezza.
	 * @return altezza 
	 */
	public Integer getAltezza() {
		return this.height;
	}

	/**
	 * Sets a value to attribute altezza. 
	 * @param newAltezza 
	 */
	public void setAltezza(Integer newAltezza) {
		this.height = newAltezza;
	}
	
	/**
	 * @return the megapixel
	 */
	public Double getMegapixel() {
		return megapixel;
	}

	/**
	 * @param newMegapixel the megapixel to set
	 */
	public void setMegapixel(Double newMegapixel) {
		this.megapixel = newMegapixel;
	}
	/**
	 * Returns tipo.
	 * @return tipo 
	 */
	public String getTipo() {
		return this.type;
	}

	/**
	 * Sets a value to attribute tipo. 
	 * @param newTipo 
	 */
	public void setTipo(String newTipo) {
		this.type = newTipo;
	}

	/**
	 * Returns idImmagine.
	 * @return idImmagine 
	 */
	public String getIdImmagine() {
		return this.idImage;
	}

	/**
	 * Sets a value to attribute idImmagine. 
	 * @param newIdImmagine 
	 */
	public void setIdImmagine(String newIdImmagine) {
		this.idImage = newIdImmagine;
	}

	/**
	 * Returns url.
	 * @return url 
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets a value to attribute url. 
	 * @param newUrl 
	 */
	public void setUrl(String newUrl) {
		this.url = newUrl;
	}

	@Override
	public String toString() {
		return "[larghezza=" + width + ", altezza=" + height + ", tipo=" + type + ", idImmagine="
				+ idImage + ", url=" + url + "]";
	}
	
	
}

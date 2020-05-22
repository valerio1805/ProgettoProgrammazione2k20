package it.AleValeProject.Esame2k20.model;

public class Immagine {

	/**
	 * Description of the property larghezza.
	 */
	private Integer larghezza = Integer.valueOf(0);

	/**
	 * Description of the property altezza.
	 */
	private Integer altezza = Integer.valueOf(0);

	/**
	 * Description of the property tipo.
	 */
	private String tipo = "";

	/**
	 * Description of the property idImmagine.
	 */
	private Integer idImmagine = Integer.valueOf(0);

	/**
	 * Description of the property url.
	 */
	private String url = "";

	// Start of user code (user defined attributes for Immagine)

	// End of user code

	/**
	 * The constructor.
	 */
	public Immagine() {
		// Start of user code constructor for Immagine)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Immagine)

	// End of user code
	/**
	 * Returns larghezza.
	 * @return larghezza 
	 */
	public Integer getLarghezza() {
		return this.larghezza;
	}

	/**
	 * Sets a value to attribute larghezza. 
	 * @param newLarghezza 
	 */
	public void setLarghezza(Integer newLarghezza) {
		this.larghezza = newLarghezza;
	}

	/**
	 * Returns altezza.
	 * @return altezza 
	 */
	public Integer getAltezza() {
		return this.altezza;
	}

	/**
	 * Sets a value to attribute altezza. 
	 * @param newAltezza 
	 */
	public void setAltezza(Integer newAltezza) {
		this.altezza = newAltezza;
	}

	/**
	 * Returns tipo.
	 * @return tipo 
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Sets a value to attribute tipo. 
	 * @param newTipo 
	 */
	public void setTipo(String newTipo) {
		this.tipo = newTipo;
	}

	/**
	 * Returns idImmagine.
	 * @return idImmagine 
	 */
	public Integer getIdImmagine() {
		return this.idImmagine;
	}

	/**
	 * Sets a value to attribute idImmagine. 
	 * @param newIdImmagine 
	 */
	public void setIdImmagine(Integer newIdImmagine) {
		this.idImmagine = newIdImmagine;
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
}

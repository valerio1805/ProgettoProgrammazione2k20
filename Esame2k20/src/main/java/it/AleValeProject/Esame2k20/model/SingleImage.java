package it.AleValeProject.Esame2k20.model;

/**
 * The class thatr describes an image
 * @author vale&ale
 *
 */
public class SingleImage {

	/**
	 * The witdh of the image.
	 */
	private Integer width = Integer.valueOf(0);

	/**
	 * The height of the image.
	 */
	private Integer height = Integer.valueOf(0);
	
	/**
	 * The dimensione of the image.
	 */
	private Double megapixel = Double.valueOf(0);

	/**
	 * The type of the media.
	 */
	private String type = "";

	/**
	 * The id of the image.
	 */
	private String idImage = "";

	/**
	 * The url where is located the image.
	 */
	private String url = "";
	/**
	 * Returns width.
	 * @return width 
	 */
	public Integer getWidth() {
		return this.width;
	}

	/**
	 * Sets a value to attribute width. 
	 * @param newWidth 
	 */
	public void setWidth(Integer newWidth) {
		this.width = newWidth;
	}

	/**
	 * Returns height.
	 * @return height 
	 */
	public Integer getHeight() {
		return this.height;
	}

	/**
	 * Sets a value to attribute height. 
	 * @param newHeight 
	 */
	public void SetHeight(Integer newHeight) {
		this.height = newHeight;
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
	 * Returns type.
	 * @return type 
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets a value to attribute type. 
	 * @param newType 
	 */
	public void setType(String newType) {
		this.type = newType;
	}

	/**
	 * Returns idImage.
	 * @return idImage 
	 */
	public String getIdImage() {
		return this.idImage;
	}

	/**
	 * Sets a value to attribute idImage. 
	 * @param newIdImage 
	 */
	public void setIdImage(String newIdImage) {
		this.idImage = newIdImage;
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

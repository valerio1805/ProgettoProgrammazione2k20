package it.AleValeProject.Esame2k20.model;

/**
 * The class that describes a metadata
 * @author valeAle;
 *
 */

public class SingleMetadata {

	/**
	 * The name of the variable used in the program.
	 */
	private String alias = "";

	/**
	 * The extended name of the field.
	 */
	private String sourceField = "";

	/**
	 * The type of the field.
	 */
	private String type = "";

	/**
	 * Returns alias.
	 * @return alias 
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * Sets a value to attribute alias. 
	 * @param newAlias 
	 */
	public void setAlias(String newAlias) {
		this.alias = newAlias;
	}

	/**
	 * Returns sourceField.
	 * @return sourceField 
	 */
	public String getSourceField() {
		return this.sourceField;
	}

	/**
	 * Sets a value to attribute sourceField. 
	 * @param newSourceField 
	 */
	public void setSourceField(String newSourceField) {
		this.sourceField = newSourceField;
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

}

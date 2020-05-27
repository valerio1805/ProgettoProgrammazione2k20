package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

public class SingleFilter {

	/**
	 * Description of the property field.
	 */
	private String field = "";

	/**
	 * Description of the property operator.
	 */
	private String operator = "";

	/**
	 * Description of the property value.
	 */
	private ArrayList<String> values = new ArrayList<String>();

	// Start of user code (user defined attributes for Filter2)

	// End of user code

	/**
	 * The constructor.
	 */
	public SingleFilter() {
		// Start of user code constructor for Filter2)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Filter2)

	// End of user code
	/**
	 * Returns field.
	 * 
	 * @return field
	 */
	public String getField() {
		return this.field;
	}

	/**
	 * Sets a value to attribute field.
	 * 
	 * @param newField
	 */
	public void setField(String newField) {
		this.field = newField;
	}

	/**
	 * Returns operator.
	 * 
	 * @return operator
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * Sets a value to attribute operator.
	 * 
	 * @param newOperator
	 */
	public void setOperator(String newOperator) {
		this.operator = newOperator;
	}

	/**
	 * Returns values.
	 * 
	 * @return values
	 */
	public ArrayList<String> getValues() {
		return this.values;
	}
	/**
	 * Sets a value to attribute values.
	 * 
	 * @param newValori
	 */
	public void setValues (String[] newValues){
		for(String toadd : newValues)
		this.values.add(toadd);
	}
}

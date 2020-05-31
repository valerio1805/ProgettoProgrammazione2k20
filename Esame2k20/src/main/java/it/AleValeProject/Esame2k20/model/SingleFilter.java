package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

/**
 * The class that describes a filter 
 * @author valeAle;
 *
 */
public class SingleFilter {

	/**
	 * The field added by the user.
	 */
	private String field = "";

	/**
	 * The operator added by the user.
	 */
	private String operator = "";

	/**
	 * The values added by the user.
	 */
	private ArrayList<String> values = new ArrayList<String>();
	
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
	 * @param newValues
	 */
	public void setValues (String[] newValues){
		for(String toadd : newValues)
		this.values.add(toadd);
	}
}

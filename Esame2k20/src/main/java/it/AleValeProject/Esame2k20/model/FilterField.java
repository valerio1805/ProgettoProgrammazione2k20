package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

public class FilterField {

	/**
	 * Description of the property macroOperatore.
	 */
	private String macroOperatore = "";

	/**
	 * Description of the property tuttiIFiltri.
	 */
	private ArrayList<Filter2> tuttiIFiltri = new ArrayList<Filter2>();

	// Start of user code (user defined attributes for FilterField)

	// End of user code

	/**
	 * The constructor.
	 */
	public FilterField() {
		// Start of user code constructor for FilterField)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for FilterField)

	// End of user code
	/**
	 * Returns macroOperatore.
	 * @return macroOperatore 
	 */
	public String getMacroOperatore() {
		return this.macroOperatore;
	}

	/**
	 * Sets a value to attribute macroOperatore. 
	 * @param newMacroOperatore 
	 */
	public void setMacroOperatore(String newMacroOperatore) {
		this.macroOperatore = newMacroOperatore;
	}

	/**
	 * Returns tuttiIFiltri.
	 * @return tuttiIFiltri 
	 */
	public ArrayList<Filter2> getTuttiIFiltri() {
		return this.tuttiIFiltri;
	}
	
}

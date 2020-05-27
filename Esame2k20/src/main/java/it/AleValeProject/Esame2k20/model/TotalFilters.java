package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

public class TotalFilters {

	/**
	 * Description of the property macroOperatore.
	 */
	private String macroOperatore = "";

	/**
	 * Description of the property tuttiIFiltri.
	 */
	private ArrayList<SingleFilter> tuttiIFiltri = new ArrayList<SingleFilter>();

	// Start of user code (user defined attributes for FilterField)

	// End of user code

	/**
	 * The constructor.
	 */
	public TotalFilters() {
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
	public ArrayList<SingleFilter> getTuttiIFiltri() {
		return this.tuttiIFiltri;
	}
	/**
	 * Adds a value to ArrayList tuttiIFiltri. 
	 * @param newFilter2
	 */
	public void setTuttiIFiltri(SingleFilter newFilter2) {
		this.tuttiIFiltri.add(newFilter2);
	}
}

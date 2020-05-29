package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

public class TotalFilters {

	/**
	 * Description of the property macroOperatore.
	 */
	private String macroOperator = "";

	/**
	 * Description of the property tuttiIFiltri.
	 */
	private ArrayList<SingleFilter> allFilters = new ArrayList<SingleFilter>();

	/**
	 * Returns macroOperator.
	 * @return macroOperator 
	 */
	public String getMacroOperator() {
		return this.macroOperator;
	}

	/**
	 * Sets a value to attribute macroOperator. 
	 * @param newMacroOperator 
	 */
	public void setMacroOperator(String newMacroOperator) {
		this.macroOperator = newMacroOperator;
	}

	/**
	 * Returns allFilters.
	 * @return allFilters 
	 */
	public ArrayList<SingleFilter> getAllFilters() {
		return this.allFilters;
	}
	/**
	 * Adds a value to ArrayList allFilters. 
	 * @param newSingleFilter
	 */
	public void setAllFilters(SingleFilter newSingleFilter) {
		this.allFilters.add(newSingleFilter);
	}
}

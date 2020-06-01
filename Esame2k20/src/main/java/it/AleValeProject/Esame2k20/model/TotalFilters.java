package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;

/**
 * The class that describe totally a filter, with is SingleFilter and is macroOperator
 * @author Di Biase Alessandro, Donnini Valerio
 *
 */
public class TotalFilters {

	/**
	 * The macro operator of the TotalFilters.
	 */
	private String macroOperator = "";

	/**
	 * An ArrayList with all the SingleFilters of the TotalFilters.
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

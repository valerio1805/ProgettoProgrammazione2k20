package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;
import java.util.HashMap;

import it.AleValeProject.Esame2k20.util.StatsCreation;

/**
 * The class that manages the stats
 * @author vale&ale
 *
 */
public class Stats extends StatsCreation{

	/**
	 * The number of the examined images. 
	 */
	private int examinedImages;
	/**
	 * The field of what the stats where calculated
	 */
	private String statsField;

	/**
	 * An hashmap to contain the name of the stat and the result calculated
	 */
	private HashMap<String, Double> statistics = new HashMap<String, Double>();
	
	/**
	 * The constructor of the class; it inizialize the hashamap calculating the different stats with the right records
	 * @param recordToPass ArrayList that are used to calculate the stats
	 * @param fieldToPass field passed
	 */
	public Stats(ArrayList<SingleRecordInfo> recordToPass,String fieldToPass) {
		this.statsField=fieldToPass;
		ArrayList<Double> support = ValueListOfImages(recordToPass, this.statsField);
		examinedImages=support.size();
		
		//filling the HashMap "statistic" with the different stats of a particular field, calculated on the images contained in the records passed
		statistics.put("min", ComputeMin(recordToPass, this.statsField));
		statistics.put("max", ComputeMax(recordToPass, this.statsField));
		statistics.put("sum", ComputeSum(recordToPass, this.statsField));
		statistics.put("average", ComputeAverage(recordToPass, this.statsField));
		statistics.put("variance", ComputeVariance(recordToPass, this.statsField));
		statistics.put("standard deviation",Math.pow(ComputeVariance(recordToPass,this.statsField),0.5));
	}
	/**
	 * Getter for the statsField
	 * @return the statsField
	 */
	public String getStatsField() {
		return statsField;
	}
	
	/**
	 * Getter for the hasmap
	 * @return the hasmap with the calculated stats
	 */
	public HashMap<String, Double> getStatistics() {
		return statistics;
	}
	
	/**
	 * Getter for the number of images examinated
	 * @return the number of examined images
	 */
	public int getNumberOfExaminedImages() {
		return examinedImages;
	}
}

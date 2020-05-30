package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;
import java.util.HashMap;

import it.AleValeProject.Esame2k20.util.StatsCreation;

public class Stats extends StatsCreation{

	/**
	 * Description of the property media.
	 */
	private int examinedImages;
	private String statsField;

	private HashMap<String, Double> statistics = new HashMap<String, Double>();
	
	public Stats(ArrayList<SingleRecordInfo> recordToPass,String fieldToPass) {
		this.statsField=fieldToPass;
		ArrayList<Double> support = ValueListOfImages(recordToPass, this.statsField);
		examinedImages=support.size();
		statistics.put("min", ComputeMin(recordToPass, this.statsField));
		statistics.put("max", ComputeMax(recordToPass, this.statsField));
		statistics.put("sum", ComputeSum(recordToPass, this.statsField));
		statistics.put("average", ComputeAverage(recordToPass, this.statsField));
		statistics.put("variance", ComputeVariance(recordToPass, this.statsField));
		statistics.put("standard deviation",Math.pow(ComputeVariance(recordToPass,this.statsField),0.5));
	}
	public String getStatsField() {
		return statsField;
	}
	public HashMap<String, Double> getStatistics() {
		return statistics;
	}
	public int getNumberOfExaminedImages() {
		return examinedImages;
	}
}

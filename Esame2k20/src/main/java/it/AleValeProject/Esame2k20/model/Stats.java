package it.AleValeProject.Esame2k20.model;

import java.util.ArrayList;
import java.util.HashMap;

import it.AleValeProject.Esame2k20.util.StatsCreation;

public class Stats extends StatsCreation{

	/**
	 * Description of the property media.
	 */
	private int ImmaginiEsaminate;
	private String statsField;

	private HashMap<String, Double> statistics = new HashMap<String, Double>();
	
	public Stats(ArrayList<SingleRecordInfo> recordToPass,String fieldToPass) {
		this.statsField=fieldToPass;
		ArrayList<Double> support = ValueListOfImmagini(recordToPass, this.statsField);
		ImmaginiEsaminate=support.size();
		statistics.put("min", ComputeMin(recordToPass, this.statsField));
		statistics.put("max", ComputeMax(recordToPass, this.statsField));
		statistics.put("somma", ComputeSum(recordToPass, this.statsField));
		statistics.put("media", ComputeAverage(recordToPass, this.statsField));
		statistics.put("varianza", ComputeVariance(recordToPass, this.statsField));
		statistics.put("deviazione standard",Math.pow(ComputeVariance(recordToPass,this.statsField),0.5));
	}
	public String getStatsField() {
		return statsField;
	}
	public HashMap<String, Double> getStatistics() {
		return statistics;
	}
	public int getNumberOfExaminedImages() {
		return ImmaginiEsaminate;
	}
}

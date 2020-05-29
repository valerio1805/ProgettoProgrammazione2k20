package it.AleValeProject.Esame2k20.util;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class StatsCreation {
	/**
	 * Description of the method ComputeAverage.
	 * 
	 * @param data
	 * @param field
	 */
	public double ComputeAverage(ArrayList<SingleRecordInfo> data, String field) {

		return ComputeSum(data, field) / ValueListOfImmagini(data, field).size();

	}

	/**
	 * Description of the method ComputeSum.
	 * 
	 * @param data
	 * @param field
	 */
	public double ComputeSum(ArrayList<SingleRecordInfo> data, String field) {
		double sum = 0;
		for (int i = 0; i < ValueListOfImmagini(data, field).size(); i++)
			sum += ValueListOfImmagini(data, field).get(i);
		return sum;
	}

	/**
	 * Description of the method ComputeMax.
	 * 
	 * @param data
	 * @param field
	 */
	public double ComputeMax(ArrayList<SingleRecordInfo> data, String field) {
		double max = Double.MIN_VALUE;
		ArrayList<Double> support = ValueListOfImmagini(data, field);
		for (int i = 0; i < support.size(); i++) {
			if (support.get(i) > max)
				max = support.get(i);
		}
		return max;
	}

	/**
	 * Description of the method ComputeMin.
	 * 
	 * @param data
	 * @param field
	 */
	public double ComputeMin(ArrayList<SingleRecordInfo> data, String field) {
		double min = Double.MAX_VALUE;
		ArrayList<Double> support = ValueListOfImmagini(data, field);
		for (int i = 0; i < support.size(); i++) {
			if (support.get(i) < min)
				min = support.get(i);
		}
		return min;
	}

	/**
	 * Description of the method ComputeVariance.
	 * 
	 * @param data
	 * @param field
	 */
	public double ComputeVariance(ArrayList<SingleRecordInfo> data, String field) {
		double variance = 0;

		ArrayList<Double> support = ValueListOfImmagini(data, field);
		for (int i=0; i<support.size();i++) {
			variance += Math.pow((support.get(i) - ComputeAverage(data, field)), 2);
		}
		return variance / support.size();
	}

	public ArrayList<Double> ValueListOfImmagini(ArrayList<SingleRecordInfo> data, String field){
		ArrayList<Double> result = new ArrayList<Double>();
		for(int i =0; i < data.size();i++) {
			for(int j=0;j<data.get(i).getImmagini().size();j++)
				if(field.equals("altezza"))
					result.add((double)data.get(i).getImmagini().get(j).getHeight());
				else if(field.equals("larghezza"))
					result.add((double)data.get(i).getImmagini().get(j).getWidth());
				else if(field.equals("megapixel"))
					result.add(data.get(i).getImmagini().get(j).getMegapixel());
		}
		return result;
	}
}

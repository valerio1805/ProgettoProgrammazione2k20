package it.AleValeProject.Esame2k20.util;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

/**
 * The class where the stats where made
 * @author Di Biase Alessandro, Donnini Valerio
 *
 */
public class StatsCreation {
	/**
	 * The function that calculate the average.
	 * @param data the Records where to get the information for calcuting the average
	 * @param field the field of which the average has to be calculated
	 * @return the average
	 */
	public double ComputeAverage(ArrayList<SingleRecordInfo> data, String field) {

		return ComputeSum(data, field) / ValueListOfImages(data, field).size();

	}

	/**
	 * The function that calculate the sum.
	 * @param data the Records where to get the information for calcuting the sum
	 * @param field the field of which the sum has to be calculated
	 * @return the sum
	 */
	public double ComputeSum(ArrayList<SingleRecordInfo> data, String field) {
		double sum = 0;
		for (int i = 0; i < ValueListOfImages(data, field).size(); i++)
			sum += ValueListOfImages(data, field).get(i);
		return sum;
	}

	/**
	 * The function that find the max value of the field passed
	 * @param data the Records where to get the information for finding the max value
	 * @param field the field of which the max has to be founded
	 * @return the max
	 */
	public double ComputeMax(ArrayList<SingleRecordInfo> data, String field) {
		double max = Double.MIN_VALUE;
		ArrayList<Double> support = ValueListOfImages(data, field);
		for (int i = 0; i < support.size(); i++) {
			if (support.get(i) > max)
				max = support.get(i);
		}
		return max;
	}

	/**
	 * The function that find the min value of the field passed
	 * @param data the Records where to get the information for finding the min value
	 * @param field the field of which the min has to be founded
	 * @return the min
	 */
	public double ComputeMin(ArrayList<SingleRecordInfo> data, String field) {
		double min = Double.MAX_VALUE;
		ArrayList<Double> support = ValueListOfImages(data, field);
		for (int i = 0; i < support.size(); i++) {
			if (support.get(i) < min)
				min = support.get(i);
		}
		return min;
	}

	/**
	 * The function that calculate the variance.
	 * @param data the Records where to get the information for calcuting the variance
	 * @param field the field of which the variance has to be calculated
	 * @return the variance
	 */
	public double ComputeVariance(ArrayList<SingleRecordInfo> data, String field) {
		double variance = 0;

		ArrayList<Double> support = ValueListOfImages(data, field);
		for (int i=0; i<support.size();i++) {
			variance += Math.pow((support.get(i) - ComputeAverage(data, field)), 2);
		}
		return variance / support.size();
	}

	/**
	 * This function is used to find all the values of a field of the images of the database
	 * @param data the Records where to take the information to calculate stats
	 * @param field the field of which the stats has to be calculated
	 * @return an ArraList of the value of the images of the records that satisfy the field passed
	 */
	public ArrayList<Double> ValueListOfImages(ArrayList<SingleRecordInfo> data, String field){
		
		ArrayList<Double> result = new ArrayList<Double>();
		//this for is used to take all the image information that are usefull to calculate the different stats, switching between the different field passed
		for(int i =0; i < data.size();i++) {
			for(int j=0;j<data.get(i).getImages().size();j++)
				if(field.equals("height"))
					result.add((double)data.get(i).getImages().get(j).getHeight());
				else if(field.equals("width"))
					result.add((double)data.get(i).getImages().get(j).getWidth());
				else if(field.equals("megapixel"))
					result.add(data.get(i).getImages().get(j).getMegapixel());
		}
		return result;
	}
}

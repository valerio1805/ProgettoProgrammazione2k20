package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.model.SingleFilter;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;
/**
 * 
 * @author valeAle;
 * The class that is used to obtain the set of record that satisfy the filter added by the user
 */

public class ProcessingFilter {
	/**
	 * The function that calls the function filterFunction to verify which records satisfy the filter 
	 * @param database the set of data
	 * @param filterToAnalize the filter added by the user
	 * @return an ArrayList with the records that satisfy the filter
	 */
	private ArrayList<SingleRecordInfo> ApplyFilter(ArrayList<SingleRecordInfo> database, SingleFilter filterToAnalize) {
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		//The executor becomes the effective class of filtering
		Filtering executor = RecognizeOperatorOfFilter(filterToAnalize);
		for (int i = 0; i < database.size(); i++) {
			//if the record matches with the filter it is added to the ArrayList result
			if (executor.FilterFunction(filterToAnalize.getValues(), database.get(i)))
				result.add(database.get(i));
		}
		return result;
	}

	/**
	 * The function that recognize the type of filtering that the app has to do
	 * @param filterToAnalize filter added by the user
	 * @return the correct type of filtering that the app has to do
	 */
	public Filtering RecognizeOperatorOfFilter(SingleFilter filterToAnalize) {
		int j;
		Filtering[] filters = initialize();
		//the filter to analize is compared with the all type of class filtering
		for (j = 0; j < 24; j++)
			if (filters[j].getOperator().equals(filterToAnalize.getOperator())
					&& filters[j].getField().equals(filterToAnalize.getField()))
				break;
		
		//the result is the effective type of filtering that the program has to do
		return filters[j];
	}

	/**
	 * The function that is called when the user inserts a filter with a macrooperator different by "$or"
	 * @param database the data set
	 * @param filterToAnalize the filter added by the user
	 * @return an ArrayList with the records that satisfy the filter
	 */
	public ArrayList<SingleRecordInfo> ApplyFilterGen(ArrayList<SingleRecordInfo> database,
			TotalFilters filterToAnalize) {
		ArrayList<SingleRecordInfo> result = database;
		
		//this is the main for where the other function where called for every filter are is contained in filterToAnalize
		//if the macroOperator is "$and" the result of the first operation of filtering is used for the second operation for the second filter contained in FilterToanalize 
		//and again with the third ecc.
		for (int i = 0; i < filterToAnalize.getAllFilters().size(); i++) {
			result = ApplyFilter(result, filterToAnalize.getAllFilters().get(i));
		}
		return result;
	}

	/**
	 * The function that is called when the user inserts a filter with the macrooperator "$or"
	 * @param database the data set
	 * @param filterToAnalize the filter added by the user
	 * @return an ArrayList with the records that satisfy the filter
	 */
	public ArrayList<SingleRecordInfo> ApplyFilterOr(ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize) {
		ArrayList<SingleRecordInfo> container = new ArrayList<SingleRecordInfo>();
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		
		for (int i = 0; i < filterToAnalize.getAllFilters().size(); i++) {
			//container has the records that satisfy the filter in the i posistion of AllFilter contained in FilterToAnalize
			container = ApplyFilter(database, filterToAnalize.getAllFilters().get(i));
			int costant = result.size();
			
			//if result is empty, it is filled with container
			//else there is a for that control if the records of container are already stored in result
			if (costant == 0)
				result.addAll(container);
			else {
				for (int k = 0; k < container.size(); k++) {
					for (int j = 0; j < costant; j++)
						if (!(result.get(j).getId().equals(container.get(k).getId()))) {
							result.add(container.get(k));
							break;
						}
				}
			}
		}
		return result;
	}

	/**
	 * The function that initialize an array of filter with the all type of filtering supported by the system
	 * @return the array with the all type of filtering
	 */
	private Filtering[] initialize() {
		Filtering[] filters = new Filtering[24];
		filters[0] = new FilteringBetHeight();
		filters[1] = new FilteringBetHash();
		filters[2] = new FilteringBetWidth();
		filters[3] = new FilteringBetPix();
		filters[4] = new FilteringLteHeight();
		filters[5] = new FilteringLteHash();
		filters[6] = new FilteringLteWidth();
		filters[7] = new FilteringLtePix();
		filters[8] = new FilteringLtHeight();
		filters[9] = new FilteringLtHash();
		filters[10] = new FilteringLtWidth();
		filters[11] = new FilteringLtPix();
		filters[12] = new FilteringGteHeight();
		filters[13] = new FilteringGteHash();
		filters[14] = new FilteringGteWidth();
		filters[15] = new FilteringGtePix();
		filters[16] = new FilteringGtHeight();
		filters[17] = new FilteringGtHash();
		filters[18] = new FilteringGtWidth();
		filters[19] = new FilteringGtPix();
		filters[20] = new FilteringNIn();
		filters[21] = new FilteringNot();
		filters[22] = new FilteringIn();
		return filters;
	}
}

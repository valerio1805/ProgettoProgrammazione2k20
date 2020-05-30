package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;
import java.util.HashMap;

import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.model.SingleFilter;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class ProcessingFilter {
	private ArrayList<SingleRecordInfo> ApplyFilter(ArrayList<SingleRecordInfo> database, SingleFilter filterToAnalize) {
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		Filtering executor = RecognizeOperatorOfFilter(filterToAnalize);
		for (int i = 0; i < database.size(); i++) {
			if (executor.FilterFunction(filterToAnalize.getValues(), database.get(i)))
				result.add(database.get(i));
		}
		return result;
	}

	private Filtering RecognizeOperatorOfFilter(SingleFilter filterToAnalize) {
		int j;
		Filtering[] filters = initialize();
		for (j = 0; j < 24; j++)
			if (filters[j].getOperator().equals(filterToAnalize.getOperator())
					&& filters[j].getField().equals(filterToAnalize.getField()))
				break;
		return filters[j];
	}

	public ArrayList<SingleRecordInfo> ApplyFilterGen(ArrayList<SingleRecordInfo> database,
			TotalFilters filterToAnalize) {
		ArrayList<SingleRecordInfo> result = database;
		for (int i = 0; i < filterToAnalize.getAllFilters().size(); i++) {
			result = ApplyFilter(result, filterToAnalize.getAllFilters().get(i));
		}
		return result;
	}

	public ArrayList<SingleRecordInfo> ApplyFilterOr(ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize) {
		ArrayList<SingleRecordInfo> container = new ArrayList<SingleRecordInfo>();
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		for (int i = 0; i < filterToAnalize.getAllFilters().size(); i++) {
			container = ApplyFilter(database, filterToAnalize.getAllFilters().get(i));
			int costant = result.size();
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

	private Filtering[] initialize() {
		Filtering[] filters = new Filtering[24];
		filters[0] = new FilteringBetAlt();
		filters[1] = new FilteringBetHash();
		filters[2] = new FilteringBetLarg();
		filters[3] = new FilteringBetPix();
		filters[4] = new FilteringMinUgAlt();
		filters[5] = new FilteringMinUgHash();
		filters[6] = new FilteringMinUgLarg();
		filters[7] = new FilteringMinUgPix();
		filters[8] = new FilteringMinAlt();
		filters[9] = new FilteringMinHash();
		filters[10] = new FilteringMinLarg();
		filters[11] = new FilteringMinPix();
		filters[12] = new FilteringMagUgAlt();
		filters[13] = new FilteringMagUgHash();
		filters[14] = new FilteringMagUgLarg();
		filters[15] = new FilteringMagUgPix();
		filters[16] = new FilteringMagAlt();
		filters[17] = new FilteringMagHash();
		filters[18] = new FilteringMagLarg();
		filters[19] = new FilteringMagPix();
		filters[20] = new FilteringNIn();
		filters[21] = new FilteringNot();
		filters[22] = new FilteringIn();
		return filters;
	}
}

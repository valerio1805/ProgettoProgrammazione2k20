package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;
import java.util.HashMap;

import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class ProcessingFilter {
	private ArrayList<SingleRecordInfo> ApplyFilter(ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize) {
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		Filtering executor = RecognizeOperatorOfFilter(filterToAnalize, 0);
		for (int i = 0; i < database.size(); i++) {
			if (executor.FilterFunction(filterToAnalize.getAllFilters().get(0).getField(),
					filterToAnalize.getAllFilters().get(0).getValues(), database.get(i)))
				result.add(database.get(i));
		}
		return result;
	}

	private Filtering RecognizeOperatorOfFilter(TotalFilters filterToAnalize, int i) {
		int j;
		Filtering[] filters = initialize();
		for (j = 0; j < 24; j++)
			if (filters[j].getOperator().equals(filterToAnalize.getAllFilters().get(i).getOperator())
					&& filters[j].getField().equals(filterToAnalize.getAllFilters().get(i).getField()))
				break;
		return filters[j];
	}

	public ArrayList<SingleRecordInfo> ApplyFilterGen(ArrayList<SingleRecordInfo> database,
			TotalFilters filterToAnalize) {
		TotalFilters support;
		ArrayList<SingleRecordInfo> result = database;
		for (int i = 0; i < filterToAnalize.getAllFilters().size(); i++) {
			support = new TotalFilters();
			support.setMacroOperator("");
			support.setAllFilters(filterToAnalize.getAllFilters().get(i));
			result = ApplyFilter(result, support);
		}
		return result;
	}

	public ArrayList<SingleRecordInfo> ApplyFilterOr(ArrayList<SingleRecordInfo> database,
			TotalFilters filterToAnalize) {
		TotalFilters support;
		ArrayList<SingleRecordInfo> container = new ArrayList<SingleRecordInfo>();
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		for (int i = 0; i < filterToAnalize.getAllFilters().size(); i++) {
			support = new TotalFilters();
			support.setMacroOperator("");
			support.setAllFilters(filterToAnalize.getAllFilters().get(i));
			container = ApplyFilter(database, support);
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
		filters[0] = new FiltraggioBetAlt();
		filters[1] = new FiltraggioBetHash();
		filters[2] = new FiltraggioBetLarg();
		filters[3] = new FiltraggioBetPix();
		filters[4] = new FiltraggioMinUgAlt();
		filters[5] = new FiltraggioMinUgHash();
		filters[6] = new FiltraggioMinUgLarg();
		filters[7] = new FiltraggioMinUgPix();
		filters[8] = new FiltraggioMinAlt();
		filters[9] = new FiltraggioMinHash();
		filters[10] = new FiltraggioMinLarg();
		filters[11] = new FiltraggioMinPix();
		filters[12] = new FiltraggioMagUgAlt();
		filters[13] = new FiltraggioMagUgHash();
		filters[14] = new FiltraggioMagUgLarg();
		filters[15] = new FiltraggioMagUgPix();
		filters[16] = new FiltraggioMagAlt();
		filters[17] = new FiltraggioMagHash();
		filters[18] = new FiltraggioMagLarg();
		filters[19] = new FiltraggioMagPix();
		filters[20] = new FiltraggioNIn();
		filters[21] = new FiltraggioNot();
		filters[22] = new FiltraggioIn();
		return filters;
	}

}

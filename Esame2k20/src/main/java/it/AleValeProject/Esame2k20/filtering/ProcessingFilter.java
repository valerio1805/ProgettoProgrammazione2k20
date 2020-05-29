package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.aritm.*;
import it.AleValeProject.Esame2k20.filtering.logic.*;
import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class ProcessingFilter {
	public ArrayList<SingleRecordInfo> ApplyFilter (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		Filtering executor = RecognizeOperatorOfFilter(filterToAnalize,0);
		for(int i=0;i<database.size();i++) {
			if(executor.FilterFunction(filterToAnalize.getAllFilters().get(0).getField(),filterToAnalize.getAllFilters().get(0).getValues(),database.get(i)))
				result.add(database.get(i));
		}
		return result;
	}
	private Filtering RecognizeOperatorOfFilter(TotalFilters filterToAnalize,int i) {
		int j;
		Filtering[] filters=initialize();
		for(j=0;j<filters.length;j++)
			if(filters[j].getOperator().equals(filterToAnalize.getAllFilters().get(i).getOperator()))
				break;
		return filters[j];
	}
	
	public ArrayList<SingleRecordInfo> ApplyFilterGen (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		TotalFilters support;
		ArrayList<SingleRecordInfo> result = database;
		for(int i =0;i<filterToAnalize.getAllFilters().size();i++) {
			support = new TotalFilters();
			support.setMacroOperator("");
			support.setAllFilters(filterToAnalize.getAllFilters().get(i));
			result = ApplyFilter(result, support);
		}
		return result;
	}
	
	public ArrayList<SingleRecordInfo> ApplyFilterOr (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		TotalFilters support;
		ArrayList<SingleRecordInfo> container = new ArrayList<>();
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		for(int i =0;i<filterToAnalize.getAllFilters().size();i++) {
			support = new TotalFilters();
			support.setMacroOperator("");
			support.setAllFilters(filterToAnalize.getAllFilters().get(i));
			container = ApplyFilter(database, support);
			for(int k=0;k<container.size();k++) {
				if(result.size()==0)
					result.addAll(container);
				else
					for(int j =0; j<result.size();j++)
						if(!(result.get(j).getId().equals(container.get(k).getId())))
							result.addAll(container);
			}
		}
		return result;
	}
	
	private Filtering[] initialize() {
		Filtering[] filters = new Filtering[8];
		filters[0]=new FiltraggioBetHash();
		filters[1]=new FiltraggioMagHash();
		filters[2]=new FiltraggioMagUgHash();
		filters[3]=new FiltraggioMinHash();
		filters[4]=new FiltraggioMinUgHash();
		filters[5]=new FiltraggioIn();
		filters[6]=new FiltraggioNIn();
		filters[7]=new FiltraggioNot();
		return filters;
	}
	
	
}

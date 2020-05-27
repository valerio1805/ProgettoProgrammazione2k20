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
		Filtering result;
		switch(filterToAnalize.getAllFilters().get(i).getOperator()) {
		case "$not":result = new FiltraggioNot(); break;
		case "$in": result = new FiltraggioIn(); break;
		case "$nin":result = new FiltraggioNIn(); break;
		case "$lte":result = new FiltraggioMinUg(); break;
		case "$lt": result = new FiltraggioMin(); break;
		case "$gt": result = new FiltraggioMag(); break;
		case "$gte":result = new FiltraggioMagUg(); break;
		default:    result = new FiltraggioBet();
		}
		return result;
	}
	
	public ArrayList<SingleRecordInfo> ApplyFilterAnd (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
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
		ArrayList<SingleRecordInfo>[] container = new ArrayList[30];
		for(int i =0;i<filterToAnalize.getAllFilters().size();i++) {
			support = new TotalFilters();
			support.setMacroOperator("");
			support.setAllFilters(filterToAnalize.getAllFilters().get(i));
			container[i] = ApplyFilter(database, support);
		}
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		for(int i =0;i<container.length;i++)
			for(int k=0;k<container[i].size();k++) {
				if(result.size()==0)
					result.addAll(container[i]);
				else
					for(int j =0; j<result.size();j++)
						if(!(result.get(j).getId().equals(container[i].get(k).getId())))
							result.addAll(container[i]);
			}
		return result;
	}
	
	
}

package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.aritm.*;
import it.AleValeProject.Esame2k20.filtering.logic.*;
import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class ProcessingFilter {
	public ArrayList<SingleRecordInfo> RecognizeOperator (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		Filtering executor = RecognizeFilter(filterToAnalize,0);
		for(int i=0;i<database.size();i++) {
			if(executor.FilterFunction(filterToAnalize.getTuttiIFiltri().get(0).getField(),filterToAnalize.getTuttiIFiltri().get(0).getValues(),database.get(i)))
				result.add(database.get(i));
		}
		return result;
	}
	private Filtering RecognizeFilter(TotalFilters filterToAnalize,int i) {
		Filtering result;
		switch(filterToAnalize.getTuttiIFiltri().get(i).getOperator()) {
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
	
	public ArrayList<SingleRecordInfo> OperatorAnd (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		TotalFilters support;
		ArrayList<SingleRecordInfo> result = database;
		for(int i =0;i<filterToAnalize.getTuttiIFiltri().size();i++) {
			support = new TotalFilters();
			support.setMacroOperatore("");
			support.setTuttiIFiltri(filterToAnalize.getTuttiIFiltri().get(i));
			result = RecognizeOperator(result, support);
		}
		return result;
	}
	
	public ArrayList<SingleRecordInfo> OperatorOr (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		TotalFilters support;
		ArrayList<SingleRecordInfo>[] container = new ArrayList[30];
		for(int i =0;i<filterToAnalize.getTuttiIFiltri().size();i++) {
			support = new TotalFilters();
			support.setMacroOperatore("");
			support.setTuttiIFiltri(filterToAnalize.getTuttiIFiltri().get(i));
			container[i] = RecognizeOperator(database, support);
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

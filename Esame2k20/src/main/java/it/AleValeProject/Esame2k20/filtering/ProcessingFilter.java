package it.AleValeProject.Esame2k20.filtering;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtering.aritm.*;
import it.AleValeProject.Esame2k20.filtering.logic.*;
import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;

public class ProcessingFilter {
	public ArrayList<SingleRecordInfo> RiconosciOperatore (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		Filtering esecutore = RiconosciFiltro(filterToAnalize,0);
		for(int i=0;i<database.size();i++) {
			if(esecutore.Filtra(filterToAnalize.getTuttiIFiltri().get(0).getCampo(),filterToAnalize.getTuttiIFiltri().get(0).getValori(),database.get(i)))
				result.add(database.get(i));
		}
		return result;
	}
	private Filtering RiconosciFiltro(TotalFilters filterToAnalize,int i) {
		Filtering result;
		switch(filterToAnalize.getTuttiIFiltri().get(i).getOperatore()) {
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
	
	public ArrayList<SingleRecordInfo> RiconosciOperatoreAnd (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		TotalFilters ap;
		for(int i =0;i<filterToAnalize.getTuttiIFiltri().size();i++) {
			ap = new TotalFilters();
			ap.setMacroOperatore("");
			ap.setTuttiIFiltri(filterToAnalize.getTuttiIFiltri().get(i));
			database = RiconosciOperatore(database, ap);
		}
		return database;
	}
	
	public ArrayList<SingleRecordInfo> RiconosciOperatoreOr (ArrayList<SingleRecordInfo> database, TotalFilters filterToAnalize){
		TotalFilters ap;
		ArrayList<SingleRecordInfo>[] contain = new ArrayList[30];
		for(int i =0;i<filterToAnalize.getTuttiIFiltri().size();i++) {
			ap = new TotalFilters();
			ap.setMacroOperatore("");
			ap.setTuttiIFiltri(filterToAnalize.getTuttiIFiltri().get(i));
			contain[i] = RiconosciOperatore(database, ap);
		}
		ArrayList<SingleRecordInfo> result = new ArrayList<SingleRecordInfo>();
		for(int i =0;i<contain.length;i++)
			for(int k=0;k<contain[i].size();k++) {
				if(result.size()==0)
					result.addAll(contain[i]);
				else
					for(int j =0; j<result.size();j++)
						if(!(result.get(j).getId().equals(contain[i].get(k).getId())))
							result.addAll(contain[i]);
			}
		return result;
	}
	
	
}

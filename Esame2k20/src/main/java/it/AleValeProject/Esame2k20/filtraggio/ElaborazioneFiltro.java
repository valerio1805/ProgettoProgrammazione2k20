package it.AleValeProject.Esame2k20.filtraggio;

import java.util.ArrayList;

import it.AleValeProject.Esame2k20.filtraggio.logic.*;
import it.AleValeProject.Esame2k20.filtraggio.aritm.*;
import it.AleValeProject.Esame2k20.model.FilterField;
import it.AleValeProject.Esame2k20.model.RecordInfo;

public class ElaborazioneFiltro {
	public ArrayList<RecordInfo> RiconosciOperatore (ArrayList<RecordInfo> database, FilterField filterToAnalize){
		ArrayList<RecordInfo> result = new ArrayList<RecordInfo>();
		Filtraggio esecutore = RiconosciFiltro(filterToAnalize,0);
		for(int i=0;i<database.size();i++) {
			if(esecutore.Filtra(filterToAnalize.getTuttiIFiltri().get(0).getCampo(),filterToAnalize.getTuttiIFiltri().get(0).getValori(),database.get(i)))
				result.add(database.get(i));
		}
		return result;
	}
	private Filtraggio RiconosciFiltro(FilterField filterToAnalize,int i) {
		Filtraggio result;
		switch(filterToAnalize.getTuttiIFiltri().get(i).getOperatore()) {
		case "$not": result = new FiltraggioNot(); break;
		case "$in": result = new FiltraggioIn(); break;
		case "$nin": result = new FiltraggioNIn(); break;
		case "$lte": result = new FiltraggioMinUg(); break;
		case "$lt": result = new FiltraggioMin(); break;
		case "$gt": result = new FiltraggioMag(); break;
		case "$gte": result = new FiltraggioMagUg(); break;
		default: result = new FiltraggioBet();
		}
		return result;
	}
	
	public ArrayList<RecordInfo> RiconosciOperatoreAnd (ArrayList<RecordInfo> database, FilterField filterToAnalize){
		FilterField ap;
		for(int i =0;i<filterToAnalize.getTuttiIFiltri().size();i++) {
			ap = new FilterField();
			ap.setMacroOperatore("");
			ap.setTuttiIFiltri(filterToAnalize.getTuttiIFiltri().get(i));
			database = RiconosciOperatore(database, ap);
		}
		return database;
	}
	
	public ArrayList<RecordInfo> RiconosciOperatoreOr (ArrayList<RecordInfo> database, FilterField filterToAnalize){
		FilterField ap;
		ArrayList<RecordInfo>[] contain = new ArrayList[30];
		for(int i =0;i<filterToAnalize.getTuttiIFiltri().size();i++) {
			ap = new FilterField();
			ap.setMacroOperatore("");
			ap.setTuttiIFiltri(filterToAnalize.getTuttiIFiltri().get(i));
			contain[i] = RiconosciOperatore(database, ap);
		}
		ArrayList<RecordInfo> result = new ArrayList<RecordInfo>();
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

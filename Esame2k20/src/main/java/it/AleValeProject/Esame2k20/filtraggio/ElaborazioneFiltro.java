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
		if(esecutore.Filtra(filterToAnalize.getTuttiIFiltri().get(0).getCampo(),filterToAnalize.getTuttiIFiltri().get(0).getValori(),database.get(i)));
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
}

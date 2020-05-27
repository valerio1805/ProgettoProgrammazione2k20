package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.eccezioni.FilterException;
import it.AleValeProject.Esame2k20.model.CampoMetaD;
import it.AleValeProject.Esame2k20.model.RecordInfo;
import it.AleValeProject.Esame2k20.model.SingleInstruction;
import it.AleValeProject.Esame2k20.model.Stats;
@Service
public interface DataService {

	// Start of user code (user defined attributes for DataService)

	// End of user code

	/**
	 * Description of the method VisulizzaMetadata.
	 */
	public abstract ArrayList<CampoMetaD> VisulizzaMetadata();

	/**
	 * Description of the method VisalizzaData.
	 */
	public abstract ArrayList<RecordInfo> VisualizzaData();
	public abstract ArrayList<RecordInfo> VisualizzaData(String filtroDaRiconoscere)throws FilterException;

	/**
	 * Description of the method VisulizzaStatistiche.
	 */
	public abstract Stats[] VisualizzaStatistiche();
	public abstract Stats[] VisualizzaStatistiche(String filtroPassato,String campo);
	public abstract Stats[] VisualizzaStatistiche(String filtroPassato) throws FilterException;
	
	/**
	 * Description of the method VisulizzaIstruzioni.
	 */
	public abstract ArrayList<SingleInstruction> VisulizzaIstruzioni();
	
	

	// Start of user code (user defined methods for DataService)

	// End of user code
}

package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.exception.FilterException;
import it.AleValeProject.Esame2k20.filtering.ProcessingFilter;
import it.AleValeProject.Esame2k20.filtering.Filtering;
import it.AleValeProject.Esame2k20.model.*;
import it.AleValeProject.Esame2k20.util.DatabaseCreation;
import it.AleValeProject.Esame2k20.util.FilterCreation;
import it.AleValeProject.Esame2k20.util.InstructionCreation;
import it.AleValeProject.Esame2k20.util.MetaDataCreation;
@Service
public class DataServiceImpl implements DataService {

	/**
	 * Description of the property database.
	 */
	public ArrayList<SingleRecordInfo> database = new ArrayList<>() ;
	private MetaDataCreation metaD = new MetaDataCreation(); ;
	private Stats[] statistiche = new Stats[3];
	private InstructionCreation istruzioni =new InstructionCreation();
	private ArrayList<SingleRecordInfo> filtrato = new ArrayList<SingleRecordInfo>();
	private FilterCreation riconoscitore= new FilterCreation();
	private ProcessingFilter esecutore = new ProcessingFilter();
	private Stats[] statsFilt = new Stats[3];
	/**
	 * Description of the property starter.
	 */
	private DatabaseCreation starter = new DatabaseCreation();

	/**
	 * Description of the property creaF.
	 */
	public FilterCreation creaF = null;

	/**
	 * Description of the property filtring.
	 */
	public Filtering filtring = null;

	// Start of user code (user defined attributes for DataServiceImpl)

	// End of user code

	/**
	 * The constructor.
	 */
	public DataServiceImpl() {
		// Start of user code constructor for DataServiceImpl)
		//super();
		database = starter.SavingInformation();
		statistiche[0]=new Stats(this.database, "larghezza");
		statistiche[1]=new Stats(this.database, "altezza");
		statistiche[2]=new Stats(this.database,"megapixel");
		// End of user code
	}

	/**
	 * Description of the method VisalizzaData.
	 */
	public ArrayList<SingleRecordInfo> VisualizzaData() {
		// Start of user code for method VisalizzaData
		// End of user code
		return this.database;

	}
	
	public ArrayList<SingleRecordInfo> VisualizzaData(String filtroDaRiconoscere) throws FilterException {
		// Start of user code for method VisulizzaStatistiche
		// End of user code
		return TrovaRec(filtroDaRiconoscere);
	}
	
	/**
	 * Description of the method VisulizzaStatistiche.
	 */
	public Stats[] VisualizzaStatistiche() {
		return this.statistiche;
	}
	public Stats[] VisualizzaStatistiche(String filtroPassato,String campo){
		
		filtroPassato = "filter="+filtroPassato;
		return this.statistiche;
	}
	public Stats[] VisualizzaStatistiche(String filtroPassato) throws FilterException{
		statsFilt[0]=new Stats(TrovaRec(filtroPassato), "larghezza");
		statsFilt[1]=new Stats(TrovaRec(filtroPassato), "altezza");
		statsFilt[2]=new Stats(TrovaRec(filtroPassato),"megapixel");
		return statsFilt;
	}

	/**
	 * Description of the method VisulizzaMetadata.
	 */
	public ArrayList<SingleMetaData> VisulizzaMetadata() {
		// Start of user code for method VisulizzaMetadata
		// End of user code
		return metaD.getMetaDati();
		
	}
	
	/**
	 * Description of the method VisulizzaIstruzioni.
	 */
	public ArrayList<SingleInstruction> VisulizzaIstruzioni() {
		// Start of user code for method VisulizzaIstruzioni
		// End of user code
		return istruzioni.getLibrettoDelleIstruzioni();
		
	}

	// Start of user code (user defined methods for DataServiceImpl)

	// End of user code
	/**
	 * Returns database.
	 * @return database 
	 */
	public String getDatabase() {
		return database.toString();
	}

	/**
	 * Returns starter.
	 * @return starter 
	 */
	public DatabaseCreation getStarter() {
		return this.starter;
	}

	/**
	 * Sets a value to attribute starter. 
	 * @param newStarter 
	 */
	public void setStarter(DatabaseCreation newStarter) {
		this.starter = newStarter;
	}

	/**
	 * Returns creaF.
	 * @return creaF 
	 */
	public FilterCreation getCreaF() {
		return this.creaF;
	}

	/**
	 * Sets a value to attribute creaF. 
	 * @param newCreaF 
	 */
	public void setCreaF(FilterCreation newCreaF) {
		this.creaF = newCreaF;
	}

	/**
	 * Returns filtring.
	 * @return filtring 
	 */
	public Filtering getFiltring() {
		return this.filtring;
	}

	/**
	 * Sets a value to attribute filtring. 
	 * @param newFiltring 
	 */
	public void setFiltring(Filtering newFiltring) {
		this.filtring = newFiltring;
	}
	
	private ArrayList<SingleRecordInfo> TrovaRec(String filtro) throws FilterException
	{
		TotalFilters filtroRiconosciuto= riconoscitore.RiconosciFiltro(filtro);
		if(filtroRiconosciuto.getMacroOperatore()=="")
			filtrato = esecutore.RecognizeOperator(database,filtroRiconosciuto);
		else if(filtroRiconosciuto.getMacroOperatore()=="and")
			filtrato = esecutore.OperatorAnd(database,filtroRiconosciuto);
		else if(filtroRiconosciuto.getMacroOperatore()=="or")
			filtrato = esecutore.OperatorOr(database,filtroRiconosciuto);	
		return filtrato;
	}
	

}

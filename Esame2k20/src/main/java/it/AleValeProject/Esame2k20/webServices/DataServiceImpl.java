package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.creazioneDatabase.DownloadInformazioni;
import it.AleValeProject.Esame2k20.eccezioni.FilterException;
import it.AleValeProject.Esame2k20.filtraggio.ElaborazioneFiltro;
import it.AleValeProject.Esame2k20.filtraggio.Filtraggio;
import it.AleValeProject.Esame2k20.model.*;
import it.AleValeProject.Esame2k20.varie.CreazioneFiltro;
import it.AleValeProject.Esame2k20.varie.Instruction;
import it.AleValeProject.Esame2k20.varie.MetaData;
@Service
public class DataServiceImpl implements DataService {

	/**
	 * Description of the property database.
	 */
	public ArrayList<RecordInfo> database = new ArrayList<>() ;
	private MetaData metaD = new MetaData(); ;
	private Stats[] statistiche = new Stats[3];
	private Instruction istruzioni =new Instruction();
	private ArrayList<RecordInfo> filtrato = new ArrayList<RecordInfo>();
	private CreazioneFiltro riconoscitore= new CreazioneFiltro();
	private ElaborazioneFiltro esecutore = new ElaborazioneFiltro();
	private Stats[] statsFilt = new Stats[3];
	/**
	 * Description of the property starter.
	 */
	private DownloadInformazioni starter = new DownloadInformazioni();

	/**
	 * Description of the property creaF.
	 */
	public CreazioneFiltro creaF = null;

	/**
	 * Description of the property filtring.
	 */
	public Filtraggio filtring = null;

	// Start of user code (user defined attributes for DataServiceImpl)

	// End of user code

	/**
	 * The constructor.
	 */
	public DataServiceImpl() {
		// Start of user code constructor for DataServiceImpl)
		//super();
		database = starter.SalvataggioInformazioni();
		statistiche[0]=new Stats(this.database, "larghezza");
		statistiche[1]=new Stats(this.database, "altezza");
		statistiche[2]=new Stats(this.database,"megapixel");
		// End of user code
	}

	/**
	 * Description of the method VisalizzaData.
	 */
	public ArrayList<RecordInfo> VisualizzaData() {
		// Start of user code for method VisalizzaData
		// End of user code
		return this.database;

	}
	
	public ArrayList<RecordInfo> VisualizzaData(String filtroDaRiconoscere) throws FilterException {
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
	public ArrayList<CampoMetaD> VisulizzaMetadata() {
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
	public DownloadInformazioni getStarter() {
		return this.starter;
	}

	/**
	 * Sets a value to attribute starter. 
	 * @param newStarter 
	 */
	public void setStarter(DownloadInformazioni newStarter) {
		this.starter = newStarter;
	}

	/**
	 * Returns creaF.
	 * @return creaF 
	 */
	public CreazioneFiltro getCreaF() {
		return this.creaF;
	}

	/**
	 * Sets a value to attribute creaF. 
	 * @param newCreaF 
	 */
	public void setCreaF(CreazioneFiltro newCreaF) {
		this.creaF = newCreaF;
	}

	/**
	 * Returns filtring.
	 * @return filtring 
	 */
	public Filtraggio getFiltring() {
		return this.filtring;
	}

	/**
	 * Sets a value to attribute filtring. 
	 * @param newFiltring 
	 */
	public void setFiltring(Filtraggio newFiltring) {
		this.filtring = newFiltring;
	}
	
	private ArrayList<RecordInfo> TrovaRec(String filtro) throws FilterException
	{
		FilterField filtroRiconosciuto= riconoscitore.RiconosciFiltro(filtro);
		if(filtroRiconosciuto.getMacroOperatore()=="")
			filtrato = esecutore.RiconosciOperatore(database,filtroRiconosciuto);
		else if(filtroRiconosciuto.getMacroOperatore()=="and")
			filtrato = esecutore.RiconosciOperatoreAnd(database,filtroRiconosciuto);
		else if(filtroRiconosciuto.getMacroOperatore()=="or")
			filtrato = esecutore.RiconosciOperatoreOr(database,filtroRiconosciuto);	
		return filtrato;
	}
	

}

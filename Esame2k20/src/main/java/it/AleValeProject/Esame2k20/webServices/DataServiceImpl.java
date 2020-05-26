package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.creazioneDatabase.DownloadInformazioni;
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
	public ArrayList<RecordInfo> VisalizzaData() {
		// Start of user code for method VisalizzaData
		// End of user code
		return this.database;

	}
	
	public ArrayList<RecordInfo> VisulizzaData(String filtroPassato) {
		// Start of user code for method VisulizzaStatistiche
		// End of user code
		
		filtroPassato = "filter="+filtroPassato;
		
		//implementare controllo filtroPassato
		//assegnazione controllo filtroPassato ad una variabile filterField(?)
		//controllo sul tipo di operatore
		//creazione istanza di Filtra opportuna
		//passaggio Record per record per vedere se rispettano parametri
		//ritornare il database filtrato
		
		
		return this.database;
		
	}
	
	/**
	 * Description of the method VisulizzaStatistiche.
	 */
	public Stats[] VisulizzaStatistiche() {
		// Start of user code for method VisulizzaStatistiche
		// End of user code
		return this.statistiche;
	}
	
	public Stats[] VisulizzaStatistiche(String filtroPassato,String campo)
	{
		
		filtroPassato = "filter="+filtroPassato;
		
		//implementare controllo filtroPassato
		//assegnazione controllo filtroPassato ad una variabile filterField(?)
		//controllo sul tipo di operatore
		//creazione istanza di Filtra opportuna
		//passaggio Record per record per vedere se rispettano parametri
		//ritornare il database filtrato
		
		return this.statistiche;
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
	
	
}

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
import it.AleValeProject.Esame2k20.util.MetadataCreation;
@Service
public class DataServiceImpl implements DataService {

	/**
	 * Description of the property database.
	 */
	public ArrayList<SingleRecordInfo> database = new ArrayList<>() ;
	private MetadataCreation metadata = new MetadataCreation(); ;
	private Stats[] statistics = new Stats[3];
	private InstructionCreation instructions =new InstructionCreation();
	private ArrayList<SingleRecordInfo> filteredDatabase = new ArrayList<SingleRecordInfo>();
	private FilterCreation recognizer= new FilterCreation();
	private ProcessingFilter executor = new ProcessingFilter();
	private Stats[] filteredStatistics = new Stats[3];
	/**
	 * Description of the property starter.
	 */
	private DatabaseCreation databaseCreator = new DatabaseCreation();

	/**
	 * Description of the property creaF.
	 */
	public FilterCreation filterCreator = null;

	/**
	 * Description of the property filtring.
	 */
	public Filtering filtering = null;

	// Start of user code (user defined attributes for DataServiceImpl)

	// End of user code

	/**
	 * The constructor.
	 */
	public DataServiceImpl() {
		// Start of user code constructor for DataServiceImpl)
		//super();
		database = databaseCreator.SavingInformation();
		statistics[0]=new Stats(this.database, "larghezza");
		statistics[1]=new Stats(this.database, "altezza");
		statistics[2]=new Stats(this.database,"megapixel");
		// End of user code
	}

	/**
	 * Description of the method DisplayData.
	 */
	public ArrayList<SingleRecordInfo> DisplayData() {
		// Start of user code for method VisalizzaData
		// End of user code
		return this.database;

	}
	
	public ArrayList<SingleRecordInfo> DisplayData(String filterToRecognize) throws FilterException {
		// Start of user code for method VisulizzaStatistiche
		// End of user code
		return FindFilteredDatabase(filterToRecognize);
	}
	
	/**
	 * Description of the method DisplayStatistics.
	 */
	public Stats[] DisplayStatistics() {
		return this.statistics;
	}
	public Stats DisplayStatistics(String filterToRecognize,String fieldToRecognize) throws FilterException{
		if(fieldToRecognize.equals("\"larghezza\"") )
			filteredStatistics[0]=new Stats(FindFilteredDatabase(filterToRecognize), "larghezza");
		if(fieldToRecognize.equals("\"altezza\""))
			filteredStatistics[0]=new Stats(FindFilteredDatabase(filterToRecognize), "altezza");
		if(fieldToRecognize.equals("\"megapixel\""))
			filteredStatistics[0]=new Stats(FindFilteredDatabase(filterToRecognize), "megapixel");	
		return this.filteredStatistics[0];
	}
	
	public Stats[] DisplayStatistics(String filterToRecognize) throws FilterException{
		filteredStatistics[0]=new Stats(FindFilteredDatabase(filterToRecognize), "larghezza");
		filteredStatistics[1]=new Stats(FindFilteredDatabase(filterToRecognize), "altezza");
		filteredStatistics[2]=new Stats(FindFilteredDatabase(filterToRecognize),"megapixel");
		return filteredStatistics;
	}

	/**
	 * Description of the method DisplayMetadata.
	 */
	public ArrayList<SingleMetaData> DisplayMetadata() {
		// Start of user code for method VisulizzaMetadata
		// End of user code
		return metadata.getMetadata();
		
	}
	
	/**
	 * Description of the method DisplayInstructions.
	 */
	public ArrayList<SingleInstruction> DisplayInstructions() {
		// Start of user code for method VisulizzaIstruzioni
		// End of user code
		return instructions.getInstructionsManual();
		
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
	 * Returns DatabaseCreator.
	 * @return DatabaseCreator 
	 */
	public DatabaseCreation getDatabaseCreator() {
		return this.databaseCreator;
	}

	/**
	 * Sets a value to attribute DatabaseCreator. 
	 * @param newDatabaseCreator 
	 */
	public void setDatabaseCreator(DatabaseCreation newDatabaseCreator) {
		this.databaseCreator = newDatabaseCreator;
	}

	/**
	 * Returns filterCreator.
	 * @return filterCreator 
	 */
	public FilterCreation getFilterCreator() {
		return this.filterCreator;
	}

	/**
	 * Sets a value to attribute filterCreator. 
	 * @param newFilterCreator 
	 */
	public void setFilterCreator(FilterCreation newFilterCreator) {
		this.filterCreator = newFilterCreator;
	}

	/**
	 * Returns filtering.
	 * @return filtering 
	 */
	public Filtering getFiltering() {
		return this.filtering;
	}

	/**
	 * Sets a value to attribute filtering. 
	 * @param newFiltering 
	 */
	public void setFiltering(Filtering newFiltering) {
		this.filtering = newFiltering;
	}
	
	private ArrayList<SingleRecordInfo> FindFilteredDatabase(String filtro) throws FilterException
	{
		TotalFilters filtroRiconosciuto= recognizer.TranslateFilter(filtro);
		if(filtroRiconosciuto.getMacroOperator()=="$or")
			filteredDatabase = executor.ApplyFilterOr(database,filtroRiconosciuto);	
		else
			filteredDatabase = executor.ApplyFilterGen(database,filtroRiconosciuto);
		return filteredDatabase;
	}
	

}

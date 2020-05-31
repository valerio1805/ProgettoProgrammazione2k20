package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.exception.*;
import it.AleValeProject.Esame2k20.filtering.ProcessingFilter;
import it.AleValeProject.Esame2k20.model.*;
import it.AleValeProject.Esame2k20.util.*;

/**
 * 
 * @author valeAle;
 *
 */
@Service
public class DataServiceImpl implements DataService {
	/**
	 * The database of the program
	 */
	private ArrayList<SingleRecordInfo> database = new ArrayList<>();
	/**
	 * All the metadata
	 */
	private MetadataCreation metadata = new MetadataCreation();
	/**
	 * The general stats of all the dataset
	 */
	private Stats[] statistics = new Stats[3];
	
	/**
	 * The instructions to show to the user 
	 */
	private InstructionCreation instructions = new InstructionCreation();
	
	/**
	 * An arrayList that is composed of only the record that satisfy the filter
	 */
	private ArrayList<SingleRecordInfo> filteredDatabase = new ArrayList<SingleRecordInfo>();
	
	/**
	 * An array of stats calculated using only the records that satisfy the filter
	 */
	private Stats[] filteredStatistics = new Stats[3];
	
	/**
	 * The stats calculated for a particular field insered by the user
	 */
	private Stats statsField;

	/**
	 * The variabile that is used to create the databse
	 */
	private DatabaseCreation databaseCreator = new DatabaseCreation();

	/**
	 * The constructor. Used to create the database and the general stats.
	 * @throws DeleteFileException 
	 */
	public DataServiceImpl() throws DeleteFileException {
		database = databaseCreator.SavingInformation();
		statistics[0] = new Stats(this.database, "width");
		statistics[1] = new Stats(this.database, "height");
		statistics[2] = new Stats(this.database, "megapixel");
	}

	/**
	 *{@inheritDoc}
	 */
	public ArrayList<SingleRecordInfo> DisplayData() {
		return this.database;

	}

	/**
	 *{@inheritDoc}
	 */
	public ArrayList<SingleRecordInfo> DisplayData(String filterToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException {
		return FindFilteredDatabase(filterToRecognize);
	}

	/**
	 *{@inheritDoc}
	 */
	public Stats[] DisplayStatistics() {
		return this.statistics;
	}

	
	/**
	 *{@inheritDoc}
	 */
	public Stats DisplayFieldStatistics(String filterToRecognize, String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException {
		filteredStatistics[0] = new Stats(FindFilteredDatabase(filterToRecognize),RecognizeField(fieldToRecognize));
		return this.filteredStatistics[0];
	}

	/**
	 *{@inheritDoc}
	 */
	public Stats[] DisplayStatistics(String filterToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException {
		filteredStatistics[0] = new Stats(FindFilteredDatabase(filterToRecognize), "width");
		filteredStatistics[1] = new Stats(FindFilteredDatabase(filterToRecognize), "height");
		filteredStatistics[2] = new Stats(FindFilteredDatabase(filterToRecognize), "megapixel");
		return filteredStatistics;
	}
	
	/**
	 *{@inheritDoc}
	 */
	public Stats DisplayFieldStatistics(String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException {
		statsField = new Stats(database, RecognizeField(fieldToRecognize));
		return this.statsField;
	}


	/**
	 *{@inheritDoc}
	 */
	public ArrayList<SingleMetadata> DisplayMetadata() {
		return metadata.getMetadata();

	}

	/**
	 *{@inheritDoc}
	 */
	public ArrayList<SingleInstruction> DisplayInstructions() {
		return instructions.getInstructionsManual();

	}

	/**
	 * The function that creates the filter using what the user insered, recognizes the typer of filter and find the records that satisfy the filter
	 * @param filter
	 * @return an ArrayList of records that satisfy the filter
	 * @throws FormatException
	 * @throws MismatchTypeFilterException
	 * @throws FieldException
	 * @throws OperatorException
	 */
	private ArrayList<SingleRecordInfo> FindFilteredDatabase(String filter) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException{
		FilterCreation recognizer = new FilterCreation();
		ProcessingFilter executor = new ProcessingFilter();
		TotalFilters recognizedFilter= recognizer.TranslateFilter(filter);
		if(recognizedFilter.getMacroOperator()=="$or")
			filteredDatabase = executor.ApplyFilterOr(database,recognizedFilter);	
		else
 			filteredDatabase = executor.ApplyFilterGen(database,recognizedFilter);
		return filteredDatabase;
	}
	
	
	/**
	 * The function that recognizes the field insered by the user
	 * @param field
	 * @return the field of what the program has to calculate the stats
	 * @throws StatsParamException
	 */
	private String RecognizeField(String field) throws StatsParamException
	{
		if (field.equals("\"width\""))
			return "width";
		if (field.equals("\"height\""))
			return "height";
		if (field.equals("\"megapixel\""))
			return "megapixel";
		else
			throw new StatsParamException("Field not valid for the stats");
	}
}
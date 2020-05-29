package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.exception.*;
import it.AleValeProject.Esame2k20.filtering.ProcessingFilter;
import it.AleValeProject.Esame2k20.model.*;
import it.AleValeProject.Esame2k20.util.*;

@Service
public class DataServiceImpl implements DataService {

	/**
	 * Description of the property database.
	 */
	private ArrayList<SingleRecordInfo> database = new ArrayList<>();
	private MetadataCreation metadata = new MetadataCreation();
	private Stats[] statistics = new Stats[3];
	private InstructionCreation instructions = new InstructionCreation();
	private ArrayList<SingleRecordInfo> filteredDatabase = new ArrayList<SingleRecordInfo>();
	private Stats[] filteredStatistics = new Stats[3];
	private Stats statsField;
	/**
	 * Description of the property databaseCreator.
	 */
	private DatabaseCreation databaseCreator = new DatabaseCreation();

	/**
	 * The constructor.
	 * @throws DeleteFileException 
	 */
	public DataServiceImpl() throws DeleteFileException {
		database = databaseCreator.SavingInformation();
		statistics[0] = new Stats(this.database, "width");
		statistics[1] = new Stats(this.database, "height");
		statistics[2] = new Stats(this.database, "megapixel");
	}

	/**
	 * Description of the method DisplayData.
	 */
	public ArrayList<SingleRecordInfo> DisplayData() {
		return this.database;

	}

	public ArrayList<SingleRecordInfo> DisplayData(String filterToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException {
		return FindFilteredDatabase(filterToRecognize);
	}

	/**
	 * Description of the method DisplayStatistics.
	 */
	public Stats[] DisplayStatistics() {
		return this.statistics;
	}

	public Stats DisplayFieldStatistics(String filterToRecognize, String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException {
		filteredStatistics[0] = new Stats(FindFilteredDatabase(filterToRecognize),RecognizeField(fieldToRecognize));
		return this.filteredStatistics[0];
	}

	public Stats[] DisplayStatistics(String filterToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException {
		filteredStatistics[0] = new Stats(FindFilteredDatabase(filterToRecognize), "width");
		filteredStatistics[1] = new Stats(FindFilteredDatabase(filterToRecognize), "height");
		filteredStatistics[2] = new Stats(FindFilteredDatabase(filterToRecognize), "megapixel");
		return filteredStatistics;
	}
	
	public Stats DisplayFieldStatistics(String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException {
		statsField = new Stats(database, RecognizeField(fieldToRecognize));
		return this.statsField;
	}

	/**
	 * Description of the method DisplayMetadata.
	 */
	public ArrayList<SingleMetadata> DisplayMetadata() {
		return metadata.getMetadata();

	}

	/**
	 * Description of the method DisplayInstructions.
	 */
	public ArrayList<SingleInstruction> DisplayInstructions() {
		return instructions.getInstructionsManual();

	}

	private ArrayList<SingleRecordInfo> FindFilteredDatabase(String filtro) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException{
		FilterCreation recognizer = new FilterCreation();
		ProcessingFilter executor = new ProcessingFilter();
		TotalFilters filtroRiconosciuto= recognizer.TranslateFilter(filtro);
		if(filtroRiconosciuto.getMacroOperator()=="$or")
			filteredDatabase = executor.ApplyFilterOr(database,filtroRiconosciuto);	
		else
 			filteredDatabase = executor.ApplyFilterGen(database,filtroRiconosciuto);
		return filteredDatabase;
	}
	
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
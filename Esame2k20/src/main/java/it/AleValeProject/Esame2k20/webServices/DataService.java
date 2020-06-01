package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.exception.*;
import it.AleValeProject.Esame2k20.model.*;
/**
 * The interface that provides the principal function of the app
 * @author Di Biase Alessandro, Donnini Valerio
 *
 */
@Service
public interface DataService {
	/**
	 * The function to display the informations
	 * @return an ArrayList of SingleInformation
	 */
	public abstract ArrayList<SingleInstruction> DisplayInstructions();
	/**
	 * The function to display the metadata
	 * @return an ArrayList of SingleMetadata
	 */
	public abstract ArrayList<SingleMetadata> DisplayMetadata();

	
	/**
	 * The function to display the all set of data
	 * @return an ArrayList of SingleRecordInfo
	 */
	public abstract ArrayList<SingleRecordInfo> DisplayData();
	
	/**
	 * The function that shows only the records that satisfy the filter added by the user 
	 * @param filterToRecognize
	 * @return an ArrayList that is composed of the record that satisfy the filter
	 * @throws FormatException
	 * @throws MismatchTypeFilterException
	 * @throws FieldException
	 * @throws OperatorException
	 */
	public abstract ArrayList<SingleRecordInfo> DisplayData(String filterToRecognize)throws FormatException, MismatchTypeFilterException, FieldException, OperatorException;

	/**
	 * The function to display all the stats of the all data
	 * @return an ArrayList of Stats
	 */
	public abstract Stats[] DisplayStatistics();
	
	/**
	 * The function that shows the stats calculated using only the records that satisfy the filter. 
	 * @param filterToRecognize
	 * @return an ArrayList of Stats 
	 * @throws FormatException
	 * @throws MismatchTypeFilterException
	 * @throws FieldException
	 * @throws OperatorException
	 */
	public abstract Stats[] DisplayStatistics(String filterToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException;
	
	/**
	 * The function that shows only the stats of a field passed by the user calculated using all the records of database. 
	 * @param fieldToRecognize
	 * @return a Stats
	 * @throws FormatException
	 * @throws MismatchTypeFilterException
	 * @throws FieldException
	 * @throws OperatorException
	 * @throws StatsParamException
	 */
	public abstract Stats DisplayFieldStatistics(String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException,StatsParamException ;
	
	/**
	 * The function that shows only the stats of a field passed by the user calculated using only the records that satisfy the filter. 
	 * @param filterToRecognize
	 * @param fieldToRecognize
	 * @return a Stats
	 * @throws FormatException
	 * @throws MismatchTypeFilterException
	 * @throws FieldException
	 * @throws OperatorException
	 * @throws StatsParamException
	 */
	public abstract Stats DisplayFieldStatistics(String filterToRecognize,String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException ;

}

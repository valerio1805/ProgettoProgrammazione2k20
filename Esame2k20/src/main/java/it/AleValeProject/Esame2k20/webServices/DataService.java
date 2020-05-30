package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.exception.*;
import it.AleValeProject.Esame2k20.model.*;
@Service
public interface DataService {
	/**
	 * Description of the method VisulizzaIstruzioni.
	 */
	public abstract ArrayList<SingleInstruction> DisplayInstructions();
	/**
	 * Description of the method VisulizzaMetadata.
	 */
	public abstract ArrayList<SingleMetadata> DisplayMetadata();

	/**
	 * Description of the method VisalizzaData.
	 */
	public abstract ArrayList<SingleRecordInfo> DisplayData();
	public abstract ArrayList<SingleRecordInfo> DisplayData(String filterToRecognize)throws FormatException, MismatchTypeFilterException, FieldException, OperatorException;

	/**
	 * Description of the method VisulizzaStatistiche.
	 * 
	 */
	public abstract Stats[] DisplayStatistics();
	public abstract Stats[] DisplayStatistics(String filterToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException;
	public abstract Stats DisplayFieldStatistics(String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException,StatsParamException ;
	public abstract Stats DisplayFieldStatistics(String filterToRecognize,String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException ;

}

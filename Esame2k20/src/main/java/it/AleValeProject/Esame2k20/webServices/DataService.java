package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.exception.FieldException;
import it.AleValeProject.Esame2k20.exception.FormatException;
import it.AleValeProject.Esame2k20.exception.MismatchTypeFilterException;
import it.AleValeProject.Esame2k20.exception.OperatorException;
import it.AleValeProject.Esame2k20.exception.StatsParamException;
import it.AleValeProject.Esame2k20.model.SingleMetadata;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;
import it.AleValeProject.Esame2k20.model.SingleIstruction;
import it.AleValeProject.Esame2k20.model.Stats;
@Service
public interface DataService {

	// Start of user code (user defined attributes for DataService)

	// End of user code

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
	 */
	public abstract Stats[] DisplayStatistics();
	public abstract Stats DisplayStatistics(String filterToRecognize,String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException, StatsParamException ;
	public abstract Stats[] DisplayStatistics(String filterToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException;
	public abstract Stats DisplayFieldStatistics(String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException,StatsParamException ;
	
	/**
	 * Description of the method VisulizzaIstruzioni.
	 */
	public abstract ArrayList<SingleIstruction> DisplayInstructions();
	
	

	// Start of user code (user defined methods for DataService)

	// End of user code
}

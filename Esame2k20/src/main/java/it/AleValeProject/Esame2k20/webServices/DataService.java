package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.exception.FieldException;
import it.AleValeProject.Esame2k20.exception.FormatException;
import it.AleValeProject.Esame2k20.exception.MismatchTypeFilterException;
import it.AleValeProject.Esame2k20.exception.OperatorException;
import it.AleValeProject.Esame2k20.model.SingleMetaData;
import it.AleValeProject.Esame2k20.model.SingleRecordInfo;
import it.AleValeProject.Esame2k20.model.SingleInstruction;
import it.AleValeProject.Esame2k20.model.Stats;
@Service
public interface DataService {

	// Start of user code (user defined attributes for DataService)

	// End of user code

	/**
	 * Description of the method VisulizzaMetadata.
	 */
	public abstract ArrayList<SingleMetaData> DisplayMetadata();

	/**
	 * Description of the method VisalizzaData.
	 */
	public abstract ArrayList<SingleRecordInfo> DisplayData();
	public abstract ArrayList<SingleRecordInfo> DisplayData(String filterToRecognize)throws FormatException, MismatchTypeFilterException, FieldException, OperatorException;

	/**
	 * Description of the method VisulizzaStatistiche.
	 */
	public abstract Stats[] DisplayStatistics();
	public abstract Stats DisplayStatistics(String filterToRecognize,String fieldToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException;
	public abstract Stats[] DisplayStatistics(String filterToRecognize) throws FormatException, MismatchTypeFilterException, FieldException, OperatorException;
	
	/**
	 * Description of the method VisulizzaIstruzioni.
	 */
	public abstract ArrayList<SingleInstruction> DisplayInstructions();
	
	

	// Start of user code (user defined methods for DataService)

	// End of user code
}

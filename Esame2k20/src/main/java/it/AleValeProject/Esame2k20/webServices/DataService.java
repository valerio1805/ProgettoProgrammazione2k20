package it.AleValeProject.Esame2k20.webServices;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.AleValeProject.Esame2k20.model.CampoMetaD;
import it.AleValeProject.Esame2k20.model.RecordInfo;
@Service
public interface DataService {

	// Start of user code (user defined attributes for DataService)

	// End of user code

	/**
	 * Description of the method VisulizzaMetadata.
	 */
	public abstract ArrayList<CampoMetaD> VisulizzaMetadata();

	/**
	 * Description of the method VisalizzaData.
	 */
	public abstract ArrayList<RecordInfo> VisalizzaData();

	/**
	 * Description of the method VisulizzaStatistiche.
	 */
	public abstract void VisulizzaStatistiche();

	// Start of user code (user defined methods for DataService)

	// End of user code
}

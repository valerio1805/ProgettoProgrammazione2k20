package it.AleValeProject.Esame2k20.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.AleValeProject.Esame2k20.exception.DeleteFileException;
import it.AleValeProject.Esame2k20.exception.StatsParamException;
import it.AleValeProject.Esame2k20.webServices.DataService;
import it.AleValeProject.Esame2k20.webServices.DataServiceImpl;

/**
 * This class is used to test the exception that is launched when is insered a wrong field 
 * @author Di Biase Alesandro, Donnini Valerio 
 *
 */
class CorrectFieldTests {

	DataServiceImpl ds;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * This is the class to the test what happens if the field is wrong or not
	 * @throws DeleteFileException
	 * @throws StatsParamException
	 */
	@Test
	void test1() throws DeleteFileException, StatsParamException {
		ds=new DataServiceImpl(1);
		
		//if the field is incorrect a StatsParamException is launched
		assertThrows(StatsParamException.class, ()-> ds.RecognizeField("Wrong Field"));
		
		//if the field is correct the function returns the correct field
		assertEquals("height", ds.RecognizeField("\"height\""));
	}


}

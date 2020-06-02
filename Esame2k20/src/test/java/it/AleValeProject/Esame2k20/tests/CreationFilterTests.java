package it.AleValeProject.Esame2k20.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.AleValeProject.Esame2k20.exception.FieldException;
import it.AleValeProject.Esame2k20.exception.FormatException;
import it.AleValeProject.Esame2k20.exception.MismatchTypeFilterException;
import it.AleValeProject.Esame2k20.exception.OperatorException;
import it.AleValeProject.Esame2k20.util.FilterCreation;

/**
 * This is the class to test the excpetions that are launched when the user insered a wrong filter
 * @author Di Biase Alessandro, Donnini Valerio
 *
 */
class CreationFilterTests {

	FilterCreation x = new FilterCreation();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * The test controls if the exceptions returned by the function TranslateFilter is matching with the class that identify the type of error contained in the
	 * filter
	 */
	@Test
	public void testFilterCreation() {
		assertThrows(FormatException.class, ()-> x.TranslateFilter("\"height\":{\"$gte\" : 400}}"));
		assertThrows(FormatException.class,()-> x.TranslateFilter("{\"height\"{\"$lt\" : 600}}"));
		assertThrows(FormatException.class,()-> x.TranslateFilter("{\"height\":\"$bt\" : [300,600]}}"));
		assertThrows(FieldException.class,()-> x.TranslateFilter("{\"ciccio\":{\"$bt\" : [300,600]}}"));
		assertThrows(OperatorException.class,()-> x.TranslateFilter("{\"width\":{\"$biiit\" : [300,600]}}"));
		assertThrows(MismatchTypeFilterException.class,()-> x.TranslateFilter("{\"width\":{\"$bt\" : [aaa,600]}}"));
	}

}

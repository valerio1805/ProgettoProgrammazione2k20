package it.AleValeProject.Esame2k20.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.AleValeProject.Esame2k20.model.SingleFilter;
import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.webServices.DataService;
import it.AleValeProject.Esame2k20.webServices.DataServiceImpl;
import it.AleValeProject.Esame2k20.filtering.*;

/**
 * This class of test is used to control that the function RecognizeOperatorOfFilter returns the correct that of filtering class
 * @author Di biase Alessandro, Donnini Valerio
 *
 */
class CorrectTypeFilteringTests {

	TotalFilters x = new TotalFilters();
	SingleFilter filt = new SingleFilter();
	String[] values = new String[] {"100"};
	ProcessingFilter proc = new ProcessingFilter();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * This is the test to control the type of the filtering that is recognized from the function RecognizeOperatorOfFilter
	 */
	@Test
	void test() {
		x.setMacroOperator("");
		filt.setField("width");
		filt.setValues(values);
		filt.setOperator("$lte");
		x.setAllFilters(filt);
		assertEquals(FilteringLteWidth.class, proc.RecognizeOperatorOfFilter(x.getAllFilters().get(0)).getClass() );
	}

}

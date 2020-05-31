package it.AleValeProject.Esame2k20.util;

import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.exception.*;
import it.AleValeProject.Esame2k20.model.SingleFilter;

/**
 * The class that controls what the user has insered like filter
 * @author valeAle;
 *
 */
public class FilterCreation {
	
	/**
	 * This function control the format of the filter, if all the  '{', '}', ecc are at their right place
	 * If there are some problem, the function launch different exception due to the type of error
	 * If is all ok, a Totalfilters will be created
	 * @param body the filter that added the user
	 * @return a TotalFilters
	 * @throws FieldException
	 * @throws FormatException
	 * @throws OperatorException
	 * @throws MismatchTypeFilterException
	 */
	public TotalFilters TranslateFilter(String body) throws FieldException, FormatException, OperatorException, MismatchTypeFilterException {
		TotalFilters result = new TotalFilters();
		int i =0;
		try {
			// control of the first char of the filter
			if (!body.substring(0, 1).equals("{"))
				throw new FormatException("The start of the field must be \"{\"");
			// control of the macroOperator and set the correct position of i
			String primocampo = RecognizeWord(0, body)[1];
			
			if (primocampo.equals("$or")) {
				result.setMacroOperator("$or");
				i=5;
			}
			else if (primocampo.equals("$and")) {
				result.setMacroOperator("$and");
				i=6;
			}
			else {
				body = "{ [" + body + "] }";
				result.setMacroOperator("");
				i=2;
			}

			// this part is used to fill the array of SingleFilters unless the macroOperator is not ""
			SingleFilter filterToAdd;
			do {
				String[] supportString = new String[2];
				filterToAdd = new SingleFilter();

				// find the field
				supportString = RecognizeWord(i, body);
				filterToAdd.setField(supportString[1]);
				i = Integer.parseInt(supportString[0]);

				// find the operator
				supportString = RecognizeWord(i, body);
				filterToAdd.setOperator(supportString[1]);
				i = Integer.parseInt(supportString[0]);

				// find the values
				if (body.charAt(i) != ':')
					throw new FormatException("There arent't \":\" before the values");
				i++;
				if (body.charAt(i) != ' ')
					throw new FormatException("Between the ':' and the values there must be a space");
				i++;
				// control if there is an array of values
				if (body.charAt(i) == '[') {
					String x = "";
					i++;
					while (body.charAt(i) != ']') {
						x += (body.charAt(i));
						i++;
					}
					filterToAdd.setValues(x.split(","));
					while (body.charAt(i) != '}')
						i++;
				}
				else {
					String supportValue[] = new String[1];
					supportValue[0] = "";
					while (body.charAt(i) != '}') {
						supportValue[0] += (body.charAt(i));
						i++;
					}
					filterToAdd.setValues(supportValue);
				}
				//control to verify the operator the match between the number and the type of values with the operator 
				Check(filterToAdd);
			
				result.setAllFilters(filterToAdd);
				i++;
				
				//control if the filter is ended
				if (body.charAt(i) != '}')
					throw new FormatException("The filter doesn't have a \"}\"");
				i++;

				if (body.charAt(i) == '}' || body.charAt(i + 1) == '}')
					break;

			} while (!result.getMacroOperator().equals(""));
		} catch (StringIndexOutOfBoundsException e) {
			throw new FormatException("The filter is incomplete");
		}
		return result;
	}

	/**
	 * This function recognize the words insered by the user control also the format of the filter
	 * @param position where the function has to start its control of the word
	 * @param body the text to control
	 * @return an Array of all the words found
	 * @throws FormatException
	 */
	private String[] RecognizeWord(int position, String body) throws FormatException {
		String[] result = new String[2];
		try {
			//here the function finds the words that are contained in the filter
			while (body.charAt(position) != '{')
				position++;
			String support = new String();
			while (body.charAt(position) != ':') {
				support += (body.charAt(position));
				position++;
			}
			result[0] = "" + position;
			result[1] = (support.split("\""))[1];
		} catch (Exception e) {
			throw new FormatException("The field doesn't have correctly \"{\" or \":\" ");
		}
		return result;
	}

	/**
	 * This function control the operator that the user has insered, the matching between the operator and the number/the type of values  
	 * @param tocheck
	 * @throws FieldException
	 * @throws FormatException
	 * @throws OperatorException
	 * @throws MismatchTypeFilterException
	 */
	private void Check(SingleFilter tocheck)
			throws FieldException, FormatException, OperatorException, MismatchTypeFilterException {
		// Start of user code for method controllo
		boolean test = false;
		String[] possibleOperator = { "$not", "$in", "$nin", "$bt", "$gt", "$gte", "$lt", "$lte" };
		MetadataCreation possibleField = new MetadataCreation();
		int j = 0;
		for (j = 0; j < 8 && !test; j++) {
			// controll that the operator insered is valid
			if (tocheck.getOperator().equals(possibleOperator[j]))
				test = true;
		}
		j--;
		if (!test)
			throw new OperatorException(tocheck.getOperator());
		//control that the number of values insered are correct for the operator 
		if (j >= 3 && !((j > 3 && tocheck.getValues().size() == 1) || (j == 3 && tocheck.getValues().size() == 2)))
			throw new FormatException(tocheck.getField(), tocheck.getValues().size());
		
		// control that the field insered exists
		int i = 0;
		for (; i < 11 && test; i++) {
			if (possibleField.getMetadata().get(i).getAlias().equals(tocheck.getField()))
				test = false;
		}
		i--;
		if (test)
			throw new FieldException("doesn't exist");
		if (i < 5 || i == 6 || i == 10)
			throw new FieldException("it is no usefull for the field");
		
		// for the field that required a numeric type control that the value/s insered is/are correct
		if (i > 6 && i < 10) {
			try {
				double tryToConvertInNumber;
				for (int x = 0; x < tocheck.getValues().size(); x++)
					tryToConvertInNumber = Double.parseDouble(tocheck.getValues().get(x));
			} catch (NumberFormatException a) {
				throw new MismatchTypeFilterException("Mismatch between operator and value added");
			}
		}
	}
}
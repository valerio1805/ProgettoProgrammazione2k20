package it.AleValeProject.Esame2k20.util;

import it.AleValeProject.Esame2k20.model.TotalFilters;
import it.AleValeProject.Esame2k20.exception.*;
import it.AleValeProject.Esame2k20.model.SingleFilter;

public class FilterCreation {
	/**
	 * Description of the method TranslateFilter.
	 * 
	 * @param body
	 * @throws FilterException
	 */
	public TotalFilters TranslateFilter(String body) throws FieldException, FormatException, OperatorException, MismatchTypeFilterException {
		TotalFilters result = new TotalFilters();
		int i =0;
		try {
			// la prima char deve essere una '{'
			if (!body.substring(0, 1).equals("{"))
				throw new FormatException("The start of the field must be \"{\"");
			// controllo il "macroperatore"
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

			// compilo l'array di classi filter2 finche non leggo }}}, a meno che il
			// macroperatore non sia ""
			SingleFilter filterToAdd;
			do {
				String[] supportString = new String[2];
				filterToAdd = new SingleFilter();

				// trovo il campo
				supportString = RecognizeWord(i, body);
				filterToAdd.setField(supportString[1]);
				i = Integer.parseInt(supportString[0]);

				// trovo l'operatore
				supportString = RecognizeWord(i, body);
				filterToAdd.setOperator(supportString[1]);
				i = Integer.parseInt(supportString[0]);

				// trovo il/i valori
				if (body.charAt(i) != ':')
					throw new FormatException("There arent't \":\" before the values");
				i++;
				if (body.charAt(i) != ' ')
					throw new FormatException("Between the ':' and the values there must be a space");
				i++;
				// in caso ci sia un array
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
				// altrimenti c'� un solo valore
				else {
					String supportValue[] = new String[1];
					supportValue[0] = "";
					while (body.charAt(i) != '}') {
						supportValue[0] += (body.charAt(i));
						i++;
					}
					filterToAdd.setValues(supportValue);
				}
				// prima di aggiungere
				Check(filterToAdd);
				// throw new FilterException("ricontrollare i campi e operatori inseriti e
				// verificare di usare gli operatori con i campi e i valori corretti");
				result.setAllFilters(filterToAdd);
				i++;
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
	 * Description of the method RecognizeWord.
	 * 
	 * @throws FilterException
	 */
	private String[] RecognizeWord(int position, String body) throws FormatException {
		String[] result = new String[2];
		try {
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
	 * Description of the method Check.
	 * 
	 * @throws FilterException
	 */
	private void Check(SingleFilter tocheck)
			throws FieldException, FormatException, OperatorException, MismatchTypeFilterException {
		// Start of user code for method controllo
		boolean test = false;
		String[] possibleOperator = { "$not", "$in", "$nin", "$bt", "$gt", "$gte", "$lt", "$lte" };
		MetadataCreation possibleField = new MetadataCreation();
		int j = 0;
		for (j = 0; j < 8 && !test; j++) {
			// controllo ci sia una corrispondenza tra l'operatore inserito e uno
			// accettabile
			if (tocheck.getOperator().equals(possibleOperator[j]))
				test = true;
			// controllo che siano inseriti un numero esatto di valori
		}
		j--;
		if (!test)
			throw new OperatorException(tocheck.getOperator());
		if (j >= 3 && !((j > 3 && tocheck.getValues().size() == 1) || (j == 3 && tocheck.getValues().size() == 2)))
			throw new FormatException(tocheck.getField(), tocheck.getValues().size());
		// controllo che il campo inserito abbia una corrispondenza con quelli esistenti
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
		// per i campi che richiedono un numero verifico il format
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
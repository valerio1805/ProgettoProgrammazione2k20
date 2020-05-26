package it.AleValeProject.Esame2k20.varie;

import it.AleValeProject.Esame2k20.eccezioni.FilterException;
import it.AleValeProject.Esame2k20.model.FilterField;
import it.AleValeProject.Esame2k20.model.Filter2;

public class CreazioneFiltro {

	// Start of user code (user defined attributes for CreazioneFiltro)

	// End of user code

	/**
	 * The constructor.
	 */
	public CreazioneFiltro() {
		// Start of user code constructor for CreazioneFiltro)
		super();
		// End of user code
	}

	/**
	 * Description of the method FunzioneUniversale.
	 * 
	 * @param body
	 * @throws FilterException 
	 */
	public FilterField RiconosciFiltro(String body) throws FilterException {
		// Start of user code for method FunzioneUniversale
		FilterField result = new FilterField();
		try {
			// la prima char deve essere una '{'
			if (!body.substring(0, 8).equals("filter={"))
				throw new FilterException("l'inizio del filtro deve essere \"filter={\"");
			// elimino la parte "filter="
			body = body.substring(7);
			// controllo il "macroperatore
			System.out.println(body);
			String primocampo = RiconosciStringa(0, body)[1];
			if (primocampo.equals("$or"))
				result.setMacroOperatore("$or");
			else if (primocampo.equals("$and"))
				result.setMacroOperatore("$and");
			else {
				body = "{ [" + body + "] }";
				result.setMacroOperatore("");
			}

			// compilo l'array di classi filter2 finche non leggo }}}, a meno che il
			// macroperatore non sia ""
			int i = 1;
			Filter2 filterdaagg;
			do {
				String[] passaggiointermedio = new String[2];
				filterdaagg = new Filter2();

				// trovo il campo
				passaggiointermedio = RiconosciStringa(i, body);
				filterdaagg.setCampo ( passaggiointermedio[1]);
				i = Integer.parseInt(passaggiointermedio[0]);

				// trovo l'operatore
				passaggiointermedio = RiconosciStringa(i, body);
				filterdaagg.setOperatore ( passaggiointermedio[1]);
				i = Integer.parseInt(passaggiointermedio[0]);

				// trovo il/i valori
				if (body.charAt(i) != ':')
					throw new FilterException("non sono presenti correttamente i \":\" prima dei valori");
				i++;
				if (body.charAt(i) != ' ')
					throw new FilterException("tra i due punti e i valori deve essere presente uno spazio");
				i++;
				//in caso ci sia un array
				if (body.charAt(i) == '[') {
					String x = "";
					i++;
					while (body.charAt(i) != ']') {
						x += (body.charAt(i));
						i++;
					}
					filterdaagg.setValori(x.split(","));
					while (body.charAt(i) != '}')
						i++;
				} 
				//altrimenti c'� un solo valore
				else {
					String x[] = new String[1];
					while (body.charAt(i) != '}') {
						x[0] += (body.charAt(i));
						i++;
					}
					filterdaagg.setValori(x);
				}
				//prima di aggiungere
				if (!Controllo(filterdaagg))
					throw new FilterException("ricontrollare i campi e operatori inseriti e verificare di usare gli operatori con i campi e i valori corretti");
				result.setTuttiIFiltri(filterdaagg);
				i++;
				if (body.charAt(i) != '}')
					throw new FilterException("manca una parantesi graffa \"}\"");
				i++;
				if (body.charAt(i) == '}')
					break;

			} while (!result.getMacroOperatore().equals(""));
		} catch (StringIndexOutOfBoundsException e) {
			throw new FilterException("il filtro inserito non è riconoscibile correttamente");
		}
		return result;
		// End of user code
	}

	/**
	 * Description of the method ricercastringa.
	 */
	public String[] RiconosciStringa(int i, String body) {
		// Start of user code for method ricercastringa
		String[] result = new String[2];
		try {
			while (body.charAt(i) != '{')
				i++;
			String appoggio = new String();
			while (body.charAt(i) != ':') {
				appoggio += (body.charAt(i));
				i++;
			}
			result[0] = "" + i;
			result[1] = (appoggio.split("\""))[1];
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("ERRORE SCRITTURA 4");
		}
		return result;
		// End of user code
	}

	/**
	 * Description of the method controllo.
	 */
	public boolean Controllo(Filter2 tocheck) {
		// Start of user code for method controllo
		boolean[] test = { false, false };
		String[] operatoripossibili = { "$not", "$in", "$nin", "$bt", "$gt", "$gte", "$lt", "$lte" };
		MetaData campipossibili = new MetaData();
		int j = 0;
		
		for (j = 0; j < 8 && !test[0]; j++) {
			//controllo ci sia una corrispondenza tra l'operatore inserito e uno accettabile
			if (tocheck.getOperatore().equals(operatoripossibili[j]))
				test[0] = true;
			//controllo che siano inseriti un numero esatto di valori
			if (test[0]&&(!((j > 3 && tocheck.getValori().size() == 1) || (j==3&&tocheck.getValori().size() == 2))))
				test[0] = false;
		}
		//controllo che il campo inserito abbia una corrispondenza con quelli esistenti
		for (int i = 0; i < 11 && !test[1]; i++) {
			if (campipossibili.getMetaDati().get(i).getAlias().equals(tocheck.getCampo()))
				test[1] = true;
			//per i campi che richiedono un numero verifico il format
			if ((test[1]) &&(i >= 2 && i <= 5 || i == 8 || i == 10)){
				try {
					double isitanumber;
					for (int x = 1; x < tocheck.getValori().size(); x++)
						isitanumber = Double.parseDouble(tocheck.getValori().get(x));
				} catch (NumberFormatException a) {
					test[1] = false;
				}
			}
			test[1] = false;
		}
		//solo se rispetto entrambi i controlli ritorno true
		return test[0] && test[1];
		// End of user code
	}

	// Start of user code (user defined methods for CreazioneFiltro)

	// End of user code
}
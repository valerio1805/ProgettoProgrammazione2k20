package it.AleValeProject.Esame2k20.varie;

import filtro.FilterException;
import model.Filterfields;
import model.filter2;
import varie.MetaData;

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
	 */
	public void FunzioneUniversale(String body) {
		// Start of user code for method FunzioneUniversale
		Filterfields result = new Filterfields();
		try {
			// la prima char deve essere una '{'
			if (!body.substring(0, 8).equals("filter={"))
				throw new FilterException(0);// System.out.println("ERRORE SCRITTURA 0");
			// elimino la parte "filter="
			body = body.substring(7);
			// controllo il "macroperatore
			System.out.println(body);
			String primocampo = riconoscistringa(0, body)[1];
			if (primocampo.equals("$or"))
				result.macroperatore = "$or";
			else if (primocampo.equals("$and"))
				result.macroperatore = "$and";
			else {
				body = "{ [" + body + "] }";
				result.macroperatore = "";
			}

			// compilo l'array di classi filter2 finche non leggo }}}, a meno che il
			// macroperatore non sia ""
			int i = 1;
			filter2 filterdaagg;
			do {
				String[] passaggiointermedio = new String[2];
				filterdaagg = new filter2();

				// trovo il campo
				passaggiointermedio = riconoscistringa(i, body);
				filterdaagg.campo = passaggiointermedio[1];
				i = Integer.parseInt(passaggiointermedio[0]);

				// trovo l'operatore
				passaggiointermedio = riconoscistringa(i, body);
				filterdaagg.operatore = passaggiointermedio[1];
				i = Integer.parseInt(passaggiointermedio[0]);

				// trovo il/i valori
				if (body.charAt(i) != ':')
					System.out.println("ERRORE SCRITTURA 1");
				i++;
				if (body.charAt(i) != ' ')
					System.out.println("ERRORE SCRITTURA 2");
				i++;
				if (body.charAt(i) == '[') {
					String x = "";
					i++;
					while (body.charAt(i) != ']') {
						x += (body.charAt(i));
						i++;
					}
					filterdaagg.valori = x.split(",");
					while (body.charAt(i) != '}')
						i++;
				} else {
					String x = "";
					while (body.charAt(i) != '}') {
						x += (body.charAt(i));
						i++;
					}
					filterdaagg.valori = new String[1];
					filterdaagg.valori[0] = x;
				}
				if (!Controllo(filterdaagg))
					throw new FilterException(10);
				result.tuttiifiltri.add(filterdaagg);
				i++;
				if (body.charAt(i) != '}')
					System.out.println("ERRORE SCRITTURA 3");
				i++;
				if (body.charAt(i) == '}')
					break;

			} while (!result.macroperatore.equals(""));
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("ERRORE SCRITTURA 4");
		}
		return result;
		// End of user code
	}

	/**
	 * Description of the method ricercastringa.
	 */
	public String[] ricercastringa(String body) {
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
	public void controllo() {
		// Start of user code for method controllo
		boolean[] test = { false, false };
		String[] operatoripossibili = { "$not", "$in", "$nin", "$bt", "$gt", "$gte", "$lt", "$lte" };
		MetaData campipossibili = new MetaData();
		int j = 0;
		//controllo ci sia una corrispondenza tra l'operatore inserito e uno accettabile
		for (j = 0; j < 8 && !test[0]; j++) {
			if (tocheck.operatore.equals(operatoripossibili[j]))
				test[0] = true;
			// se c'è corrispondenza, ed è necessario il controllo, verifico che i valori immessi rispettino il format richiesto
			if (j >= 3 && test[0]) {
				if (!((j > 3 && tocheck.valori.length == 1) || tocheck.valori.length == 2))
					test[0] = false;
				try {
					int isitanumber;
					for (int i = 1; i < tocheck.valori.length; i++)
						isitanumber = Integer.parseInt(tocheck.valori[i - 1]);
				} catch (NumberFormatException a) {
					test[0] = false;
				}
			}
		}
		//controllo che il campo inserito abbia una corrispondenza con quelli esistenti
		for (int i = 0; i < 11 && !test[1]; i++) {
			if (campipossibili.metaDati.get(i).getAlias().equals(tocheck.campo))
				test[1] = true;
			//se c'è corrispondenza e il campo richiedo come tipo stringhe e il filtro presenta operatori matematici ho una eccezione
			if ((test[1]) &&(i >= 2 && i <= 5 || i == 8 || i == 10)&& (j > 2))
				test[1] = false;
		}
		//solo se rispetto entrambi i controlli ritorno true
		return test[0] && test[1];
		// End of user code
	}

	// Start of user code (user defined methods for CreazioneFiltro)

	// End of user code
}
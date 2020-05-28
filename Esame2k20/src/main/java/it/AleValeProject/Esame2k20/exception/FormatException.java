package it.AleValeProject.Esame2k20.exception;

public class FormatException extends Exception {
	public FormatException(String wrongField, int wrongValue) {
		super("Per il campo "+wrongField+" non è valida l'espressione: il numero di parametri inseriti è errato ("+wrongValue+")");
		//new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filtro scritto male");
	}
	public FormatException(String toDisplay) {
		super (toDisplay);
	}
}

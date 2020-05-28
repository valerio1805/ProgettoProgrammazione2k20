package it.AleValeProject.Esame2k20.exception;

public class OperatorException extends Exception {
	public OperatorException(String wrongOperator) {
		super("L'operatore "+wrongOperator+" non è corretto");
	}


}

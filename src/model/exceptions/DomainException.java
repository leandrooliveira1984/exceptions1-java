package model.exceptions;

public class DomainException extends RuntimeException {// tbem pode ser RunTimeException (não obriga tratar a exceção)

	private static final long serialVersionUID = 1L; 
	
	public DomainException(String msg) {
		super (msg); // este comando é necessário para que seja instanciado a exceção passando a mensagem de erro
	}
}

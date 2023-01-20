package model.exceptions;

public class DomainException extends RuntimeException {// tbem pode ser RunTimeException (n�o obriga tratar a exce��o)

	private static final long serialVersionUID = 1L; 
	
	public DomainException(String msg) {
		super (msg); // este comando � necess�rio para que seja instanciado a exce��o passando a mensagem de erro
	}
}

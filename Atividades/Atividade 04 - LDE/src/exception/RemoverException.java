package exception;

public class RemoverException extends Exception{
	
	public RemoverException() {
		super("Lista vazia! ");
	}
	
	public void valorNaoEncontrado() {
		System.out.println("Valor n�o encontrado !");
	}
}

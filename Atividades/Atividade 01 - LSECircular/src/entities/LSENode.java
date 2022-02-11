package entities;

public class LSENode<T extends Comparable<T>> {
	
	private T informacao;
	private LSENode<T> proximo;
	
	LSENode(T valor) {
		informacao = valor;
	}
	
	T getInformacao() {
		return informacao;
	}
	
	void setInformacao(T valor) {
		informacao = valor;
	}
	
	void setProximo(LSENode<T> valor) {
		proximo = valor;
	}
	
	LSENode<T> getProximo() {
		return proximo;
	}
}

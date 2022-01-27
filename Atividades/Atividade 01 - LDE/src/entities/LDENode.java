package entities;

public class LDENode<T extends Comparable<T>> {
	private T informacao;
	private LDENode<T> proximo;
	private LDENode<T> anterior;
	
	LDENode(T informacao) {
		this.informacao = informacao;
	}
	
	T getInformacao() {
		return informacao;
	}
	
	void setInformacao(T novoValor) {
		informacao = novoValor;
	}
	
	LDENode<T> getProximo() {
		return proximo;
	}
	
	void setProximo(LDENode<T> novoValor) {
		proximo = novoValor;
	}
	
	LDENode<T> getAnterior() {
		return anterior;
	}
	
	void setAnterior(LDENode<T> novoValor) {
		anterior = novoValor;
	}
}

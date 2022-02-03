package entities;

public class LDENode <T extends Comparable<T>>{

	private T informacao;
	private LDENode<T> proximo;
	private LDENode<T> anterior;
	
	LDENode(T info) {
		informacao = info; 
	}
	
	T getInformacao() {
		return informacao;
	}
	
	void setInformacao(T valor) {
		informacao = valor;
	}
	
	LDENode<T> getProximo() {
		return this.proximo;
	}
	
	void setProximo(LDENode<T> valor) {
		proximo = valor;
	}
	
	LDENode<T> getAnterior() {
		return anterior;
	}
	
	void setAnterior(LDENode<T> valor) {
		anterior = valor;
	}
}

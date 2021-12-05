package entities.listas;

public class LSENode<T extends Comparable<T>> {
	private T info;
	private LSENode<T> prox;
	
	LSENode(T valor) {
		info = valor;
	}
	
	T getInfo() {
		return info;
	}
	
	void setInfo(T valor) {
		info = valor;
	}
	
	T getProx() {
		return info;
	}
	
	void setProx(LSENode<T> valor) {
		prox = valor;
	}
}

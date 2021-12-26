package entities;

public class LSENode<T extends Comparable<T>> {
	
	private T info;
	private LSENode<T> prox;
	
	LSENode(T info) {
		this.info = info;
	}
	
	T getInfo() {
		return info;
	}
	
	void setInfo(T novo) {
		info = novo;
	}
	
	LSENode<T> getProx() {
		return prox;
	}
	
	void setProx(LSENode<T> novo) {
		prox = novo;
	}
}
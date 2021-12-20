package entities;

public class LSENode<T extends Comparable<T>> {
	
	private T info;
	private LSENode<T> prox;
	
	LSENode(T info) {
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public LSENode<T> getProx() {
		return prox;
	}

	public void setProx(LSENode<T> prox) {
		this.prox = prox;
	}
	
}

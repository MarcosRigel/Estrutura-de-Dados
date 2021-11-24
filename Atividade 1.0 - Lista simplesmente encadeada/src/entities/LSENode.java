package entities;

public class LSENode <T> {
	private T info;
	private LSENode<T> prox;
	
	LSENode (T valor) {
		info = valor;
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
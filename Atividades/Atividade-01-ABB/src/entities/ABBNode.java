package entities;

public class ABBNode <T extends Comparable<T>> {
	
	private T informacao;
	private ABBNode<T> esquerda;
	private ABBNode<T> direita;
	
	ABBNode(T informacao) {
		this.informacao = informacao;
	}
	
	T getInformacao() {
		return informacao;
	}
	
	void setInformacao(T informacao) {
		this.informacao = informacao;
	}
	
	ABBNode<T> getEsquerda() {
		return esquerda;
	}
	
	void setEsquerda(ABBNode<T> esquerda) {
		this.esquerda = esquerda;
	}
	
	ABBNode<T> getDireita() {
		return direita;
	}
	
	void setDireita(ABBNode<T> direita) {
		this.direita = direita;
	}
	
	void insertNode(T value) {
        if (value.compareTo(this.getInformacao()) == 0) {
            System.out.println("Valor repetido.");
        } else if (value.compareTo(this.getInformacao()) < 0) {
            if (esquerda == null) {
                esquerda = new ABBNode(value);
            } else {
                esquerda.insertNode(value); 
            }
        } else {
            if (direita == null) {
                direita = new ABBNode(value);
            } else {
                direita.insertNode(value);
            }
        }
    }
}

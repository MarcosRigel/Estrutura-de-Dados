package entities;

public class LSECircular<T extends Comparable<T>> {
		
	private LSENode<T> primeiro;
	private LSENode<T> ultimo;
	private int quantidade;
	
	public boolean isEmpty() {
		return quantidade == 0;
	}
	
	public void inserirValorFinal(T valor) {
		LSENode<T> novo = new LSENode(valor);
		if (isEmpty()) {
			primeiro = novo;
			ultimo = novo;
			ultimo.setProximo(novo);
			quantidade++;
		}
		else {
			ultimo.setProximo(novo);
			ultimo = novo;
			ultimo.setProximo(primeiro);
			quantidade++;
		}
		System.out.println("Valor Inserido Com Sucesso!");
	}
	
	public void inserirValorInicio(T valor) {
		LSENode<T> novo = new LSENode(valor);
		if (isEmpty()) {
			primeiro = novo;
			ultimo = novo;
			ultimo.setProximo(primeiro);
			quantidade++;
		}
		else {
			novo.setProximo(primeiro);
			primeiro = novo;
			ultimo.setProximo(primeiro);
			quantidade++;
		}
		System.out.println("Valor Inserido Com Sucesso!");
	}
	
	public void removerInicio() {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		}
		else if (quantidade == 1) {
			primeiro = null;
			quantidade = 0;
			System.out.println("Valor Removido Com Sucesso, Lista vazia!");
		}
		else {
			primeiro = primeiro.getProximo();
			ultimo.setProximo(primeiro);
			quantidade--;
			System.out.println("Valor Removido");
		}
	}
	
	public void removerFinal() {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		}
		else if (quantidade == 1) {
			primeiro = null;
			quantidade = 0;
			System.out.println("Valor Removido Com Sucesso, Lista vazia!");
		}
		else {
			LSENode<T> auxiliar = primeiro;
			LSENode<T> anterior = primeiro;
			for (int i=0; i < quantidade; i++) {
				anterior = auxiliar;
				if (auxiliar != ultimo) {
					auxiliar = auxiliar.getProximo();
				}
			}
			ultimo = anterior;
			ultimo.setProximo(primeiro);
			quantidade--;
			System.out.println("Valor Removido Com Sucesso!");
		}
	}
	
	public void exibir() {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		}
		else {
			LSENode<T> auxiliar = primeiro;
			do {
				System.out.println(auxiliar.getInformacao() + " ");
				auxiliar = auxiliar.getProximo();
			} while (auxiliar != primeiro);
		}
 	}
	
	public int quantidadeValor(T valor) {
		int quantidade = 0;
		if(isEmpty()) {
			return 0;
		}
		else {
			LSENode<T> auxiliar = primeiro;
			for(int i=0; i < this.quantidade; i++) {
				if (auxiliar.getInformacao().compareTo(valor) == 0) {
					quantidade++;
				}
				auxiliar = auxiliar.getProximo();
			}
		}
		return quantidade;
	}
}

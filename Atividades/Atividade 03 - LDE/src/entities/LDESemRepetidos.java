package entities;

public class LDESemRepetidos<T extends Comparable<T>> {

	private LDENode<T> primeiro;
	private LDENode<T> ultimo;
	private int quantidade;
	
	public boolean isEmpty() {
		return quantidade == 0;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void inserirValor(T valor) {
		
		LDENode<T> novo = new LDENode(valor);
		
		if (isEmpty()) {
			primeiro = novo;
			ultimo = novo;
			quantidade++;
			System.out.println("Valor inserido com sucesso!");
		}
		else {
			if (buscar(valor) != null) {
				System.out.println("Valor repetido!");
			}
			else {
				ultimo.setProximo(novo);
				novo.setAnterior(ultimo);
				ultimo = novo;
				quantidade++;
				System.out.println("Valor inserido com sucesso!");
			}
		}
	}
	
	public void exibir() {
		
		LDENode<T> auxiliar = primeiro;
		
		while (auxiliar != null) {
			System.out.println(auxiliar.getInformacao() + " ");
			auxiliar = auxiliar.getProximo();
		}
		System.out.println();
	}
	
	private LDENode<T> buscar(T novo) {
		
		LDENode<T> valor = new LDENode(novo);
		LDENode<T> auxiliar = primeiro;
		
		while (auxiliar != null) {
			if (auxiliar.getInformacao().compareTo(valor.getInformacao()) == 0) {
				return auxiliar;
			}
			else {
				auxiliar = auxiliar.getProximo();
			}
		}
		return null;
	}
	
	public void removerValor(T valor) {
		if (quantidade == 1) {
			primeiro = null;
			ultimo = null;
			quantidade--;
		}
		else {
			LDENode<T> novo = new LDENode(valor);
			if (primeiro.getInformacao().compareTo(novo.getInformacao()) == 0) {
				primeiro = primeiro.getProximo();
				primeiro.setAnterior(null);
				quantidade--;
			}
			else if (ultimo.getInformacao().compareTo(novo.getInformacao()) == 0) {
				ultimo = ultimo.getAnterior();
				ultimo.setProximo(null);
				quantidade--;
			}
			else {
				novo.getAnterior().setProximo(novo.getProximo());
				novo.getAnterior().setAnterior(novo.getAnterior());
				quantidade--;
			}
		}
	}
	
	public LDESemRepetidos ordenar(char opcao) {
		
		LDESemRepetidos novo = new LDESemRepetidos();
		LDENode<T> auxiliar = primeiro;
		
		if (opcao == 'c') {
			while (auxiliar != null) {
				novo.inserirValorCescente(auxiliar.getInformacao());
				this.removerValor(auxiliar.getInformacao());
				auxiliar = auxiliar.getProximo();
			}
		}
		else {
			while (auxiliar != null) {
				novo.inserirValorDecrescente(auxiliar.getInformacao());
				this.removerValor(auxiliar.getInformacao());
				auxiliar = auxiliar.getProximo();
			}
		}
		return novo;
	}
	
	private void inserirValorCescente(T valor) {
		
		LDENode<T> novo = new LDENode(valor);
		
		if (isEmpty()) {
			primeiro = novo;
			ultimo = novo;
			quantidade++;
		}
		else if (novo.getInformacao().compareTo(primeiro.getInformacao()) < 0) {
			novo.setProximo(primeiro);
			primeiro.setAnterior(novo);
			primeiro = novo;
			quantidade++;
		}
		else if (novo.getInformacao().compareTo(ultimo.getInformacao()) > 0) {
			ultimo.setProximo(novo);
			novo.setAnterior(ultimo);
			ultimo = novo;
			ultimo.setProximo(null);
			quantidade++;
		}
		else {
			LDENode<T> atual = primeiro;
			while (atual != null) {
				if (novo.getInformacao().compareTo(atual.getInformacao()) < 0) {
					atual.getAnterior().setProximo(novo);
					novo.setProximo(atual);
					novo.setAnterior(atual.getAnterior());
					quantidade++;
					return;
				}
				else {
					atual = atual.getProximo();
				}
			}
		}
	}
	
	private void inserirValorDecrescente(T valor) {
		
		LDENode<T> novo = new LDENode(valor);
		
		if (isEmpty()) {
			primeiro = novo;
			ultimo = novo;
			quantidade++;
		}
		else if (novo.getInformacao().compareTo(primeiro.getInformacao()) > 0) {
			novo.setProximo(primeiro);
			primeiro.setAnterior(novo);
			primeiro = novo;
			quantidade++;
		}
		else if (novo.getInformacao().compareTo(ultimo.getInformacao()) < 0) {
			ultimo.setProximo(novo);
			novo.setAnterior(ultimo);
			ultimo = novo;
			ultimo.setProximo(null);
			quantidade++;
		}
		else {
			LDENode<T> atual = primeiro;
			while (atual != null) {
				if (novo.getInformacao().compareTo(atual.getInformacao()) > 0) {
					atual.getAnterior().setProximo(novo);
					novo.setProximo(atual);
					novo.setAnterior(atual.getAnterior());
					quantidade++;
					return;
				}
				else {
					atual = atual.getProximo();
				}
			}
		}
	}
}

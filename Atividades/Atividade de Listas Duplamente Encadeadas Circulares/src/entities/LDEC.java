package entities;

import Excecao.*;

public class LDEC<T extends Comparable<T>> {
	
	private LDENode<T> primeiro;
	private LDENode<T> ultimo;
	private int quantidade;
	
	public boolean isEmpty() {
		return quantidade == 0;
	}
	
	public void inserirFinal (T valor) throws ValorRepetido {
		LDENode<T> novo = new LDENode(valor);
		
		if (isEmpty()) {
			primeiro = novo;
			primeiro.setAnterior(ultimo);
			ultimo = novo;
			ultimo.setProximo(primeiro);
			quantidade++;
		}
		else {
			ultimo.setProximo(novo);
			novo.setAnterior(ultimo);
			ultimo = novo;
			ultimo.setProximo(primeiro);
			primeiro.setAnterior(ultimo);
			quantidade++;
		}
	}
	
	public void inserirFinalC(T valor) {
		LDENode<T> novo = new LDENode(valor);
		ultimo.setProximo(novo);
		novo.setAnterior(ultimo);
		ultimo = novo;
		ultimo.setProximo(primeiro);
		quantidade++;
	}
	
	public void inserirFinalD(T valor) {
		LDENode<T> novo = new LDENode(valor);
		if (isEmpty()) {
			primeiro = novo;
			ultimo = novo;
			ultimo.setAnterior(primeiro);
			primeiro.setAnterior(ultimo);
			ultimo.setProximo(primeiro);
			quantidade++;
		}
		else {
			ultimo.setProximo(novo);
			novo.setAnterior(ultimo);
			ultimo = novo;
			ultimo.setProximo(primeiro);
			quantidade++;
		}
	}
	
	public void concatenar(LDEC<T> valor) {
		if (isEmpty()) {
			System.out.println("vazia");
		}
		else {
			ultimo.setProximo(valor.primeiro);
			ultimo = valor.ultimo;
			ultimo.setProximo(primeiro);
			primeiro.setAnterior(ultimo);
			quantidade = quantidade + valor.quantidade;
			valor.primeiro = null;
			valor.ultimo = null;
			valor.quantidade = 0;
		}
	}
	
	public LDEC dividir() throws ListaComUmValor, ListaVazia {
		LDEC novo = new LDEC();
		if (isEmpty()) {
			throw new ListaVazia();
		}
		else if (quantidade == 1) {
			throw new ListaComUmValor();
		}
		else {
			LDENode<T> inicio = primeiro, ultimo = this.ultimo;
			int metade = quantidade/2;
			for (int i = 1; i <= metade; i++) {
				inicio = inicio.getProximo();
			}
			ultimo = inicio.getAnterior();
			ultimo.setProximo(primeiro);
			primeiro.setAnterior(ultimo);
			novo.primeiro = inicio;
			novo.ultimo = ultimo;
			novo.ultimo.setProximo(novo.primeiro);
			novo.primeiro.setAnterior(novo.ultimo);
			novo.quantidade = quantidade - metade;
			quantidade = metade;
			return novo;
		}
	}
	
	public void exibirLista() throws ListaVazia {
		if (isEmpty()) {
			throw new ListaVazia();
		}
		else {
			LDENode<T> auxiliar = primeiro;
			do {
				System.out.println(auxiliar.getInformacao() + " ");
				auxiliar = auxiliar.getProximo();
			} while (auxiliar != primeiro);
			System.out.println();
		}
	}
	
	private void removerPrimeiro() {
		if (quantidade == 1) {
			primeiro = null;
			ultimo = null;
			quantidade = 0;
		}
		else {
			primeiro = primeiro.getProximo();
			primeiro.setAnterior(ultimo);
			ultimo.setProximo(primeiro);
			quantidade--;
		}
	}
}
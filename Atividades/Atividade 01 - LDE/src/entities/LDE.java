package entities;

public class LDE<T extends Comparable<T>> {
	private LDENode<T> primeiro;
	private LDENode<T> ultimo;
	private int quantidade;
	
	public boolean isEmpty() {
		return quantidade == 0;
	}
	
	public void inserirValorInicio (T valor) {
		
		LDENode<T> novoValor = new LDENode(valor);
		
		if (isEmpty()) {
			primeiro = novoValor;
			ultimo = novoValor;
			quantidade++;
			System.out.println("Valor inserido!");
		}
		else {
			novoValor.setProximo(primeiro);
			novoValor.getProximo().setAnterior(novoValor);
			primeiro = novoValor;
			quantidade++;
			System.out.println("Valor inserido no inicio da lista!");
		}
	}
	
	public void inserirValorFinal (T valor) {
		
		LDENode<T> novoValor = new LDENode(valor);
		
		if (isEmpty()) {
			primeiro = novoValor;
			ultimo = novoValor;
			ultimo.setAnterior(primeiro);
			quantidade++;
			System.out.println("Valor inserido!");
		}
		else {
			ultimo.setProximo(novoValor);
			novoValor.setAnterior(ultimo);
			ultimo = novoValor;
			quantidade++;
			System.out.println("Valor inserido no final da lista!");
		}
	}
	
	public void removerValorInicio() {
		if (isEmpty()) {
			System.out.println("Lista Vazia!");
		}
		else if (quantidade == 1) {
			primeiro = null;
			ultimo = null;
			quantidade--;
			System.out.println("Valor removido com sucesso, Lista vazia!");
		}
		else {
			primeiro = primeiro.getProximo();
			primeiro.setAnterior(null);
			quantidade--;
			System.out.println("valor removido com sucesso");
		}
	}
	
	public void removerValorFinal() {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		}
		else if (quantidade == 1) {
			primeiro = null;
			ultimo = null;
			quantidade--;
			System.out.println("Valor removido com sucesso, Lista vazia!");
		}
		else {
			ultimo = ultimo.getAnterior();
			ultimo.setProximo(null);
			quantidade--;
			System.out.println("Valor removido com sucesso!");
		}
	}
	
	public void exibirLista() {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		}
		else {
			LDENode<T> auxiliar = primeiro;
			while (auxiliar != null) {
				System.out.println(auxiliar.getInformacao() + " ");
				auxiliar = auxiliar.getProximo();
			}
			System.out.println();
		}
	}
}

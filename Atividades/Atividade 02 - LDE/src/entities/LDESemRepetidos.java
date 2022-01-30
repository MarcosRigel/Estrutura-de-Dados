package entities;

public class LDESemRepetidos <T extends Comparable<T>>{

	private LDENode<T> primeiro;
	private LDENode<T> ultimo;
	private int quantidade;
	
	public boolean isEmpty() {
		return quantidade == 0;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void cadastrarPessoa(T rg) {
		LDENode<T> pessoa = new LDENode(rg);
		if (isEmpty()) {
			primeiro = pessoa;
			ultimo = pessoa;
			quantidade++;
			System.out.println("Primeiro cadastro realizado!");
		}
		else {
			if (buscarPessoa(rg) != null) {
				System.out.println("Cadastro ja registrado!");
			}
			else {
				ultimo.setProximo(pessoa);
				pessoa.setAnterior(ultimo);
				ultimo = pessoa;
				quantidade++;
				System.out.println("Cadastro realizado!");
			}
		}
	}
	
	public void removerPessoa(T rg) {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		}
		else if (quantidade == 1) {
			LDENode<T> pessoa = new LDENode(rg);
			if (primeiro.getInformacao().compareTo(pessoa.getInformacao()) == 0) {
				primeiro = null;
				ultimo = null;
				quantidade--;
				System.out.println("Cadastro removido");
			}
			else {
				System.out.println("Cadastro não encontrado!");
			}
		}
		else {
			LDENode<T> pessoa = buscarPessoa(rg);
			if (pessoa != null) {
				if (primeiro.getInformacao().compareTo(pessoa.getInformacao()) == 0) {
					primeiro = primeiro.getProximo();
					primeiro.setAnterior(null);
					quantidade--;
				}
				else if (ultimo.getInformacao().compareTo(pessoa.getInformacao()) == 0) {
					ultimo = ultimo.getAnterior();
					ultimo.setProximo(null);
					quantidade--;
				}
				else {
					pessoa.getAnterior().setProximo(pessoa.getProximo());
					pessoa.getProximo().setAnterior(pessoa.getAnterior());
					quantidade--;
				}
				System.out.println("Cadastro removido!");
			}
			else {
				System.out.println("Cadastro não encontrado!");
			}
		}
	}
	
	public void exibirPessoas() {
		if (isEmpty()) {
			System.out.println("Lista vazia!");
		}
		else {
			LDENode<T> auxiliar = primeiro;
			while (auxiliar != null) {
				System.out.println(auxiliar.getInformacao());
				auxiliar = auxiliar.getProximo();
			}
		}
	}
	
	public LDENode<T> buscarPessoa(T rg) {
		LDENode<T> valor = new LDENode(rg);
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
	
	public boolean verificarRg(T rg) {
		LDENode<T> achou = buscarPessoa(rg);
		return achou != null;
	}
}

package entities;

public class LSESemRepetidos<T extends Comparable<T>> {
	
	private LSENode<T> primeiro;
	private LSENode<T> ultimo;
	private int quantidade;
	
	public void inserirCliente(T cliente) {
		LSENode<T> novo = new LSENode(cliente);
		
		if (quantidade == 0) {
			primeiro = novo;
			ultimo = novo;
			quantidade++;
			System.out.println();
			System.out.println("Cliente cadastrado!");
			System.out.println();

		}
		else {
			ultimo.setProx(novo);
			ultimo = novo;
			quantidade++;
			System.out.println();
			System.out.println("Cliente cadastrado!");
			System.out.println();
		}
	}
	
	public void exibirCliente() {
		if (quantidade == 0) {
			System.out.println();
			System.out.println("Lista de clientes vazia!");
			System.out.println();
		} 
		else {
			LSENode<T> auxiliar = primeiro;
			for (int i = 0; i < quantidade; i++) {
				System.out.println(auxiliar.getInfo().toString());
				auxiliar = auxiliar.getProx();
			}
		}
	}
	
	private LSENode<T> buscarNo(T cliente) {
		LSENode<T> auxiliar = primeiro;
		T auxiliarCliente = auxiliar.getInfo();
		for (int i=0;i<quantidade;i++) {
			if (auxiliarCliente.compareTo(cliente) == 0) {
				return auxiliar;
			}
			auxiliar = auxiliar.getProx();
		}
		return null;
	}
	
	public T buscarCliente(T cliente) {
		LSENode<T> auxiliar;
		if (quantidade == 0) {
			return null;
		}
		else {
			auxiliar = buscarNo(cliente);
			if (auxiliar == null) {
				return null;
			}
			else {
				return auxiliar.getInfo();
			}
		}
	}
	
	public void removerCliente(T cliente) {
		LSENode<T> achou = buscarNo(cliente);
		
		if (achou == null) {
			System.out.println();
			System.out.println("Cliente não cadastrado!");
			System.out.println();
		}
		else {
			if (quantidade == 0) {
				System.out.println();
				System.out.println("Lista de clientes vazia!");
				System.out.println();
			}
			else if (quantidade == 1) {
				primeiro = null;
				ultimo = null;
				quantidade--;
				System.out.println();
				System.out.println("Cliente Removido Com Sucesso!");
				System.out.println();
			}
			else if (achou.getInfo().compareTo(primeiro.getInfo()) == 0) {
				primeiro = primeiro.getProx();
				quantidade--;
				System.out.println();
				System.out.println("Cliente Removido Com Sucesso!");
				System.out.println();
			}
			else if (achou.getInfo().compareTo(ultimo.getInfo()) == 0) {
				LSENode<T> auxiliar = primeiro;
				while (auxiliar != ultimo) {
					auxiliar = auxiliar.getProx();
				}
				ultimo = auxiliar;
				quantidade--;
				System.out.println();
				System.out.println("Cliente Removido Com Sucesso!");
				System.out.println();
			}
			else {
				LSENode<T> auxiliar = primeiro;
				LSENode<T> auxiliar2 = primeiro.getProx();
				for (int i = 1; i < quantidade - 1; i++) {
					if (achou == auxiliar2) {
						break;
					}
					auxiliar = auxiliar.getProx();
					auxiliar2 = auxiliar2.getProx();
				}
				auxiliar.setProx(auxiliar2.getProx());
				quantidade--;
				System.out.println();
				System.out.println("Cliente Removido com Sucesso!");
				System.out.println();
			}
		}
	}
}

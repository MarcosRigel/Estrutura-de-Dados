package entities;

public class LSESemRepetidos<T extends Comparable<T>> {
	
	private LSENode<T> primeiro;
	private LSENode<T> ultimo;
	private int quantidade;
	
	public void inserirContato(T contato) {
		LSENode<T> novo = new LSENode(contato);
		if (quantidade == 0) {
			primeiro = novo;
			ultimo = novo;
			quantidade++;
			System.out.println("Contato cadastrado");
		}
		else if (novo.getInfo().compareTo(primeiro.getInfo()) < 0) {
			novo.setProx(primeiro);
			primeiro = novo;
			quantidade++;
			System.out.println("Contato cadastrado no inicio da lista !");
		}
		else if (novo.getInfo().compareTo(ultimo.getInfo()) > 0) {
			ultimo.setProx(novo);
			ultimo = novo;
			quantidade++;
			System.out.println("Contato cadastrado no final da lista !");
		}
		else {
			LSENode<T> atual = primeiro;
			LSENode<T> anterior = primeiro;
			while (atual != null) {
				if (novo.getInfo().compareTo(atual.getInfo()) == 0) {
					System.out.println("Contato reperido!");
					return;
				}
				else if (novo.getInfo().compareTo(atual.getInfo()) < 0) {
					anterior.setProx(novo);
					novo.setProx(atual);
					quantidade++;
					System.out.println("Contato cadastrado !");
					return;
				}
				else {
					anterior = atual;
					atual = atual.getProx();
				}
			}
		}
	}
	
	public void exibirContatos() {
		if (quantidade == 0) {
			System.out.println("Agenda vazia !");
		}
		else {
			LSENode<T> auxiliar = primeiro;
			for (int i=0; i< quantidade; i++) {
				System.out.println(auxiliar.getInfo());
				auxiliar = auxiliar.getProx();
			}
		}
	}
	
	public LSENode<T> buscar(T contato) {
		LSENode<T> auxiliar = primeiro;
		while(auxiliar != null) {
			if (contato.compareTo(auxiliar.getInfo()) == 0) {
				return auxiliar;
			}
			auxiliar = auxiliar.getProx();
		}
		return null;
	}
	
	public T buscarContato(T contato) {
		LSENode<T> retorno;
		if (quantidade == 0) {
			return null;
		}
		else {
			retorno = buscar(contato);
			if (retorno == null) {
				return null;
			}
			else {
				return retorno.getInfo();
			}
		}
	}
	
	public void removerContato(T contato) {
		if (quantidade == 0) {
			System.out.println("Agenda sem contatos!");
		}
		else {
			int _primeiro = contato.compareTo(primeiro.getInfo());
			int _ultimo = contato.compareTo(ultimo.getInfo());
			
			if (_primeiro < 0 || _ultimo > 0) {
				System.out.println("Contato não encontrado !");
			}
			if (quantidade == 1) {
				primeiro = null;
				ultimo = null;
				quantidade--;
				System.out.println("Contato removido");
			}
			else if (contato.compareTo(primeiro.getInfo()) == 0) {
				primeiro = primeiro.getProx();
				quantidade--;
				System.out.println("Primeiro contato removido !");
			}
			else if (contato.compareTo(ultimo.getInfo()) == 0) {
				LSENode<T> auxiliar = primeiro;
				while (auxiliar.getProx() != ultimo) {
					auxiliar = auxiliar.getProx();
				}
				auxiliar.setProx(null);
				ultimo = auxiliar;
				quantidade--;
				System.out.println("Ultimo contato removido !");
			}
			else {
				LSENode<T> atual = primeiro.getProx();
				LSENode<T> anterior = primeiro;
				while (atual.getProx() != null) {
					if (contato.compareTo(atual.getInfo()) == 0) {
						break;
					}
					anterior = atual;
					atual = atual.getProx();
				}
				anterior.setProx(atual.getProx());
				quantidade--;
				System.out.println("Contato removido !");
			}
		}
	}
}

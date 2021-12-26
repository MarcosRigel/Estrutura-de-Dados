package entities;

public class LSEOrdenada<T extends Comparable<T>> {

	private LSENode<T> primeiro;
	private LSENode<T> ultimo;
	private int quantidade;
	
	public void inserirValor(T valor) {
		LSENode<T> novo = new LSENode<T>(valor);
		
		if (quantidade == 0) {
			primeiro = novo;
			ultimo = novo;
			quantidade++;
			System.out.println("Inserção efetuada com sucesso!");
		} 
		else if (novo.getInfo().compareTo(primeiro.getInfo()) < 0) {
			novo.setProx(primeiro);
			primeiro = novo;
			quantidade++;
			System.out.println("Inserção efetuada com sucesso!");
		}
		else if (novo.getInfo().compareTo(ultimo.getInfo()) >= 0) {
			ultimo.setProx(novo);
			ultimo = novo;
			quantidade++;
			System.out.println("Inserção efetuaca com sucesso! no final da lista");
		}
		else {
			LSENode<T> atual = primeiro.getProx();
			LSENode<T> anterior = primeiro;
			while (atual != null) {
				if (novo.getInfo().compareTo(atual.getInfo()) < 0) {
					anterior.setProx(novo);
					novo.setProx(atual);
					quantidade++;
					System.out.println("Inserção efetuada com sucesso!");
					return;
				}
				else {
					anterior = atual;
					atual = atual.getProx();
				}
			}
		}
	}
	
	public void exibirValores() {
		if (quantidade == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			LSENode<T> auxiliar = primeiro;
			for (int i = 0; i < quantidade; i++) {
				System.out.print(auxiliar.getInfo() + " ");
				auxiliar = auxiliar.getProx();
			}
			System.out.println();
		}
	}
	
	public void removerValor(T valor) {
		if (quantidade == 0) {
			System.out.println("Lista vaiza!");
		}
		else {
			int _primeiro = valor.compareTo(primeiro.getInfo());
			int _ultimo = valor.compareTo(ultimo.getInfo());
			if (_primeiro < 0 || _ultimo > 0) {
				System.out.println("Valor não encontrado!");
				return;
			}
			int quantidadeAnterior = quantidade;
			int valorRemovidos;
			LSENode<T> atual;
			LSENode<T> anterior;
			int valorPrimeiro = valor.compareTo(primeiro.getInfo());
			int valorUltimo = valor.compareTo(ultimo.getInfo());
			if (quantidade == 1 || (valorPrimeiro == 0 && valorUltimo == 0)) {
				primeiro = null;
				ultimo = null;
				quantidade = 0;
				valorRemovidos = quantidadeAnterior - quantidade;
				System.out.println("Lista vazia! ");
				System.out.println("Valores removidos: " + valorRemovidos);
			}
			else {
				atual = primeiro;
				anterior = primeiro;
				while (atual != null) {
					if (valor.compareTo(atual.getInfo()) == 0) {
						int quantidadeRemovidos = 1;
						while(valor.compareTo(atual.getProx().getInfo()) == 0) {
							atual = atual.getProx();
							quantidadeRemovidos++;
							if (atual == ultimo) {
								break;
							}
						}
						if (atual.getInfo().compareTo(this.ultimo.getInfo()) == 0) {
							anterior.setProx(null);
							ultimo = anterior;
							quantidade = quantidade - quantidadeRemovidos;
						}
						else if (atual.getInfo().compareTo(primeiro.getInfo()) == 0) {
							primeiro = atual.getProx();
							quantidade = quantidade - quantidadeRemovidos;
						}
						else {
							anterior.setProx(atual.getProx());
							quantidade = quantidadeAnterior - quantidadeRemovidos;
						}
						valorRemovidos = quantidadeAnterior - quantidade;
						System.out.println("Valor Removido!");
						System.out.println("Valores removidos: " + valorRemovidos);
						return;
					}
					else {
						anterior = atual;
						atual = atual.getProx();
					}
				}
			}
		}
	}	
}
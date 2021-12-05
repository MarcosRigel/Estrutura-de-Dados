package entities.listas;

public class LSE<T extends Comparable<T>>{
	private LSENode<T> primeiro;
	private LSENode<T> ultimo;
	private int quantidade;
	
	public void inserirInfo(T valor) {
		LSENode<T> novoValor = new LSENode(valor);
		if (quantidade == 0) {
			primeiro = novoValor;
			ultimo = novoValor;
			quantidade++;
			System.out.println("Inserção efetuada com sucesso!");
		}
		else {
			boolean achou = buscarInfo(valor);
			if (achou == true) {
				System.out.println("Valor repetido!");
			}
			else {
				ultimo.setProx(novoValor);
				ultimo = novoValor;
				quantidade++;
				System.out.println("Inserção efetuada com sucesso!");
			}
		}
	}
	
	public void exibirInfo() {
		if (quantidade == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			LSENode<T> auxiliar = primeiro;
			for (int i = 0; i < quantidade; i++) {
				System.out.println(auxiliar.getInfo() + ", ");
				auxiliar.getProx();
			}
		}
		System.out.println();
	}
	
	public boolean buscarInfo(T valor) {
		LSENode<T> auxiliar = primeiro;
		for (int i = 0; i < quantidade; i++) {
			if (auxiliar.getInfo().compareTo(valor) == 0) {
				return true;
			}
			auxiliar.getProx();
		}
		return false;
	}
}

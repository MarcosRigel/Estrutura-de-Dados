package entities;

public class LSE<T> {
	private LSENode<T> prim;
	private LSENode<T> ult;
	private int qtd;
	
	public void inserirValorFinal (T valor) {
		LSENode<T> novo;
		novo = new LSENode(valor);
		if (qtd == 0) {
			prim = novo;
			ult = novo;
			qtd++;
		}
		else {
			ult.setProx(novo);
			ult = novo;
			qtd++;
		}
		System.out.println("Inserção efetuada com sucesso!");
	}
	
	public void inserirValorInicio (T valor) {
		LSENode<T> aux;
		if(qtd == 0) {
			System.out.println("Lista vazia!!");
		}
		else {
			aux = prim;
			while(aux != null) {
				System.out.println(aux.getInfo());
				aux = aux.getProx();
			}
		}
	}
	
	public void exibirLista() {
		LSENode<T> aux;
		if (qtd == 0) {
			System.out.println("Lista vazia!!");
		}
		else {
			aux = prim;
			while (aux != null) {
				System.out.println(aux.getInfo());
				aux = aux.getProx();
			}
		}
	}
}

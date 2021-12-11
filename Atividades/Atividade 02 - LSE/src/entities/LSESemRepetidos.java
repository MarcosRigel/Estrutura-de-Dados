package entities;

import java.util.Scanner;

public class LSESemRepetidos<T extends Comparable<T>> {

	private LSENode<T> primeiro;
	private LSENode<T> ultimo;
	private int quantidade;
	
	private Scanner sc = new Scanner(System.in);
	
	public void inserirNovoProdutoInicio(T valor) {
		LSENode<T> novo = new LSENode(valor);
		
		if (quantidade == 0) {
			primeiro = novo;
			ultimo = novo;
			quantidade++;
			System.out.println("novo produto cadastrado!!");
		}
		else {
			LSENode<T> resultado = buscar(valor);
			if (resultado != null) {
				System.out.println("Produto já cadastrado!");
			} 
			else {
				novo.setProx(primeiro);
				primeiro = novo;
				quantidade++;
				System.out.println("novo produto cadastrado!!");
			}
		}
	}
	
	public void inserirNovoProdutoFinal(T valor) {
		LSENode<T> novo = new LSENode(valor);
		
		if (quantidade == 0) {
			primeiro = novo;
			ultimo = novo;
			quantidade++;
			System.out.println("novo produto cadastrado!");
		}
		else {
			LSENode<T> resultado = buscar(valor);
			if (resultado != null) {
				System.out.println("produto já cadastrado!");
			}
			else {
				ultimo.setProx(novo);
				ultimo = novo;
				quantidade++;
				System.out.println("novo produto cadastrado!");
			}
		}
	}
	
	public void exibirProdutos() {
		if (quantidade == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			LSENode<T> auxiliar = primeiro;
			for (int i = 0; i < quantidade; i++) {
				System.out.println(auxiliar.getInfo());
				auxiliar = auxiliar.getProx();
			}
		}
	}
	
	public void removerProdutoPrimeiro() {
		if (quantidade == 0) {
			System.out.println("Lista vazia!");
		} 
		else if (quantidade == 1) {
			primeiro = null;
			ultimo = null;
			quantidade--;
			System.out.println("Produto removido com sucesso!");
		}
		else {
			primeiro.setProx(primeiro);
			quantidade--;
			System.out.println("Produto removido com sucesso!");
		}
	}
	
	public void removerProdutoFinal() {
		if (quantidade == 0) {
			System.out.println("Lista vazia!");
		}
		else if (quantidade == 1) {
			primeiro = null;
			ultimo = null;
			quantidade--;
			System.out.println("Produto removido com sucesso!");
		}
		else {
			LSENode<T> auxiliar = primeiro;
			for (int i = 1; i < quantidade; i++) {
				auxiliar = auxiliar.getProx();
			}
			ultimo = auxiliar;
			quantidade--;
			System.out.println("Produto removido com sucesso!");
		}
	}
	
	public LSENode<T> buscar(T valor) {
		if (quantidade == 0) {
			return null;
		}
		else {
			LSENode<T> auxiliar = primeiro;
			for (int i = 0; i < quantidade; i++) {
				if (auxiliar.getInfo().compareTo(valor) == 0) {
					return auxiliar;
				}
				auxiliar = auxiliar.getProx();
			}
		}
		return null;
	}
	
	public void buscarProduto(T valor) {
		LSENode<T> auxiliar;
		
		if (quantidade == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			auxiliar = buscar(valor);
			if (auxiliar == null) {
				System.out.println("Produto não cadastrado!");
			}
			else {
				System.out.println(auxiliar.getInfo());
			}
		}
	}
	
	public void alterarDados(T valor, Scanner sc) {
		
		if (quantidade == 0) {
			System.out.println("Lista vazia!");
		} 
		else {
			
			LSENode<T> verifica = buscar(valor);
			if (verifica == null) {
				System.out.println("Produto não cadastrado!");
			}
			else {
				int opcao, estoque;
				double preco;
				Produto produto = (Produto) verifica.getInfo();
				
				do {
					menu();
					opcao = sc.nextInt();
					switch (opcao) {
					
					case 1:
						System.out.println("Digite um novo preço: ");
						preco = sc.nextDouble();
						System.out.println("Digite um novo estoque: ");
						estoque = sc.nextInt();
						produto.alterarPreco(preco);
						produto.alterarEstoque(estoque);
						break;
						
					case 2:
						System.out.println("Digite um novo estoque: ");
						estoque = sc.nextInt();
						produto.alterarEstoque(estoque);
						break;
						
					case 3:
						System.out.println("Digite um novo preço: ");
						preco = sc.nextDouble();
						produto.alterarPreco(preco);
						break;
						
					case 0:
						System.out.println("Até Logo!");
						break;
					
					default: System.out.println("Esta opção é invalida!");
					
					} 
				} while (opcao != 0);
			}
		}
	}
	
	public void menu() {
		System.out.println("Escolha uma opção que você deseja alterar");
		System.out.println("1 - Alterar preço e estoque");
		System.out.println("2 - Apenas o Estoque");
		System.out.println("3 - Apenas o Preço");
		System.out.println("0 - Sair");
	}
}

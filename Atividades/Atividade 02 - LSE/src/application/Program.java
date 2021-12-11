package application;

import java.util.Scanner;

import entities.LSESemRepetidos;
import entities.Produto;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Produto produto;
		LSESemRepetidos<Produto> lista = new LSESemRepetidos();
		int opcao, estoque;
		double preco;
		String codigo, descricao;
		
		do {
			menu();
			opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
			case 1:
				System.out.print("Digite um código do produto: ");
				codigo = sc.nextLine();
				System.out.print("Digite um preço do produto: ");
				preco = sc.nextDouble();
				sc.nextLine();
				System.out.print("Digite o descricao do produto: ");
				descricao = sc.nextLine();
				System.out.print("Digite o estoque do produto: ");
				estoque = sc.nextInt();
				produto = new Produto(codigo, descricao, preco, estoque);
				lista.inserirNovoProdutoInicio(produto);
				break;
				
			case 2:
				System.out.print("Digite um codigo do produto: ");
				codigo = sc.nextLine();
				System.out.print("Digite um preço do produto: ");
				preco = sc.nextDouble();
				sc.nextLine();
				System.out.print("Digite uma descrição do produto: ");
				descricao = sc.nextLine();
				System.out.print("Digite o estoque do produto:");
				estoque = sc.nextInt();
				produto = new Produto(codigo, descricao, preco, estoque);
				lista.inserirNovoProdutoFinal(produto);
				break;
				
			case 3:
				lista.removerProdutoPrimeiro();
				break;
				
			case 4:
				lista.removerProdutoFinal();
				break;
			
			case 5:
				lista.exibirProdutos();
				break;
				
			case 6:
				System.out.print("Digite um código do produto: ");
				codigo = sc.nextLine();
				produto = new Produto(codigo, "", 0, 0);
				lista.buscarProduto(produto);
				break;
				
			case 7:
				System.out.print("Digite um código do poduto: ");
				codigo = sc.nextLine();
				produto = new Produto(codigo, "", 0, 0);
				lista.alterarDados(produto, sc);
				break;
				
			case 0:
				System.out.println("Até Logo!");
				break;
			}
		} while(opcao != 0);
		
		sc.close();
		
	}
	
	public static void menu() {
		System.out.println("Digite uma opção: ");
		System.out.println("1 - Inserir Produto no inicio da lista");
		System.out.println("2 - Inserir Produto no final da lista");
		System.out.println("3 - Remover o primeiro produto da lista");
		System.out.println("4 - Remover o último produto da lista");
		System.out.println("5 - Exibir Lista");
		System.out.println("6 - Exibir os dados de um produto");
		System.out.println("7 - Alterar os dados de um produto");
		System.out.println("0 - Sair");
	}
}

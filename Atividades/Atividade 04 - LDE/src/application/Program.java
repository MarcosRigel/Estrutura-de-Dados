package application;

import java.util.Scanner;

import entities.LDESemRepetidosOrdenado;
import exception.RemoverException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		LDESemRepetidosOrdenado<Integer> lista = new LDESemRepetidosOrdenado();
		int valor;
		char opcao;
		
		do {
			
			menu();
			opcao = sc.next().charAt(0);
			
			switch(opcao) {
			case '1':
				System.out.println("Digite um valor: ");
				valor = sc.nextInt();
				lista.inserirValorOrdenadoDecrescente(valor);
			break;
			
			case '2':
				System.out.println("Digite um numero: ");
				valor = sc.nextInt();
				try {
					lista.removerValor(valor);
				} catch (RemoverException listaVazia) {
					System.out.println(listaVazia.getMessage());
				}
			break;
			
			case '3':
				lista.exibirValoresCrescente();
			break;
			
			case '4':
				lista.exibirValoresCrescente();
			break;
			
			case '5':
				System.out.println("Digite um numero: ");
				valor = sc.nextInt();
				lista.exibirInfo(valor);
			break;
			
			case '6':
			System.out.println("até logo...");
			
			default:
				System.out.println("Opção inválida!");
			
			}
		} while (opcao != '6');
		
		sc.close();

	}
	
	public static void menu() {
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - inserir um valor ");
		System.out.println("2 - remover um valor");
		System.out.println("3 - exibir valor em ordem decrescente");
		System.out.println("4 - exibir valor em ordem crescente");
		System.out.println("5 - exibir informação do objeto");
		System.out.println("6 - sair...");
	}
}

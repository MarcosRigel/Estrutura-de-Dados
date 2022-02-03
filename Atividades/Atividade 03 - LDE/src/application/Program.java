package application;

import java.util.Scanner;

import entities.LDESemRepetidos;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		LDESemRepetidos<Integer> lista = new LDESemRepetidos();
		int valor;
		char opcao;
		
		do {
			menu();
			opcao = sc.next().charAt(0);
			
			switch (opcao) {
				case '1':
					System.out.println("Digite um valor: ");
					valor = sc.nextInt();
					lista.inserirValor(valor);
					break;
					
				case '2':
					lista = lista.ordenar('c');
					System.out.println("Lista ordenada (CRESCENTE)");
					break;
					
				case '3':
					lista = lista.ordenar('d');
					System.out.println("Lista ordenada (DECRESCENTE)");
					break;
					
				case '4':
					if (lista.isEmpty()) {
						System.out.println("Lista vazia!");
					}
					else {
						lista.exibir();
					}
					break;
					
				case '5':
					System.out.println("Até Logo...");
					break;
					
				default: 
					System.out.println("Digite uma opção válida!");
			}
		} while (opcao != 5);
		
		sc.close();
	}
	
	public static void menu() {
		System.out.println("Digite uma opção: ");
		System.out.println("1 - inserir um novo valor");
		System.out.println("2 - ordernar a lista em ordem crescente");
		System.out.println("3 - ordenar a lista em ordem decrescente");
		System.out.println("4 - mostrar a lista");
		System.out.println("5 - sair");
	}

}

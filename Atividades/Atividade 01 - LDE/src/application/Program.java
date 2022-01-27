package application;

import java.util.Scanner;

import entities.LDE;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int opcao, numero;
		LDE<Integer> lista = new LDE();
		
		do {
			menu();
			opcao = sc.nextInt();
			sc.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.print("Digite um valor: ");
				numero = sc.nextInt();
				lista.inserirValorInicio(numero);
				break;
				
			case 2:
				System.out.print("Digite um valor: ");
				numero = sc.nextInt();
				lista.inserirValorFinal(numero);
				break;
				
			case 3:
				lista.removerValorInicio();
				break;
				
			case 4:
				lista.removerValorFinal();
				break;
				
			case 5:
				lista.exibirLista();
				break;
				
			case 0:
				System.out.println("Até Logo...");
				break;
				
			default: System.out.println("Opção inválida!");
			
			}
			
		} while(opcao != 0);
		
		sc.close();
	}
	
	public static void menu() {
		System.out.println("1 – Inserir novo valor no início da lista");
		System.out.println("2 – Inserir novo valor no final da lista");
		System.out.println("3 – Remover o primeiro elemento da lista");
		System.out.println("4 – Remover o último elemento da lista");
		System.out.println("5 - Exibir a lista");
		System.out.println("0 - Sair do programa");
	}
}

package application;

import java.util.Scanner;
import entities.LSEOrdenada;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LSEOrdenada<Integer> lista = new LSEOrdenada();
		int opcao, numero;
		
		do {
			menu();
			opcao = sc.nextInt();
			sc.nextLine();
			switch (opcao) {
			case 1:
				System.out.println("Digite um valor");
				numero = sc.nextInt();
				lista.inserirValor(numero);
				break;
				
			case 2:
				System.out.println("Digite um valor para a remoção");
				numero = sc.nextInt();
				lista.removerValor(numero);
				break;
				
			case 3:
				lista.exibirValores();
				break;
				
			case 0:
				System.out.println("Até Logo...");
				break;
				
				default: System.out.println("Digite uma opção valida!");
			
			}
		} while (opcao != 0);
	}
	
	
	public static void menu() {
		System.out.println("Digite uma opção: ");
		System.out.println("1 - Inserir um novo valor");
		System.out.println("2 - Remover um valor");
		System.out.println("3 - Mostrar os valores");
		System.out.println("0 - Sair");
	}
}

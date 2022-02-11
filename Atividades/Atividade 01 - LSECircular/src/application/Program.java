package application;

import java.util.Scanner;

import entities.LSECircular;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		LSECircular<Integer> lista = new LSECircular();
		int opcao, numero;
		
		do {
			menu();
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.print("Digite um valor: ");
				numero = sc.nextInt();
				lista.inserirValorInicio(numero);
				break;
				
			case 2:
				lista.exibir();
				break;
				
			case 3:
				lista.removerInicio();
				break;
			
			case 4:
				System.out.print("Digite um valor: ");
				numero = sc.nextInt();
				lista.inserirValorFinal(numero);
				break;
			
			case 5:
				lista.removerFinal();
				break;
			
			case 6:
				System.out.print("Digite um valor: ");
				numero = sc.nextInt();
				int quantidade = lista.quantidadeValor(numero);
				System.out.println("Existem: " + quantidade + " vezes!");
				break;
			case 7:
				System.out.println("At� Logo...");
				break;
				
				default: System.out.println("Digite uma op��o v�lida!");
			}
		} while (opcao != 7);
		
		sc.close();
	}
	
	public static void menu() {
		System.out.println("Escolha uma op��o: ");
		System.out.println("01 - Procedimento para inserir um novo n� no in�cio da lista");
		System.out.println("02 - Procedimento para exibir o conte�do de todos os n�s da lista");
		System.out.println("03 - Procedimento para remover o n� situado no in�cio da lista");
		System.out.println("04 - Procedimento para inserir um novo n� no final da lista");
		System.out.println("05 - Procedimento para remover o n� situado no final da lista");
		System.out.println("06 - Procedimento para informar quantas vezes um dado valor se repete na lista");
		System.out.println("07 - Sair");
	}
}

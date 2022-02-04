package application;

import java.util.Scanner;
import Excecao.*;
import entities.LDEC;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		LDEC<Integer> L1 = new LDEC();
		LDEC<Integer> L2 = new LDEC();
		int opcao, numero;
		
		do {
			menu();
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite um valor (Lista 01)");
				numero = sc.nextInt();
				try {
					L1.inserirFinal(numero);
					System.out.println("Valor inserido com sucesso!");
				} catch (ValorRepetido e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 2:
				System.out.println("Digite um valor (Lista 02)");
				numero = sc.nextInt();
				try {
					L2.inserirFinal(numero);
					System.out.println("Valor inserido com sucesso!");
				} catch (ValorRepetido e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				L1.concatenar(L2);
				System.out.println("Listas concatenadas!");
				break;
				
			case 4:
				try {
					L2 = L1.dividir();
					System.out.println("Lista dividida");
				} catch (ListaVazia | ListaComUmValor e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:
				try {
					L1.exibirLista();
				} catch (ListaVazia e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 6:
				try {
					L2.exibirLista();
				} catch (ListaVazia e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 0:
				System.out.println("Até Logo...");
				break;
				
			default: System.out.println("Opção inválida, digite um numero:");
			}
		} while (opcao != 0);
		
		sc.close();
	}
		
	public static void menu() {
		System.out.println("Digite uma opção: ");
		System.out.println("1 - Inserir um novo valor na lista 1");
		System.out.println("2 - Inserir um novo valor na lista 2");
		System.out.println("3 - Concatenar Listas");
		System.out.println("4 - Dividir Listas");
		System.out.println("5 - Exibir valor da lista 1");
		System.out.println("6 - Exibir valores da lista 2");
		System.out.println("0 - sair");
	}
}


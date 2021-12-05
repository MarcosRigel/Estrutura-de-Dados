package application;

import java.util.Scanner;

import entities.listas.LSE;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numero, escolha;
		LSE<Integer> A = new LSE();
		LSE<Integer> B = new LSE();
		
		do {
			menu();
			escolha = sc.nextInt();
			
			switch (escolha) {
			
				case 1:
				System.out.print("Digite um n�mero: ");
				numero = sc.nextInt();
				if ((numero % 2) == 0) {
					A.inserirInfo(numero);
				}
				else {
					B.inserirInfo(numero);
				}
				break;
				
				case 2:
				LSE<Integer> valor;
				boolean achou;
				System.out.print("Digite um n�mero: ");
				numero = sc.nextInt();
				
				if ((numero / 2) == 0) {
					achou = A.buscarInfo(numero);
				}
				else {
					achou = B.buscarInfo(numero);
				}
				if (achou == true) {
					System.out.println("O valor " + numero + " foi encontrado!!");
				}
				else {
					System.out.println("O valor " + numero + " n�o foi encontrado!!");
				}
				break;
				
				case 3:
				B.exibirInfo();
				break;
				
				case 4:
				A.exibirInfo();
				break;
				
				case 0:
				System.out.println("At� Logo!");
				
				default: System.out.println("Op��o Inv�lida, Porfavor digite um n�mero v�lido");
			}
			
		} while(escolha != 0);
		
		sc.close();
	}
	
	public static void menu() {
		System.out.println("Escolha uma op��o: ");
		System.out.println("1 - Inserir um novo valor na lista");
		System.out.println("2 - Buscar valor");
		System.out.println("3 - Exibir lista com numeros impares");
		System.out.println("4 - Exibir lista com numeros pares");
		System.out.println("0 - Sair");
	}

}

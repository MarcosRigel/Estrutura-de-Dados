package application;

import java.util.Scanner;
import entities.LSE;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		LSE<Integer> numeros = new LSE();
		int op, num;
		do {
			System.out.println("Opções");
			System.out.println("1 - Inserir um valor na lista no final da lista");
			System.out.println("2 - Inserir um valor na lista no inicio da lista");
			System.out.println("3 - Exibir a lista");
			System.out.println("0 - Encerrar programa");
			System.out.println("Informe a opção desejada:");
			op = sc.nextInt();
			switch (op) {
				case 1: System.out.println("Informe o valor:");
					num = sc.nextInt();
					numeros.inserirValorFinal(num);
					break;
					
				case 2: System.out.println("Informe o valor:");
					num = sc.nextInt();
					numeros.inserirValorInicio(num);
					break;
				
				case 3:
					numeros.exibirLista();
					break;
					
				case 0:
					System.out.println("Bye Bye");
					break;
					
				default: System.out.println("Opção inválida");
			}
		} while(op != 0);
		
		sc.close();
	}
}
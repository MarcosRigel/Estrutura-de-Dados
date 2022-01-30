package application;

import java.util.Scanner;

import entities.Cadastro;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Cadastro cadastro = new Cadastro();
		char opcao;
		String nome, rg;
		
		do {
			menu();
			opcao = sc.next().charAt(0);
			sc.nextLine();
			
			switch (opcao) {
			case '1':
				System.out.println("Digite o nome da pessoa: ");
				nome = sc.nextLine();
				System.out.println("Digite o RG da pessoa: ");
				rg = sc.nextLine();
				cadastro.Cadastrar(nome, rg);
				break;
				
			case '2':
				System.out.println("Digite o RG da pessoa");
				rg = sc.nextLine();
				cadastro.remover(rg);
				break;
				
			case '3':
				System.out.println("Digite o RG da pessoa");
				rg = sc.nextLine();
				cadastro.verificarPessoa(rg);
				break;
				
			case '4':
				cadastro.exibir();
				break;
				
			case '5':
				cadastro.quantidadePessoas();
				break;
				
			case '0':
				System.out.println("Até Logo...");
				break;
				
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != '0');
		
		sc.close();
	}
	
	public static void menu() {
		System.out.println("1 - Cadastrar pessoa");
		System.out.println("2 - Remover pessoa");
		System.out.println("3 - Verificar pessoa");
		System.out.println("4 - Exibir pessoas cadastradas");
		System.out.println("5 - Exibir quantidade de cadastros realizados");
		System.out.println("0 - Sair");
	}

}

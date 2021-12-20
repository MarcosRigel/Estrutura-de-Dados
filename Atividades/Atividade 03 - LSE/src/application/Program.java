package application;

import java.util.Scanner;

import entities.Cadastro;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Cadastro cadastro = new Cadastro();
		int opcao;
		String cpf;
		
		do {
			menu();
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.print("Digite um cpf: ");
				sc.nextLine();
				cpf = sc.nextLine();
				cadastro.adicionarCliente(cpf);
				break;
				
			case 2:
				System.out.print("Digite o cpf do cliente: ");
				cpf = sc.nextLine();
				cadastro.removerCliente(cpf);
				break;
				
			case 3:
				System.out.print("Digite o cpf do cliente: ");
				cpf = sc.nextLine();
				cadastro.alterarDados(cpf);
				break;
				
			case 4:
				System.out.print("Digite o cpf do cliente: ");
				cpf = sc.nextLine();
				cadastro.consultarCliente(cpf);
				break;
				
			case 5:
				cadastro.exibirClientes();
				break;
				
			case 0:
				System.out.println("Até Logo...");
				break;
				
			default: System.out.println("Opção inválida!");
			
			}
		} while (opcao != 0);
	}
	
	public static void menu() {
		System.out.println("Digite a opção que deseja: ");
		System.out.println("1 - Cadastrar um novo Cliente");
		System.out.println("2 - Remover um cliente");
		System.out.println("3 - Alterar os dados de um cliente");
		System.out.println("4 - Consultar os dados de um cliente");
		System.out.println("5 - Exibir dados dos clientes");
		System.out.println("0 - Sair...");
	}
}

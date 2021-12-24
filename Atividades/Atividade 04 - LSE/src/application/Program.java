package application;

import java.util.Scanner;

import entities.Agenda;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Agenda agenda = new Agenda();
		int opcao;
		String nome;
		
		do {
			menu();
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Digite um nome do novo contato: ");
				nome = sc.nextLine();
				agenda.adicionarContato(nome);
				break;
				
			case 2:
				System.out.println("Digite um nome do contato para ser removido: ");
				nome = sc.nextLine();
				agenda.removerContato(nome);
				break;
				
			case 3:
				System.out.println("Digite um nome do contato para ser alterado: ");
				nome = sc.nextLine();
				agenda.removerContato(nome);
				break;
				
			case 4:
				System.out.println("Digite um  nome do contato a ser consultado: ");
				nome = sc.nextLine();
				agenda.consultarContato(nome);
				break;
				
			case 5:
				agenda.exibirContatos();
				break;
				
			case 0:
				System.out.println("Até Logo...");
				
			default: System.out.println("Opção inválida !");
			}
		} while (opcao != 0);	
	}
	
	public static void menu() {
		System.out.println("Digite uma opção");
		System.out.println("1 - Inserir um novo contato na Agenda");
		System.out.println("2 - Remover um contato");
		System.out.println("3 - Alterar os dados de um contato");
		System.out.println("4 - Consultar os dados");
		System.out.println("5 - Exibir os dados de todos os contatos");
		System.out.println("0 - Sair do Programa");
	}
}
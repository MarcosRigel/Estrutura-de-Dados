package entities;

import java.util.Scanner;

public class Agenda {
	
	private LSESemRepetidos<Contato> lista;
	
	public Agenda() {
		lista = new LSESemRepetidos();
	}
	
	Contato contato;
	Scanner sc = new Scanner(System.in);
	
	public void adicionarContato(String nome) {
		Contato achou;
		contato = new Contato(nome);
		achou = lista.buscarContato(contato);
		if (achou == null) {
			String telefone, email;
			System.out.print("Digite um Telefone: ");
			telefone = sc.nextLine();
			System.out.print("Digite o Email: ");
			email = sc.nextLine();
			contato = new Contato(nome, telefone, email);
			lista.inserirContato(contato);
		}
		else {
			System.out.println("Contato ja cadastrado!");
		}
	}
	
	public void listarContatos() {
		lista.exibirContatos();
	}
	
	public void removerContato(String nome) {
		contato = new Contato(nome);
		lista.removerContato(contato);
	}
	
	public void consultarContato(String nome) {
		Contato achou;
		contato = new Contato(nome);
		achou = lista.buscarContato(contato);
		if (achou == null) {
			System.out.println("Contato não encontrado!");
		}
		else {
			System.out.println(achou);
		}
	}
	
	public void AlterarDados(String nome) {
		Contato achou;
		contato = new Contato(nome);
		achou = lista.buscarContato(contato);
		
		if (achou != null) {
			int opcao;
			String telefone, email;
			do {
				menu();
				opcao = sc.nextInt();
				sc.nextLine();
				
				switch (opcao) {
				case 1:
					System.out.println("Informe o novo Email: ");
					email = sc.nextLine();
					achou.setEmail(email);
					System.out.println("Informe o novo Telefone: ");
					telefone = sc.nextLine();
					achou.setTelefone(telefone);
					System.out.println("Alteração feita com Sucesso!");
					break;
					
				case 2:
					System.out.println("Digite um novo Email");
					email = sc.nextLine();
					achou.setEmail(email);
					System.out.println("Alteração feita com Sucesso!");
					break;
					
				case 3:
					System.out.println("Digite um novo Telefone: ");
					telefone = sc.nextLine();
					achou.setTelefone(telefone);
					System.out.println("Alteração feita com Sucesso!");
					break;
					
				case 0:
					System.out.println("Até logo...");
					break;
					
				default: System.out.println("Opção indisponível!");
				}
				
			} while (opcao != 0);
		}
		else {
			System.out.println("Contato não encontrado!");
		}
	}
	
	private void menu() {
		System.out.println("Digite uma opção para alterar");
		System.out.println("1 - Email e Telefone");
		System.out.println("2 - Email");
		System.out.println("3 - Telefone");
	}
	
	public void exibirContatos() {
		lista.exibirContatos();
	}
}
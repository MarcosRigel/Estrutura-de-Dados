package entities;

import java.util.Scanner;

public class Cadastro {

	private LSESemRepetidos<Cliente> lista;
	
	public Cadastro() {
		this.lista = new LSESemRepetidos();
	}
	
	Cliente cliente;
	Scanner sc = new Scanner(System.in);
	
	public void adicionarCliente(String cpf) {
		Cliente achou;
		cliente = new Cliente(cpf);
		achou = lista.buscarCliente(cliente);
		
		if (achou == null) {
			String nome, telefone, email;
			System.out.print("Digite um Nome: ");
			nome = sc.nextLine();
			System.out.print("Digite um Telefone: ");
			telefone = sc.nextLine();
			System.out.print("Digite um Email: ");
			email = sc.nextLine();
			cliente = new Cliente(cpf, nome, telefone, email);
			lista.inserirCliente(cliente);
		}
		else {
			System.out.println("Este cpf já esta cadastrado! ");
		}
	}
	
	public void listarClientes() {
		lista.exibirCliente();
	}
	
	public void removerCliente(String cpf) {
		cliente = new Cliente(cpf);
		lista.removerCliente(cliente);
	}
	
	public void consultarCliente(String cpf) {
		Cliente achou;
		cliente = new Cliente(cpf);
		achou = lista.buscarCliente(cliente);
		
		if (achou == null) {
			System.out.println("Cliente não encontrado!");
		}
		else {
			System.out.println(achou.toString());
		}
	}
	
	public void alterarDados(String cpf) {
		Cliente achou;
		cliente = new Cliente(cpf);
		achou = lista.buscarCliente(cliente);
		
		if (achou != null) {
			int opcao;
			String telefone, email;
			do {
				menu();
				opcao = sc.nextInt();
				sc.nextLine();
				switch (opcao) {
				case 1:
					System.out.print("Digite um novo email: ");
					email = sc.nextLine();
					achou.setEmail(email);
					System.out.print("Informe o novo Telefone: ");
					telefone = sc.nextLine();
					achou.setFone(telefone);
					break;
					
				case 2:
					System.out.print("Informe o novo email: ");
					email = sc.nextLine();
					achou.setEmail(email);
					break;
					
				case 3:
					System.out.println("Informe o novo Telefone: ");
					telefone = sc.nextLine();
					achou.setFone(telefone);
					break;
					
				case 0:
					System.out.println("Até Logo!");
					break;
					
				default:
					System.out.println("Opção inválida!");
				}
			} while (opcao != 0);
		}
		else {
			System.out.println("Cliente não cadastrado!");
		}
	}
	
	public void menu() {
		System.out.println("Digite uma opção para alterar: ");
		System.out.println("1 - E-mail e Telefone");
		System.out.println("2 - E-mail");
		System.out.println("3 - Telefone");
	}
	
	public void exibirClientes() {
		lista.exibirCliente();
	}
}

package entities;

import java.util.Scanner;

public class Cadastro {
	
	private final LDESemRepetidos<Pessoa> lista;
	private Pessoa pessoa;
	
	Scanner sc = new Scanner(System.in);
	
	public Cadastro() {
		lista = new LDESemRepetidos();
	}
	
	public void Cadastrar(String nome, String rg) {
		pessoa = new Pessoa(nome, rg);
		lista.cadastrarPessoa(pessoa);
	}
	
	public void exibir() {
		lista.exibirPessoas();
	}
	
	public void verificarPessoa(String rg) {
		pessoa = new Pessoa(rg);
		if (lista.verificarRg(pessoa)) {
			System.out.println("A pessoa cadastrada!");
		}
		else {
			System.out.println("A pessoa não cadastrada!");
		}
	}
	
	public void quantidadePessoas() {
		int quantidade = lista.getQuantidade();
		if (quantidade == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			System.out.println(quantidade + " Pessoas cadastradas!");
		}
	}
	
	public void remover(String rg) {
		pessoa = new Pessoa(rg);
		lista.removerPessoa(pessoa);
	}
	
	public void removerUltimo(String rg) {
		pessoa = new Pessoa(rg);
		if (!lista.verificarRg(pessoa)) {
			System.out.println("deseja efetivar seu cadastro? 1 - sim ou 2 - nao!");
			int opcao = sc.nextInt();
			while (opcao != 1 && opcao != 2) {
				System.out.println("opção inválida");
				opcao = sc.nextInt();
			}
			if (opcao == 2) {
				lista.removerPessoa(pessoa);
				System.out.println("cadastro cancelado!");
			}
			else {
				System.out.println("cadastro efetivado com sucesso!");
			}
		}
	}
}

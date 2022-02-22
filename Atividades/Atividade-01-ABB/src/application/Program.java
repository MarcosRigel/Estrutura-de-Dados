package application;

import java.util.Scanner;

import entities.ABB;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        ABB <Integer> arvore = new ABB();
        char opcao;
        int numero, valor, quantidade;
        do {
            menu();
            opcao = sc.next().charAt(0);
            switch (opcao) {
                case '1':
                    System.out.println("Digite um valor: ");
                    numero = sc.nextInt();
                    System.out.println();
                    arvore.insert(numero);
                    System.out.println();
                    break;
                case '2':
                    valor = arvore.menorValor();
                    System.out.println();
                    System.out.println("Menor valor: " + valor);
                    System.out.println();
                    break;
                case '3':
                    valor = arvore.maiorValor();
                    System.out.println();
                    System.out.println("Maior valor: " + valor);
                    System.out.println();
                    break;
                case '4':
                	System.out.println("Digite um valor: ");
                    numero = sc.nextInt();
                    arvore.inserirNo(numero);
                    break;
                case '5':
                    quantidade = arvore.qtdNo(arvore.getRaiz());
                    System.out.println();
                    System.out.println("Quantidade de nos: " + quantidade);
                    System.out.println();
                    break;
                case '6':
                    quantidade = arvore.qtdFolhas(arvore.getRaiz());
                    System.out.println();
                    System.out.println("Quantidade de folhas: " + quantidade);
                    System.out.println();
                    break;
                case '7':
                    quantidade = arvore.qtdNosNaoTerminais(arvore.getRaiz());
                    System.out.println();
                    System.out.println("Quantidade de nos nao terminais: " + quantidade);
                    System.out.println();
                    break;
                case '8':
                    System.out.println();
                    arvore.emOrdem();
                    System.out.println();
                    break;
                case '0':
                    System.out.println("Até Logo...");
                    break;
                default:
                    System.err.println("Opção inválida, Porfavor digita uma opção válida!");
            }
        } while (opcao != '0');
		
	}
	
	public static void menu() {
        System.out.println("1 - Inserir valor");
        System.out.println("2 - Exibir menor valor");
        System.out.println("3 - Exibir maior valor");
        System.out.println("4 - inserir valor nao recursivo");
        System.out.println("5 - Exibir quantidades de nos");
        System.out.println("6 - Exibir quantidades de folhas");
        System.out.println("7 - Exibir quantidades de nos nao terminais");
        System.out.println("8 - Exibir nos");
        System.out.println("0 - Sair do programa");
        System.out.print("Escolha uma opcao: ");
    }
}
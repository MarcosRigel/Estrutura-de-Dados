package entities;

import exception.RemoverException;

public class LDESemRepetidosOrdenado<T extends Comparable<T>> {

	private LDENode<T> primeiro;
    private LDENode<T> ultimo;
    private int quantidade;

    public boolean isEmpty() {
        return quantidade == 0;
    }
    
    public int getQtd() {
        return quantidade;
    }

    public void inserirValorOrdenadoDecrescente(T valor) {
        
    	LDENode<T> novoValor = new LDENode(valor);
        
    	if (isEmpty()) { 
            primeiro = novoValor;
            ultimo = novoValor;
            quantidade++;
            System.out.println("valor inserido com sucesso !");
        } 
        else if (novoValor.getInformacao().compareTo(primeiro.getInformacao()) > 0) {
            novoValor.setProximo(primeiro);
            primeiro.setAnterior(novoValor);
            primeiro = novoValor;
            quantidade++;
            System.out.println("Valor inserido no inicio da lista");
        }
        else if (novoValor.getInformacao().compareTo(ultimo.getInformacao()) < 0) {
            ultimo.setProximo(novoValor);
            novoValor.setAnterior(ultimo);
            ultimo = novoValor;
            ultimo.setProximo(null);
            quantidade++;
            System.out.println("valor inserido no final da lista");
        }
        else {
            LDENode<T> atual = primeiro;
            while (atual != null) {
                if (novoValor.getInformacao().compareTo(atual.getInformacao()) == 0) {
                    System.out.println("valor repetido !");
                    return;
                } 
                else { 
                    if (novoValor.getInformacao().compareTo(atual.getInformacao()) > 0) {
                        atual.getAnterior().setProximo(novoValor);
                        novoValor.setAnterior(atual.getAnterior());
                        novoValor.setProximo(atual);
                        atual.setAnterior(novoValor);
                        this.quantidade++;
                        System.out.println("valor inserido no meio da lista, com sucesso!");
                        return;
                    }
                    else {
                        atual = atual.getProximo();
                    }
                }
            }
        }
    }

    public void removerValor(T valor) throws RemoverException{

        if (isEmpty()) {
            throw  new RemoverException();
        } 
        else if (quantidade == 1) {
            LDENode<T> pessoa = new LDENode(valor);
            if (primeiro.getInformacao().compareTo(pessoa.getInformacao()) == 0) { 
                primeiro = null;
                ultimo = null;
                quantidade--;
            } 
            else { 
                throw new RemoverException();
            }
        } 
        else {
            LDENode<T> novo = buscarValorDecrescente(valor);
            if (novo != null) { 
                if (primeiro == novo) {
                    primeiro = primeiro.getProximo();
                    primeiro.setAnterior(null);
                    quantidade--;
                } 
                else if (ultimo == novo) { 
                    ultimo = ultimo.getAnterior();
                    ultimo.setProximo(null);
                    quantidade--;
                } 
                else {
                    novo.getAnterior().setProximo(novo.getProximo());
                    novo.getProximo().setAnterior(novo.getAnterior());
                    quantidade--;
                }
                System.out.println("valor removido !");
            } 
            else { 
                System.out.println("valor não encontrado !");
            }
        }
    }

    private LDENode<T> buscarValorDecrescente(T valor) {
        
    	if (isEmpty()) {
            return null;
        } 
        else if (valor.compareTo(primeiro.getInformacao()) > 0) {
            return null; 
        } 
        else if (valor.compareTo(ultimo.getInformacao()) < 0) {
            return null;
        } 
        else {
            LDENode<T> auxiliar = primeiro;
            while (auxiliar != null) {
                if (valor.compareTo(auxiliar.getInformacao()) > 0) {
                    return null;
                } 
                else {
                    if (auxiliar.getInformacao().compareTo(valor) == 0) {
                        return auxiliar;
                    } 
                    else {
                        auxiliar = auxiliar.getProximo();
                    }
                }
            }
            return null;
        }
    }

    public void exibirValoresDecrescente() {
        LDENode<T> auxiliar = primeiro;
        while (auxiliar != null) {
            System.out.print(auxiliar.getInformacao() + " ");
            auxiliar = auxiliar.getProximo();
        }
        System.out.println();
    }

    public void exibirValoresCrescente() {
        LDENode<T> auxiliar = ultimo;
        while (auxiliar != null) {
            System.out.print(auxiliar.getInformacao() + " ");
            auxiliar = auxiliar.getAnterior();
        }
        System.out.println();
    }

    public void exibirInfo(T valor) {
        LDENode<T> novo = buscarValorDecrescente(valor);
        if (novo != null) {
            System.out.println(novo.getInformacao());
        } 
        else {
            System.out.println("valor não encontrado!");
        }
    }
}

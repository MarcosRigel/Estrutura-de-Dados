package entities;

public class ABB<T extends Comparable<T>> {
	private ABBNode<T> raiz;

    public ABBNode<T> getRaiz() {
        return raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(T value) {
        if (isEmpty()) {
            raiz = new ABBNode(value);
        } else {
           
            raiz.insertNode(value);
        }
    }

    public void emOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } 
        else {
           
            percorrerEmOrdem(raiz);
        }
    }
 
    private void percorrerEmOrdem(ABBNode<T> no) {
        if (no != null) {
            percorrerEmOrdem(no.getEsquerda());
            System.out.println(no.getInformacao());
            percorrerEmOrdem(no.getDireita());
        }
    }

    private ABBNode<T> menorNo(ABBNode<T> no) {
        if (no.getEsquerda() != null) {
            no = menorNo(no.getEsquerda());
        }
        return no;
    }

   
    public T menorValor() {
        if (isEmpty()) {
            return null;
        } 
        else {
            ABBNode<T> retorno;
            retorno = menorNo(raiz);
            return retorno.getInformacao();
        }
    }

    private ABBNode<T> maiorNo(ABBNode<T> no) {
        if (no.getDireita() != null) {
            no = maiorNo(no.getDireita());
        }
        return no;
    }

    public T maiorValor() {
        if (isEmpty()) {
            return null;
        } 
        else {
            ABBNode<T> aux;
            aux = maiorNo(raiz);
            return aux.getInformacao();
        }
    }

    public void inserirNo(T value) {
        ABBNode<T> aux;
        ABBNode<T> newNo = new ABBNode(value);
        if (isEmpty()) {
            raiz = new ABBNode(value);
        } 
        else {
            aux = raiz;
            while (aux != null) {
                if (value.compareTo(aux.getInformacao()) == 0) {
                    System.err.println("Valor repetido.");
                    return;
                } 
                else if (value.compareTo(aux.getInformacao()) < 0) {
                    if (aux.getEsquerda() == null) {
                        aux.setEsquerda(newNo);
                        System.out.println("Valor inserido!");
                        return;
                    } 
                    else {
                        aux = aux.getEsquerda();
                    }
                } 
                else {
                    
                    if (aux.getDireita() == null) {
                        aux.setDireita(newNo); 
                        System.out.println("Valor inserido!");
                        return;
                    } 
                    else {
                        aux = aux.getDireita();
                    }
                }
            }
        }
    }

    public int qtdNo(ABBNode<T> no) {
        if (no != null) {
            return qtdNo(no.getEsquerda()) + qtdNo(no.getDireita()) + 1;
        }
        return 0;
    }

    public int qtdFolhas(ABBNode<T> no) {
        int qtd = 0;
        if (no == null) {
            return 0;
        } 
        else {
            if (no.getEsquerda() == null && no.getDireita() == null) {
                return qtdNo(no.getEsquerda()) + qtdNo(no.getDireita()) + 1;
            } 
            else {
                return qtdNo(no.getEsquerda()) + qtdNo(no.getDireita());
            }

        }
    }
    
    public int qtdNosNaoTerminais(ABBNode<T> no) {
        if (no == null) {
            return 0;
        } 
        else {
            if (no.getEsquerda() != null || no.getDireita() != null) {
                return qtdNosNaoTerminais(no.getEsquerda()) + qtdNosNaoTerminais(no.getEsquerda()) + 1;
            } 
            else {
                return qtdNosNaoTerminais(no.getEsquerda()) + qtdNosNaoTerminais(no.getEsquerda());
            }
        }
    }
}

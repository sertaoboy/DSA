package aula6;

public class PilhaEncadeada<T> implements TADPilhaEncadeada<T> {

    private int tamanho;
    private No<T> cabeca;

    public PilhaEncadeada(){
        cabeca = null;
        this.tamanho = 0;
    }

    @Override
    public void inserir(T t) {
        No novoNo = new No(t,null);
        if(pilhaVazia()) {
            this.cabeca = novoNo;
        }else{
            novoNo.setNoProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }

    @Override
    public void remover() {
        if(pilhaVazia()) {
            System.out.println("Pilha vazia, nada a remover.");
            return;
        }else{
            No noRemovido = cabeca;
            cabeca=cabeca.getNoProximo();
            noRemovido.setNoProximo(null);
            this.tamanho--;
        }
    }

    @Override
    public void imprimir() {
        if(pilhaVazia()) {
            System.out.println("Pilha vazia, nenhum elemento para impressao");
            return;
        }else{
            No auxiliar = cabeca;
            while(auxiliar != null) {
                System.out.print(" => "+auxiliar.getValor());
                auxiliar = auxiliar.getNoProximo();
            }
            System.out.println();
        }

    }

    @Override
    public boolean pilhaVazia() {
        if(cabeca == null) {
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        TADPilhaEncadeada<String> pilha = new PilhaEncadeada<String>();
        pilha.imprimir();
        pilha.inserir("elemento 1");
        pilha.imprimir();
        pilha.inserir("elemento 2");
        pilha.imprimir();
        pilha.inserir("elemento 3");
        pilha.imprimir();
        pilha.inserir("elemento 4");
        pilha.imprimir();
        pilha.inserir("elemento 5");
        pilha.imprimir();
        pilha.inserir("nada");
        pilha.imprimir();

        pilha.remover();
        pilha.imprimir();
        pilha.remover();
        pilha.imprimir();
        pilha.remover();
        pilha.imprimir();
        pilha.remover();
        pilha.imprimir();
        pilha.remover();
        pilha.imprimir();
        pilha.remover();
        pilha.imprimir();

    }
}

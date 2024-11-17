package aula7;



public class ListaEncadeada<T> implements TADListaEncadeada<T> {

    private No<T> cabeca;
    private int tamanho;

    public int getTamanho(){
        return tamanho;
    }


    public ListaEncadeada(){
        this.tamanho = 0;
        this.cabeca = null;
    }


    @Override
    public void insereInicio(T valor) {
        No<T> novoNo = new No<>(valor,null);
        if(cabeca == null) {
            cabeca = novoNo;
        }else{
            novoNo.setNoProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }

    @Override
    public void insereFinal(T valor) {
        No<T> novoNo = new No<>(valor,null);
        if(cabeca == null) {
            cabeca = novoNo;
        }else{
            getCauda().setNoProximo(novoNo);
        }
        tamanho++;
    }

    @Override
    public void inserePosicao(T valor, int posicao) {
        //verificando se a posicao e valida
        if(posicao == 0) {
            insereInicio(valor);
            return;
        }else if(posicao == tamanho){
            insereFinal(valor);
            return;
        }else if(posicao < 0 || posicao > tamanho) {
            System.out.println("Posicao invalida.");
            return;
        }
        //Insercao no meio da lista
        No<T> novoNo = new No<T>(valor,null);
        No<T> noAnteriorInsercao = cabeca;
        for(int i = 0; i< posicao - 1; i++){
            noAnteriorInsercao = noAnteriorInsercao.getNoProximo();
        }
        No<T> noPosteriorInsercao = noAnteriorInsercao.getNoProximo();
        noAnteriorInsercao.setNoProximo(novoNo);
        novoNo.setNoProximo(noPosteriorInsercao);
        tamanho++;
    }

    @Override
    public T removePosicao(int posicao) {
        if(posicao < 0 || posicao >= tamanho){
            System.out.println("No nao removido. Posicao invalida para remocao");
            return null;
        }
        No<T> noAnteriorPosicao = cabeca;
        for(int i = 0;i < posicao - 1; i++) {
            noAnteriorPosicao = noAnteriorPosicao.getNoProximo();
        }
        No<T> noRemovido = noAnteriorPosicao.getNoProximo();
        if(posicao == 0) {
            noRemovido = cabeca;
            cabeca = noRemovido.getNoProximo();
            tamanho--;
        }else{
            noAnteriorPosicao.setNoProximo(noRemovido.getNoProximo());
            noRemovido.setNoProximo(null);
            tamanho--;
        }
        return noRemovido.getValor();
    }

    @Override
    public boolean listaVazia() {
        if(cabeca == null) {
            System.out.println("Lista vazia.");
            return true;
        }
        return false;
    }

    @Override
    public void imprimeLista() {
        if(listaVazia()){
            System.out.println("Nao ha elementos para impressao.");
        }
        No<T> auxiliar = cabeca;
        while(auxiliar!= null){
            System.out.print(" => "+auxiliar.getValor());
            auxiliar = auxiliar.getNoProximo();
        }
        System.out.println();
    }

    public No<T> getCauda(){
        No<T> aux = cabeca;
        if(aux == null) {
            return null;
        }

        while (aux.getNoProximo()!=null){
            aux=aux.getNoProximo();
        }
        return aux;
    }


    public static void main(String[] args) {
        ListaEncadeada<Integer> lista1 = new ListaEncadeada<Integer>();
        lista1.imprimeLista();
        lista1.insereInicio(10);
        lista1.imprimeLista();
        lista1.insereFinal(20);
        lista1.imprimeLista();

        lista1.inserePosicao(12,1);
        lista1.imprimeLista();
        lista1.inserePosicao(14,2);
        lista1.imprimeLista();
        lista1.inserePosicao(18,3);
        lista1.imprimeLista();
        lista1.inserePosicao(16,3);
        lista1.imprimeLista();
        lista1.inserePosicao(8,0);
        lista1.imprimeLista();

        lista1.removePosicao(0);
        lista1.imprimeLista();
        lista1.removePosicao(0);
        lista1.imprimeLista();
        lista1.removePosicao(4);
        lista1.imprimeLista();
        lista1.removePosicao(6);
        lista1.imprimeLista();

        System.out.println(lista1.getTamanho());
    }
}

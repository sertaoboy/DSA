package aula9;

public class ListaDuplamenteEncadeada <T> implements TADListaDuplamenteEncadeada<T>{

    private No<T> header, trailer;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        header = new No(null,null,null);
        trailer = new No(header, null, null);
        header.setPosterior(trailer);
        tamanho = 0;
    }

    @Override
    public void inserirValor(T valor, int posicao) {
        if(posicao < 1 || posicao > tamanho + 1) {
            System.out.println("Posicao invalida: "+posicao);
            return;
        }
        No<T> noAnteriorInsercao = header;
        for(int i = 1; i< posicao; i++) {
            noAnteriorInsercao = noAnteriorInsercao.getPosterior();
        }
        No<T> novoNo = new No<T>(noAnteriorInsercao,null,valor);
        novoNo.setPosterior(noAnteriorInsercao.getPosterior());
        novoNo.getPosterior().setAnterior(novoNo);
        noAnteriorInsercao.setPosterior(novoNo);
        tamanho++;
    }



    @Override
    public T removeValor(int posicao) {
        if(posicao < 1 || posicao > tamanho) {
            System.out.println("Posicao invalida: "+posicao);
            return null;
        }
        No<T> noAnteriorRemocao = header;
        for (int i = 1; i < posicao; i++) {
            noAnteriorRemocao = noAnteriorRemocao.getPosterior();
        }
        No<T> noRemovido = noAnteriorRemocao.getPosterior();
        noAnteriorRemocao.setPosterior(noRemovido.getPosterior());
        noRemovido.getPosterior().setAnterior(noAnteriorRemocao);
        noRemovido.setAnterior(null);
        noRemovido.setPosterior(null);
        tamanho--;
        return noRemovido.getValor();
    }

    @Override
    public boolean listaVazia() {
        if(header.getPosterior().equals(trailer)) {
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        if(listaVazia()){
            System.out.println("Lista vazia.");
            return;
        }
        No<T> aux = header;
        while(aux != null){
            System.out.print(" <=> "+aux.getValor());
            aux = aux.getPosterior();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TADListaDuplamenteEncadeada <String> lista = new ListaDuplamenteEncadeada<String>();
        lista.imprimir();
        lista.inserirValor("a", 0);
        lista.imprimir();
        lista.inserirValor("a",1);
        lista.imprimir();
        lista.inserirValor("d",2);
        lista.imprimir();
        lista.inserirValor("c",2);
        lista.imprimir();
        lista.inserirValor("b",2);
        lista.imprimir();
        lista.inserirValor("e",5);
        lista.imprimir();


        lista.removeValor(1);
        lista.imprimir();
        lista.removeValor(1);
        lista.imprimir();
        lista.removeValor(1);
        lista.imprimir();
        lista.removeValor(1);
        lista.imprimir();
        lista.removeValor(1);
        lista.imprimir();





    }
}

package aula9;

public interface TADListaDuplamenteEncadeada <T>{

    void inserirValor(T valor,int posicao);
    T removeValor(int posicao);
    boolean listaVazia();
    void imprimir();
}

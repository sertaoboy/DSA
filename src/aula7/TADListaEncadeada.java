package aula7;



public interface TADListaEncadeada<T> {

    void insereInicio(T valor);
    void insereFinal(T valor);
    void inserePosicao(T valor, int posicao);
    T removePosicao(int posicao);

    boolean listaVazia();
    void imprimeLista();
}

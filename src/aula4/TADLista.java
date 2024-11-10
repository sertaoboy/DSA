package aula4;

public interface TADLista <T> {
    //metodos principais
    void insereValor(T valor, int indice);
    T removeValor(int indice);


    //metodos secundarios
    boolean listaCheia();
    boolean listaVazia();
    void imprimirLista();
}

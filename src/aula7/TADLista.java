package aula7;

import aula6.No;

public interface TADFila<T> {

    void adicionar(T valor, No posicao);
    void remover(No posicao);
    void imprimir();
    boolean filaVazia();



}

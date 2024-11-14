package aula5;

public interface TADFilaEncadeada<T> {
    //Operacoes principais
    void inserirFinal(T t);
    T removeInicio();

    //Operacoes secundarias
    boolean filaVazia();

    void imprimirFila();
}

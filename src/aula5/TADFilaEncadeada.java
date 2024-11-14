package aula5;

public interface TADFila<T> {
    //Operacoes principais
    void inserirFinal(T t);
    T removeInicio();

    //Operacoes secundarias
    boolean filaVazia();

    void imprimirFila();
}

package aula8;

public interface TADFilaDuplamenteEncadeada<T> {

    void insereFinal(T valor);
    T removeInicio();
    boolean filaVazia();
    void imprimeFila();
}

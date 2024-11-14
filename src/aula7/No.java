package aula7;

public class No<T>{

    private T valor;
    private No<T> noProximo;


    public No(T valor, No noProximo) {
        this.valor = valor;
        this.noProximo = noProximo;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(No noProximo) {
        this.noProximo = noProximo;
    }
}

package aula6;

public class No<T> {

    private T valor;
    private No noProximo;

    public No(T valor, No proximo){
        this.noProximo=proximo;
        this.valor=valor;
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

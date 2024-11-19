package aula9;

public class No <T>{
    private No<T> anterior;
    private No<T> posterior;
    private T valor;

    public No(No<T> anterior, No<T> posterior, T valor) {
        this.anterior = anterior;
        this.posterior = posterior;
        this.valor = valor;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

    public No<T> getPosterior() {
        return posterior;
    }

    public void setPosterior(No<T> posterior) {
        this.posterior = posterior;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}

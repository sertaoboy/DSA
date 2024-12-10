# _Listas Duplamente Encadeadas_
- Como vimos na aula anterior, temos um No `head` e cada um destes Nos contem uma referencia para o No seguinte;
- A partir do No `head`, eu consigo percorrer todos os elementos da minha lista encadeada;
- Por se tratar de uma lista *encadeada*, essa estrutura de dados resolve a questao da **alocacao estatica de memoria**;
- Por outro lado, tem complexidade O(n), entao quando temos listas com muitos elementos ha uma certa **perca de desempenho**;
- Para resolver esse problema foram criadas as *listas duplamente encadeadas*,

### Fila Duplamente Encadeada
- Iremos acrescentar outra referencia ao `No`;
- Mantemos a referencia para o **proximo**, porem acrescentamos uma referencia para o **anterior**;
- Com isso entao esbarramos no conceito de *duplo encadeamento*, onde a fila seja *bidirecional*;
- Isso nos permite navegar entre **os dois sentidos**;
- Na lista encadeada, usaremos o No `header`, onde este seja `null` mas com uma referencia para o *proximo elemento*, no caso o *primeiro No*;
> Diferente da Singly Linked List, onde tinhamos um No `head` que sempre se referia ao primeiro elemento, mas na duplamente encadeada o No `header` nao se referencia exatamente ao valor do no, ele so se referencia ao atributo `proximo`, onde este aponta para o primeiro elemento. <br>
- Da mesma maneira, usaremos um No `trailer` para se referenciar ao ultimo elemento atraves do atributo `anterior`.
- Esses dois nos sao conhecidos como **sentinelas**, eles nao estao propriamente dentro da estrutura de dados, sao so referencias para o primeiro e ultimo elemmento.
```java
public class FilaDuplamenteEncadeada <T> implements TADFilaDuplamenteEncadeada<T> {

    private No<T> header;
    private No<T> trailer;
    private int tamanho;

    public FilaDuplamenteEncadeada() {
        header = new No<T>(null, null, null);
        trailer = new No<T>(null, header, null);
        header.setProximo(trailer);
        this.tamanho = 0;
    }
    
    private void insereInicio(T valor) {
        No<T> novoNo = new No<T> (valor,null,null);
        header.getProximo().setAnterior(novoNo);
        novoNo.setAnterior(header);
    }

    @Override
    public void insereFinal(T valor) {
        No<T> novoNo = new No<T>(valor, null, null);
        trailer.getAnterior().setProximo(novoNo);
        novoNo.setAnterior(trailer.getAnterior());
        novoNo.setProximo(trailer);
        trailer.setAnterior(novoNo);
        tamanho++;
    }

    @Override
    public T removeInicio() {
        No<T> noRemovido = header.getProximo();
        header.setProximo(noRemovido.getProximo());
        noRemovido.getProximo().setAnterior(header);
        noRemovido.setProximo(null);
        noRemovido.setAnterior(null);
        tamanho--;
        return noRemovido.getValor();
    }

    @Override
    public boolean filaVazia() {
        return tamanho == 0;
    }

    @Override
    public void imprimeFila() {
        if (filaVazia()) {
            System.out.println("Fila vazia.");
            return;
        }
        No<T> aux = header;
        while (aux != null) {
            System.out.print(" <=> " + aux.getValor());
            aux = aux.getProximo();
        }
        System.out.println();
    }
}
```
```java
public class No<T>{

    private T valor;
    private No<T> proximo;
    private No<T> anterior;

    public No(T valor, No<T> anterior, No<T> proximo){
        this.valor=valor;
        this.anterior=anterior;
        this.proximo=proximo;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }
}
```
```java
public interface TADFilaDuplamenteEncadeada<T> {

    void insereFinal(T valor);
    T removeInicio();
    boolean filaVazia();
    void imprimeFila();
}
```

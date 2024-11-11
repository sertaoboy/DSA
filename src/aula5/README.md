# Implementacao da Fila Encadeada
- A implementacao da fila encadeada segue um padrao diferente;
- Ainda utilizamos a interface `TADFila` para a implementacao dos metodos exigidos;
- Obs: a interface utiliza tipos genericos;
```java
public interface TADFila<T> {
    //Operacoes principais
    void inserirFinal(T t);
    T removeInicio();

    //Operacoes secundarias
    boolean filaVazia();
    void imprimirFila();
}
```
- Para a implementacao, precisaremos de uma classe `No`;
- Essa classe ira servir para representar os **elementos na fila**;
```java
public class No<T> {

    private T valor;
    private No proximo;

    public No(T valor, No proximo){
        this.valor=valor;
        this.proximo=proximo;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
```
- Importante obsverar a presenca de dois atributos _valor_ e _proximo_, dos tipos **T** (`generics` para atribuir um valor de qualquer tipo) e **No** (uma relacao _auto-referenciada_, na qual a classe `No` contem uma referencia a outro objeto do mesmo tipo);
- O auto-relacionamento na classe permite formar **estruturas encadeadas**;
- Cada `No`aponta para o proximo no, atraves do atributo `proximo`, criando uma cadeia de nos.

### Classe Fila
```java
public class Fila<T> implements TADFila {

    private No<T> cabeca;
    private int tamanho;


    @Override
    public void inserirFinal(Object valor) {
        No<T> novoNo = new No<T>((T) valor, null);
        if (filaVazia()) {
            cabeca = novoNo;
        } else {
            No<T> auxiliar = cabeca;
            while (auxiliar.getProximo() != null) {
                auxiliar = auxiliar.getProximo();
            }
            auxiliar.setProximo(novoNo);
        }
        tamanho++;
    }

    @Override
    public T removeInicio() {
        if (filaVazia()) {
            System.out.println("Fila vazia, nao ha elementos para remocao.");
            return null;
        }
        No<T> noRemovido = cabeca;
        cabeca = cabeca.getProximo();
        noRemovido.setProximo(null);
        tamanho--;
        return noRemovido.getValor();
    }

    @Override
    public boolean filaVazia() {
        if (cabeca == null) {
            return true;
        }
        return false;
    }

    @Override
    public void imprimirFila() {
        if (filaVazia()) {
            System.out.println("Fila vazia, nao ha elementos para imprimir.");
            return;
        } else {
            No<T> auxiliar = cabeca;
            while (auxiliar != null) {
                System.out.print(" => " + auxiliar.getValor());
                auxiliar = auxiliar.getProximo();
            }
            System.out.println();
        }
    }
}
```

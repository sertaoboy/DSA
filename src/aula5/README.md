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
//classe que representa os elementos da minha fila
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
- Importante observar a presenca de dois atributos _valor_ e _proximo_, dos tipos **T** (`generics` para atribuir um valor de qualquer tipo) e **No** (uma relacao _auto-referenciada_, na qual a classe `No` contem uma referencia a outro objeto do mesmo tipo);
- O auto-relacionamento na classe permite formar **estruturas encadeadas**;
- Cada `No`aponta para o proximo No, atraves do atributo `proximo`, criando uma cadeia de nos.

### Classe Fila
```java
public class Fila<T> implements TADFila<T> {

    private No<T> cabeca;
    private int tamanho;


    @Override
    public void inserirFinal(T valor) {
        No<T> novoNo = new No<T>(valor, null);
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
- Vimos ate agora seguindo os exemplos anteriores a **alocacao estatica de memoria**; quando definimos um vetor de _n_ elementos, e quando em execucao, o programa consegue reservar o endereco de memoria para a alocacao desse vetor;
- Ou seja, o vetor tem um tamanho fixo ate o encerramento do programa; um bom exemplo dessa tese e quando temos que inserir um elemento em um determinado indice do vetor nao precisamos alocar memoria para a insercao;
- **Vantagem**: Desempenho; como ja existe uma reserva de memoria na inicializacao do programa nao ha a necessidade de manusearmos a alocacao de memoria, o vetor tera um tamanho pre-determinado ate o encerramento da aplicacao; menos custo computacional.
- **Desvantagem**: Pouca flexibilidade; em um caso onde criarmos um vetor com 1000 indices, pode ser que em algum momento nao aloquemos 1/3 do tamanho desse vetor; nesse caso acontece um *desperdicio de memoria*, porque ha uma regiao reservada em memoria com um deficit de uso;
> Ex.: Em dispositivos criticos em relacao a memoria, como sistemas _embarcados_ (dispositivos IoT, sensores), deve-se ter atencao pois por essa limitacao de memoria o sistema pode se comprometer . <br>
- O contrario tambem e valido, onde ha alguma necessidade de armazenarmos 1001 elementos, por exemplo. Porque ja houve uma reserva no endereco da memoria para 1000 elementos;
- Quando seria ideal?
1. No momento em que soubermos exatamente o tamanho da fila/pilha/lista; e
2. Quando o tamanho permanece **constante** em tempo de execucao.

## Alocacao Dinamica de Memoria
- Conforme a necessidade, **alocamos a regiao de memoria**, **atribui-se o valor** a essa regiao e quando nao houver mais necessidade dessa regiao **temos que desalocar** a mesma;
- **Vantagem**: garante maior flexibilidade da aplicacao, uma vez que podemos ter tamanhos variados conforme a execucao;
- **Desvantagem**: para cada insercao de um elemento ha a necessidade de alocacao de memoria para atribuir o valor.

## Fila de elementos do tipo `No`
- Nossa fila encadeada sera uma fila de elementos do tipo `No`, onde o elemento `No` contem atributos `int valor` e um `No proximo`, que representam respectivamente o valor e a **referencia** para o proximo elemento;
- Insercao:
1. Supondo que vamos inserir um No que tenha o valor 10; apos o No ser adicionado na fila, no `indice 0` teremos o _valor_ 10 e a _referencia_ apontando para `null`, considerando que a fila esteja vazia;
2. Para o proximo elemento da adicao, (considerando que seja um No com valor 12) ao inserirmos, a _referencia_ do No no `indice 0`, que antes apontava para `null`, agora aponta para o elemento que acabamos de inserir: No com valor de 12, e este por consequencia deve apontar para `null`;
- Remocao:
1. Considerando que na fila temos "um No Cabeca"; este No nada mais e que uma referencia para **o inicio da fila**; a partir dele conseguimos acessar o valor e a referencia para o proximo No e assim sucessivamente (terminologia de fila _encadeada_;
2. Sabendo disso, ja temos uma referencia para qual elemento deve sair da fila, o "No Cabeca" (FIFO);
3. Entao quando removemos o elemento, a referencia do "No Cabeca" deve apontar para **a referencia do proximo No** contido nesse elemento; fazendo com que esta referencia "Cabeca" aponte agora para o No de valor 12;
4. O No de valor 10 agora esta deslocado da fila, ja que o "No Cabeca" aponta para o No de valor 12, fazendo com que a referencia do proximo No do No de valor 10 seja `null`;
> No momento em que **nao existe referencias** para o objeto de No de valor 10 e quando a referencia do proximo No desse objeto aponta para `null`, o **Garbage Collector da JVM** identifica esse objeto sem utilizacao e mata da memoria. <br>


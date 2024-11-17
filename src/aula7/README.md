# Lista Encadeada
- Ha algumas particularidades da lista encadeada em relacao aos metodos.
- `TADListaEncadeada`:
```java
public interface TADListaEncadeada<T> {

    void insereInicio(T valor);
    void insereFinal(T valor);
    void inserePosicao(T valor, int posicao);
    T removePosicao(int posicao);

    boolean listaVazia();
    void imprimeLista();
}
```
- Classe `No`:
```java
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
```

- Classe `ListaEncadeada`:
```java
public class ListaEncadeada<T> implements TADListaEncadeada<T> {

    private No<T> cabeca;
    private int tamanho;

    public int getTamanho(){
        return tamanho;
    }


    public ListaEncadeada(){
        this.tamanho = 0;
        this.cabeca = null;
    }


    @Override
    public void insereInicio(T valor) {
        No<T> novoNo = new No<>(valor,null);
        if(cabeca == null) {
            cabeca = novoNo;
        }else{
            novoNo.setNoProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }

    @Override
    public void insereFinal(T valor) {
        No<T> novoNo = new No<>(valor,null);
        if(cabeca == null) {
            cabeca = novoNo;
        }else{
            getCauda().setNoProximo(novoNo);
        }
        tamanho++;
    }

    @Override
    public void inserePosicao(T valor, int posicao) {
        //verificando se a posicao e valida
        if(posicao == 0) {
            insereInicio(valor);
            return;
        }else if(posicao == tamanho){
            insereFinal(valor);
            return;
        }else if(posicao < 0 || posicao > tamanho) {
            System.out.println("Posicao invalida.");
            return;
        }
        //Insercao no meio da lista
        No<T> novoNo = new No<T>(valor,null);
        No<T> noAnteriorInsercao = cabeca;
        for(int i = 0; i< posicao - 1; i++){
            noAnteriorInsercao = noAnteriorInsercao.getNoProximo();
        }
        No<T> noPosteriorInsercao = noAnteriorInsercao.getNoProximo();
        noAnteriorInsercao.setNoProximo(novoNo);
        novoNo.setNoProximo(noPosteriorInsercao);
        tamanho++;
    }

    @Override
    public T removePosicao(int posicao) {
        if(posicao < 0 || posicao >= tamanho){
            System.out.println("No nao removido. Posicao invalida para remocao");
            return null;
        }
        No<T> noAnteriorPosicao = cabeca;
        for(int i = 0;i < posicao - 1; i++) {
            noAnteriorPosicao = noAnteriorPosicao.getNoProximo();
        }
        No<T> noRemovido = noAnteriorPosicao.getNoProximo();
        if(posicao == 0) {
            noRemovido = cabeca;
            cabeca = noRemovido.getNoProximo();
            tamanho--;
        }else{
            noAnteriorPosicao.setNoProximo(noRemovido.getNoProximo());
            noRemovido.setNoProximo(null);
            tamanho--;
        }
        return noRemovido.getValor();
    }

    @Override
    public boolean listaVazia() {
        if(cabeca == null) {
            System.out.println("Lista vazia.");
            return true;
        }
        return false;
    }

    @Override
    public void imprimeLista() {
        if(listaVazia()){
            System.out.println("Nao ha elementos para impressao.");
        }
        No<T> auxiliar = cabeca;
        while(auxiliar!= null){
            System.out.print(" => "+auxiliar.getValor());
            auxiliar = auxiliar.getNoProximo();
        }
        System.out.println();

    }

    public No<T> getCauda(){
        No<T> aux = cabeca;
        if(aux == null) {
            return null;
        }

        while (aux.getNoProximo()!=null){
            aux=aux.getNoProximo();
        }
        return aux;
    }
}
```

## Insercao
### Insercao no inicio:
- Para um determinado `novoNo` que queremos adicionar no indice `0` da lista, devemos realizar as seguintes ideias;
- Caso a lista esteja preenchida (`if cabeca != null`):
1. Apontamos este `novoNo.proximo` como referencia para o `cabeca`;
2. Por fim, atribuimos ao `cabeca` este `novoNo`;
- Caso a lista esteja vazia, simplesmente atribuimos o `cabeca` ao `novoNo`
```java
@Override
    public void insereInicio(T valor) {
        No<T> novoNo = new No<>(valor,null);
        if(cabeca == null) {
            cabeca = novoNo;
        }else{
            novoNo.setNoProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }
```
### Insercao no final:
- Para o `novoNo` ser adicionado ao final da lista vamos considerar o metodo `getCauda` onde este retorne uma referencia para o ultimo `No` da nossa lista:
```java
public No<T> getCauda(){
        No<T> aux = cabeca;
        if(aux == null) {
            return null;
        }

        while (aux.getNoProximo()!=null){
            aux=aux.getNoProximo();
        }
        return aux;
    }
```
- Com isso, podemos referenciar o `proximo` de `getCauda` para este `novoNo`;
- Por default, o `novoNo.proximo` ira apontar para `null`.
```java
@Override
public void insereFinal(T valor) {
    No<T> novoNo = new No<>(valor,null);
    if(cabeca == null) {
        cabeca = novoNo;
    }else{
        getCauda().setNoProximo(novoNo);
    }
    tamanho++;
}
```
### Insercao atraves do indice
- Considerando que desejamos adicionar um `novoNo` a um determinado indice;
- Teremos que ***iterar*** na lista ate o **`No` anterior a esse indice** que chamaremos de `noAnteriorInsercao`;
- `noAnteriorInsercao` representa o `No` cujo indice seja **menor** que o indice no qual estamos querendo inserir;
- Alem disso, podemos criar um `No` de referencia para o `No` em que ja esteja no indice desejado; seria como um "backup";
- Chamaremos ele de `noPosteriorInsercao`;
- Partindo dessa ideia, podemos concluir entao que:
1. `noPosteriorInsercao = noAnteriorInsercao.proximo`
2. `noAnteriorInsercao.proximo = novoNo`;
3. `novoNo.proximo = noPosteriorInsercao`.
```java
@Override
public void inserePosicao(T valor, int posicao) {
    //verificando se a posicao e valida
    if(posicao == 0) {
        insereInicio(valor);
        return;
    }else if(posicao == tamanho){
        insereFinal(valor);
        return;
    }else if(posicao < 0 || posicao > tamanho) {
        System.out.println("Posicao invalida.");
        return;
    }
    //Insercao no meio da lista
    No<T> novoNo = new No<T>(valor,null);
    No<T> noAnteriorInsercao = cabeca;
    for(int i = 0; i< posicao - 1; i++){
        noAnteriorInsercao = noAnteriorInsercao.getNoProximo();
    }
    No<T> noPosteriorInsercao = noAnteriorInsercao.getNoProximo();
    noAnteriorInsercao.setNoProximo(novoNo);
    novoNo.setNoProximo(noPosteriorInsercao);
    tamanho++;
}
```

## Remocao
### Remocao atraves do indice
- Considerando que queremos remover um `No` de indice `1`;
- Criaremos uma variavel de referencia `noRemovido` para apontar ao `No` de indice `1`;
- Como vimos no topico anterior podemos definir uma nova variavel de referencia `noAnteriorRemocao` e atribuir a referencia `proximo` deste para o proximo `No` depois do `noRemovido` (no caso o `No` de indice `2`);
- Conclui-se entao:
1. `noRemovido = noAnteriorRemocao.proximo`;
2. `noAnteriorRemocao.proximo = noRemovido.proximo`;
3. `noRemovido.proximo = null`;
- Com isso, o Garbage Collector identifica que `noRemovido` nao esta sendo mais usado como referencias ou atraves de referencias, e o mata da memoria;
```java
@Override
    public T removePosicao(int posicao) {
        if(posicao < 0 || posicao >= tamanho){
            System.out.println("No nao removido. Posicao invalida para remocao");
            return null;
        }
        No<T> noAnteriorPosicao = cabeca;
        for(int i = 0;i < posicao - 1; i++) {
            noAnteriorPosicao = noAnteriorPosicao.getNoProximo();
        }
        No<T> noRemovido = noAnteriorPosicao.getNoProximo();
        if(posicao == 0) {
            noRemovido = cabeca;
            cabeca = noRemovido.getNoProximo();
            tamanho--;
        }else{
            noAnteriorPosicao.setNoProximo(noRemovido.getNoProximo());
            noRemovido.setNoProximo(null);
            tamanho--;
        }
        return noRemovido.getValor();
    }
```

## Impressao da lista
- Primeiro validamos se a lista contem elementos para prosseguirmos;
- Utilizamos uma **referencia** auxiliar, que aponta para `head`;
- Percorremos os `No`s dentro do laco `while` enquanto a referencia nao for `null`;
- Por fim, imprimimos.
```java
    @Override
    public void imprimeLista() {
        if(listaVazia()){
            System.out.println("Nao ha elementos para impressao.");
        }
        No<T> auxiliar = cabeca;
        while(auxiliar!= null){
            System.out.print(" => "+auxiliar.getValor());
            auxiliar = auxiliar.getNoProximo();
        }
        System.out.println();
    }
```
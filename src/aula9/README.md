# Lista Duplamente Encadeada
- Iremos manter a mesma logica dos 2 **Nos sentinelas**, `header` com valor `null` que **precede o primeiro elemento da lista** e o `trailer` com valor `null` sendo este um `No` **posterior ao ultimo elemento da lista**;
- Mudaremos a implementacao dos metodos de insercao da interface, incluindo como parametro agora a `posicao` e `T valor`;
```java
class No<T> {
    
    private No<T> anterior, posterior;
    private T valor;
    
    public No(No<T> anterior,No<T> posterior, T valor){
        this.anterior=anterior;
        this.posterior=posterior;
        this.valor=valor;
    }
    
    public void setValor(T valor){
        this.valor = valor;
    }
    
    public T getValor(){
        return valor;
    }
    
    public void setAnterior(No<T> anterior) {
        this.anterior=anterior;
    }
    
    public void setPosterior(No<T> posterior) {
        this.posterior=posterior;
    }
    
    public No<T> getAnterior(){
        return anterior;
    }
    
    public No<T> getPosterior(){
        return posterior;
    }
}
```
```java
public interface TADListaDuplamenteEncadeada <T> {
    // Operacoes principais
    void insereValor(T valor, int posicao);
    T removeValor(int posicao);
    
    // Operacoes secundarias
    boolean listaVazia();
    void imprimeLista();
}
```
```java
public class ListaDuplamenteEncadeada<T> implements TADListaDuplamenteEncadeada<T>{
    
    private No<T> header, trailer;
    private int tamanho;
    
    public ListaDuplamenteEncadeada(){
        this.header = new No(null,null,null);
        this.trailer = new No(header,null,null); // Na inicializacao, o No anterior ao No trailer sera o header
        this.header.setPosterior(trailer); // Momento onde definimos o encadeamento entre os Nos header e trailer
        this.tamanho = 0;
    }
    
    @Override
    public void imprimeLista() {
        if(listaVazia()) {
            System.out.println("Lista vazia, sem elementos para imprimir.");
            return;
        }
        No aux = this.header;
        while(aux != null) {
            System.out.println(aux.getValor() + "<=>");
            aux = aux.getPosterior();
        }
        System.out.println();
    }
    
    @Override
    public boolean listaVazia(){
        return this.header.
                getPosterior().
                equals(trailer);
    }
    
    @Override
    public T removeValor(int posicao){
        //Validando
        if(posicao < 1 || posicao > tamanho) { //diferente do metodo de insercao, aqui validamos somente os elementos que realmente estao contidos na lista
            System.out.println("Posicao invalida: "+posicao);
            return null;
        }
        No<T> noAnteriorRemocao = header;
        for(int i =1; i < posicao; i++) {
            noAnteriorRemocao = noAnteriorRemocao.getPosterior();
        }
        No<T> noRemovido = noAnteriorRemocao.getPosterior();
        return noRemovido.getValor();
    }
    
    @Override
    public void insereValor(T valor, int posicao) {
        // Validando, considerando que o tamanho real (elementos na lista) comece a partir de 1; antes da posicao 1 temos o sentinela header (nao faz parte da lista)
        if(posicao < 1 || posicao > tamanho +1) { //tamanho +1 se refere justamente a partir do sentinela trailer, portanto seria invalido
            System.out.println("Poiscao invalida para insercao: "+posicao);
            return;
        }
        
        No<T> noAnteriorInsercao = header;
        for(int i =1; i < posicao; i++) {
            noAnteriorInsercao = noAnteriorInsercao.getPosterior();
        }
        
        No<T> novoNo = new No<T>(noAnteriorInsercao,null,valor);
        novoNo.setPosterior(noAnteriorInsercao.getPosterior());
        novoNo.getPosterior().setAnterior(novoNo);
        noAnteriorInsercao.setPosterior(novoNo);
        tamanho++;
    }
}
```

# Implementação da Lista
- Esta implementação de lista armazena elementos genéricos e suporta operações principais de inserção e remoção. A posição inicial de cada inserção é baseada em um índice especificado pelo usuário. A capacidade é determinada no momento da criação da lista.
### Operacoes principais:
1. Insercao por indice;
2. Remocao por indice.

### Operacoes secundarias:
1. Verificar se a lista esta cheia;
2. Verificar se a lista esta vazia;
3. Imprimir o conteudo da lista.

```java
public interface TADLista<T> {
    // Métodos principais
    void insereValor(T valor, int indice);
    T removeValor(int indice);

    // Métodos secundários
    boolean listaCheia();
    boolean listaVazia();
    void imprimirLista();
}
```
```java
public class Lista<T> implements TADLista<T> {

    private T[] lista;
    private int posicao;

    public Lista(int capacidade) {
        this.lista = (T[]) new Object[capacidade];
        this.posicao = -1;
    }


    @Override
    public void insereValor(T valor, int indice) {
        //validacoes
        if (listaCheia()) {
            System.out.println("Lista cheia, nao e possivel adicionar mais elementos.");
            return;
        } else if (posicao + 1 < indice || indice < 0) {
            System.out.println("Indice inserido fora da capacidade do vetor. Nao foi possivel adicionar na lista.");
            return;
        }
        for (int i = posicao; i >= indice; i--) {
            lista[i + 1] = lista[i];
        }
        lista[indice] = valor;
        posicao++;
    }

    @Override
    public T removeValor(int indice) {
        //validacoes
        if (listaVazia()) {
            System.out.println("Lista ja esta vazia.");
            return null;
        } else if (indice < 0 || indice > posicao) {
            System.out.println("Indice fora da capacidade do vetor.");
            return null;
        }
        var valorRemovido = lista[indice];

        //deslocando todos os elementos posteriores ao indice uma posicao a esquerda
        for (int i = indice; i < posicao; i++) {
            lista[i] = lista[i + 1];
        }
        lista[posicao] = null;
        posicao--;
        return valorRemovido;
    }

    @Override
    public boolean listaCheia() {
        if (posicao == lista.length - 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean listaVazia() {
        if (posicao == -1) {
            return true;
        }
        return false;
    }

    @Override
    public void imprimirLista() {
        if (listaVazia()) {
            System.out.println("Lista vazia. Nada a imprimir.");
            return;
        }
        for (int i = 0; i <= posicao; i++) {
            System.out.print(lista[i] + "\t");
        }
        System.out.println();
    }
}
```
- Observacoes:
> O atributo posicao é utilizado para acompanhar o último índice válido e evitar valores null na impressão. <br> No construtor, posicao é inicializado como -1 e incrementado conforme novos elementos são inseridos. <br> Para definir a capacidade da lista, instanciamos um vetor de Object com o tamanho capacidade passado como parâmetro e o convertendo para o tipo T. <br> A lista permite inserir elementos em posições específicas, deslocando elementos para a direita. Remoções também são possíveis a partir de índices específicos, deslocando os elementos para a esquerda.
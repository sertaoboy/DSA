# Implementacao da pilha
- Operacoes principais:
1. Insercao;
2. Remocao.

- Operacoes secundarias:
1. Verificar se a pilha esta cheia;
2. Verificar se a pilha esta vazia;
3. Imprimir conteudo da fila.

```java
public interface TADPilha {
    //Operacoes principais:
    void adicionarTopo(Integer valor);
    Integer removerTopo();

    //Operacoes secundarias:
    boolean pilhaCheia();
    boolean pilhaVazia();
    void imprimirPilha();
}
```

```java
public class Pilha implements TADPilha {

    private Integer[] pilha;
    private int posicao;

    public Pilha(int capacidade) {
        this.pilha = new Integer[capacidade];
        posicao = -1;
    }

    @Override
    public void adicionarTopo(Integer valor) {
        //validacoes
        if (pilhaCheia()) {
            System.out.println("Pilha esta cheia, nao e possivel adicionar mais elementos.");
            return;
        }
        //deslocamento de todos os elementos uma posicao para a direita
        for (int i = posicao; i >= 0; i--) {
            pilha[i + 1] = pilha[i];
        }
        pilha[0] = valor;
        posicao++;
    }

    @Override
    public Integer removerTopo() {
        //validacoes
        if (pilhaVazia()) {
            System.out.println("Pilha vazia, nenhum elemento a ser removido.");
            return null;
        }
        var elementoTopoRemovido = pilha[0];
        for (int i = 0; i < this.posicao; i++) {
            pilha[i] = pilha[i + 1];
        }
        pilha[posicao--] = null;
        System.out.println("Elemento removido: " + elementoTopoRemovido);
        return elementoTopoRemovido;
    }

    @Override
    public boolean pilhaCheia() {
        if (posicao == pilha.length - 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean pilhaVazia() {
        if (posicao == -1) {
            return true;
        }
        return false;
    }

    @Override
    public void imprimirPilha() {
        //validacoes:
        if (pilhaVazia()) {
            System.out.println("Pilha vazia, nenhum elemento a imprimir.");
        }
        for (int i = 0; i <= posicao; i++) {
            System.out.print(pilha[i] + "\t");
        }
        System.out.println();
    }
}
```

- Observacoes:
> O atributo `posicao` serve de variavel auxiliar, **apenas uma referencia do ultimo indice valido** para nao incluir os valors `null`; <br>
> Nota-se no construtor que a `posicao` incializa com o valor de -1, para assim incrementar a medida que adicionamos novos elementos; <br>
> Assim como na classe Fila vista anteriormente, aqui instanciamos um vetor de `Integer` no construtor e atribuimos o parametro `capacidade` ao seu tamanho; <br>
> Consideracoes importantes: quando se implementa uma pilha em um vetor, temos a opcao de considerar o topo como sendo o primeiro indice do vetor ou o ultimo. Mas qual a diferenca? Se considerarmos o topo como sendo o **primeiro indice** do vetor, o **deslocamento na adicao dos elementos sera para a direita** e na **remocao o deslocamento sera para a esquerda**. <br>
> 

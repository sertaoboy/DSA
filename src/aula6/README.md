# Pilha Encadeada
- Basicamente seguiremos a logica de encadeamento anterior demonstrada atraves da **fila encadeada**;
- Teremos a classe `No` onde teremos os atributos `valor` e `proximo`, sendo este a referencia para o proximo No da Pilha;
- Lembre-se: _Last in, first out_;
- Classe:
```java
public class PilhaEncadeada<T> implements TADPilhaEncadeada<T> {

    private int tamanho;
    private No<T> cabeca;

    public PilhaEncadeada() {
        cabeca = null;
        this.tamanho = 0;
    }

    @Override
    public void inserir(T t) {
        No novoNo = new No(t, null);
        if (pilhaVazia()) {
            this.cabeca = novoNo;
        } else {
            novoNo.setNoProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }

    @Override
    public void remover() {
        if (pilhaVazia()) {
            System.out.println("Pilha vazia, nada a remover.");
            return;
        } else {
            No noRemovido = cabeca;
            cabeca = cabeca.getNoProximo();
            noRemovido.setNoProximo(null);
            this.tamanho--;
        }
    }

    @Override
    public void imprimir() {
        if (pilhaVazia()) {
            System.out.println("Pilha vazia, nenhum elemento para impressao");
            return;
        } else {
            No auxiliar = cabeca;
            while (auxiliar != null) {
                System.out.print(" => " + auxiliar.getValor());
                auxiliar = auxiliar.getNoProximo();
            }
            System.out.println();
        }

    }

    @Override
    public boolean pilhaVazia() {
        if (cabeca == null) {
            return true;
        }
        return false;
    }
}
```

- Metodo de insercao: fazemos a validacao se a pilha esta vazia, atraves do atributo `cabeca` sendo `null` ou `tamanho` igual a 0;
- Se a pilha estiver vazia, faremos com que o atributo `cabeca` aponte para o `novoNo` que criamos no metodo;
- Por consequencia, este `novoNo` tera um atributo de referencia `proximo` apontando para `null`, ja que a pilha estava vazia
- Caso a pilha nao esteja vazia, o `novoNo` a ser inserido passara a ter como referencia do atributo `proximo` o `No cabeca`;
- Por fim, passamos o atributo `cabeca` justamente para esse `novoNo`;
- E finalmente decrementamos o `tamanho`.
```java
@Override
    public void inserir(T t) {
        No novoNo = new No(t,null);
        if(pilhaVazia()) {
            this.cabeca = novoNo;
        }else{
            novoNo.setNoProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }
```

- Metodo de remocao: primeiro validamos se a pilha esta vazia para prosseguir com a remocao;
- Seguindo os principios de LIFO, criaremos uma variavel de referencia `noRemovido`, onde essa aponta para o atributo `cabeca`;
- Apos a definicao dessa referencia, podemos dizer que o `No cabeca` agora recebe a referencia para o `proximo`;
- E para a remocao definitiva, apontamos o `noProximo` dessa referencia `noRemovido` para `null`;
```java
@Override
    public void remover() {
        if (pilhaVazia()) {
            System.out.println("Pilha vazia, nada a remover.");
            return;
        } else {
            No noRemovido = cabeca;
            cabeca = cabeca.getNoProximo();
            noRemovido.setNoProximo(null);
            this.tamanho--;
        }
    }
```
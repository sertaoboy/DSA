# Implementacao da fila
- Operacoes principais:
1. Insercao;
2. Remocao.

- Operacoes secundarias:
1. Verificacao se a fila esta cheia;
2. Verificacao se a fila esta vazia;
3. Impressao da fila.

```java
public interface TADFila {
    //Operacoes principais
    public void insereFinal(Integer valor) throws Exception;
    public Integer removeInicio();

    //Operacoes secundarias
    public boolean filaCheia();
    public boolean filaVazia();
    public void imprimeFila();

}
```

```java
public class Fila implements TADFila {

    private Integer[] fila;
    private int posicao;
    private static final int TAMANHO = 10;

    public Fila() {
        this.fila = new Integer[TAMANHO];
        this.posicao = -1;
    }

    public Fila(int tamanho) {
        this.fila = new Integer[tamanho];
        this.posicao = -1;
    }


    @Override
    public void insereFinal(Integer valor) throws Exception {
        //Validacoes
        if (filaCheia()) {
            System.out.println("Fila cheia. Elemento nao inserido.");
            throw new ArrayIndexOutOfBoundsException("Fila cheia");
        }
        fila[++posicao] = valor;
    }

    @Override
    public Integer removeInicio() {
        //validacoes
        if (filaVazia()) {
            System.out.println("Fila vazia. Nada a remover.");
            return null;
        }
        int elementoRemovido = fila[0];
        for (int i = 0; i < posicao; i++) {
            fila[i] = fila[i + 1];
        }
        fila[posicao] = null;
        posicao = posicao - 1;
        return elementoRemovido;
    }

    @Override
    public boolean filaCheia() {
        if (posicao == fila.length - 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean filaVazia() {
        return posicao == -1 ? true : false;
    }

    @Override
    public void imprimeFila() {
        //validacoes
        if (filaVazia()) {
            System.out.println("Fila vazia. Nada a imprimir.");
        }
        for (int i = 0; i <= posicao; i++) {
            System.out.print(fila[i].toString() + "\t");
        }
        System.out.println();
    }
}
```
- Palavras-chave:
> **alocacao estatica de memoria**: em tempo de execucao, o sistema aloca um tamanho fixo para todas as posicoes do vetor; <br>
> **desperdicio de memoria**: quando se aloca uma fila com determinado tamanho na memoria mas nao se utiliza todos os espacos alocados; <br>

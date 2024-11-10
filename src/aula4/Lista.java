package aula4;

public class Lista<T> implements TADLista<T>{

    private T[] lista;
    private int posicao;

    public Lista(int capacidade) {
        this.lista = (T[]) new Object[capacidade];
        this.posicao = -1;
    }


    @Override
    public void insereValor(T valor, int indice) {
        //validacoes
        if(listaCheia()) {
            System.out.println("Lista cheia, nao e possivel adicionar mais elementos.");
            return;
        }else if(posicao + 1 < indice || indice < 0) {
            System.out.println("Indice inserido fora da capacidade do vetor. Nao foi possivel adicionar na lista.");
            return;
        }
        for(int i = posicao; i >= indice;i--){
                lista[i+1] = lista[i];
        }
        lista[indice] = valor;
        posicao ++;
    }

    @Override
    public T removeValor(int indice) {
        //validacoes
        if(listaVazia()) {
            System.out.println("Lista ja esta vazia.");
            return null;
        }else if(indice < 0 || indice > posicao) {
            System.out.println("Indice fora da capacidade do vetor.");
            return null;
        }
        var valorRemovido = lista[indice];

        //deslocando todos os elementos posteriores ao indice uma posicao a esquerda
        for(int i = indice; i < posicao; i++) {
            lista[i] = lista[i+1];
        }
        lista[posicao] = null;
        posicao--;
        return valorRemovido;
    }

    @Override
    public boolean listaCheia() {
        if(posicao== lista.length-1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean listaVazia() {
       if(posicao == -1) {
           return true;
       }
       return false;
    }

    @Override
    public void imprimirLista() {
        if(listaVazia()){
            System.out.println("Lista vazia. Nada a imprimir.");
            return;
        }
        for(int i =0;i<=posicao;i++){
            System.out.print(lista[i] + "\t");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TADLista<String> lista = new Lista<String>(5);
        lista.insereValor("A", -1);
        lista.insereValor("A",3);
        lista.removeValor(0);
        lista.imprimirLista();

        lista.insereValor("B",0);
        lista.imprimirLista();
        lista.insereValor("A",0);
        lista.imprimirLista();
        lista.insereValor("D",2);
        lista.imprimirLista();
        lista.insereValor("C",2);
        lista.imprimirLista();
        lista.insereValor("E",4);
        lista.imprimirLista();
        System.out.println(lista.listaCheia());
        lista.insereValor("F",4);

    }
}

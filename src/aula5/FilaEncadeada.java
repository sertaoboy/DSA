package aula5;

public class FilaEncadeada<T> implements TADFilaEncadeada<T> {

    private No<T> cabeca;
    private int tamanho;


    @Override
    public void inserirFinal(T valor) {
        No<T> novoNo = new No<T>(valor,null);
        if(filaVazia()){
            cabeca = novoNo;
        }else{
            No<T> auxiliar = cabeca;
           while(auxiliar.getProximo()!=null){
               auxiliar = auxiliar.getProximo();
           }
           auxiliar.setProximo(novoNo);
        }
        tamanho++;
    }

    @Override
    public T removeInicio() {
        if(filaVazia()) {
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
        if(cabeca == null) {
            return true;
        }
        return false;
    }

    @Override
    public void imprimirFila(){
        if(filaVazia()){
            System.out.println("Fila vazia, nao ha elementos para imprimir.");
            return;
        }else{
            No<T> auxiliar = cabeca;
            while(auxiliar!=null) {
                System.out.print(" => "+auxiliar.getValor());
                auxiliar = auxiliar.getProximo();
            }
            System.out.println();
        }
    }







    public static void main(String[] args) {
        TADFilaEncadeada<Integer> fila = new FilaEncadeada<Integer>();
        fila.imprimirFila();
        fila.inserirFinal(10);
        fila.imprimirFila();
        fila.inserirFinal(12);
        fila.imprimirFila();
        fila.inserirFinal(13);
        fila.imprimirFila();

        fila.removeInicio();
        fila.imprimirFila();
        fila.removeInicio();
        fila.imprimirFila();
        fila.removeInicio();
        fila.imprimirFila();
    }
}

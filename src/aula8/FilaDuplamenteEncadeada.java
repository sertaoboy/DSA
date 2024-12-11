package aula8;

public class FilaDuplamenteEncadeada <T> implements TADFilaDuplamenteEncadeada<T> {

    private No<T> header;
    private No<T> trailer;
    private int tamanho;

    public FilaDuplamenteEncadeada(){
        header = new No<T>(null, null,null);
        trailer = new No<T>(null, header,null);
        header.setProximo(trailer);
        this.tamanho=0;
    }

    @Override
    public void insereFinal(T valor) {
        No<T> novoNo = new No<T> (valor,null,null);
        trailer.getAnterior().setProximo(novoNo);
        novoNo.setAnterior(trailer.getAnterior());
        novoNo.setProximo(trailer);
        trailer.setAnterior(novoNo);
        tamanho++;
    }

    @Override
    public T removeInicio() {
        No<T> noRemovido = header.getProximo();
        header.setProximo(noRemovido.getProximo());
        noRemovido.getProximo().setAnterior(header);
        noRemovido.setProximo(null);
        noRemovido.setAnterior(null);
        tamanho--;
        return noRemovido.getValor();
    }

    @Override
    public boolean filaVazia() {
        if(tamanho == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void imprimeFila() {
        if(filaVazia()){
            System.out.println("Fila vazia.");
            return;
        }
        No<T> aux = header;
        while(aux != null){
            System.out.print(" <=> "+aux.getValor());
            aux = aux.getProximo();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TADFilaDuplamenteEncadeada<String> filaDuplamenteEncadeada = new FilaDuplamenteEncadeada<>();
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.insereFinal("Elemento 1");
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.insereFinal("Elemento 2");
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.insereFinal("Elemento 3");
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.insereFinal("Elemento 4");
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.removeInicio();
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.removeInicio();
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.removeInicio();
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.removeInicio();
        filaDuplamenteEncadeada.imprimeFila();
        filaDuplamenteEncadeada.imprimeFila();
    }
}

package aula2;

import java.util.Arrays;

public class Fila implements TADFila{

    private Integer [] fila;
    private int posicao;
    private static final int TAMANHO = 10;

    public Fila(){
        this.fila=new Integer[TAMANHO];
        this.posicao = -1;
    }
    public Fila(int tamanho){
        this.fila=new Integer[tamanho];
        this.posicao = -1;
    }



    @Override
    public void insereFinal(Integer valor) throws Exception {
        //Validacoes
        if(filaCheia()) {
            System.out.println("Fila cheia. Elemento nao inserido.");
            throw new ArrayIndexOutOfBoundsException("Fila cheia");
        }
        fila[++posicao] = valor;
    }

    @Override
    public Integer removeInicio() {
        //validacoes
        if(filaVazia()){
            System.out.println("Fila vazia. Nada a remover.");
            return null;
        }
        int elementoRemovido = fila[0];
        for(int i =0; i< posicao; i++) {
            fila[i] = fila[i+1];
        }
        fila[posicao] = null;
        posicao = posicao -1;
        return elementoRemovido;
    }

    @Override
    public boolean filaCheia() {
        if(posicao == fila.length -1){
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
        if(filaVazia()) {
            System.out.println("Fila vazia. Nada a imprimir.");
        }
        for(int i=0;i<=posicao;i++) {
            System.out.print(fila[i].toString() + "\t");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Fila fila1 = new Fila();

        fila1.removeInicio();
        fila1.imprimeFila();
        try{
            fila1.insereFinal(1);
            fila1.insereFinal(2);
            fila1.insereFinal(3);
            fila1.insereFinal(4);
            fila1.insereFinal(5);
            fila1.insereFinal(6);
            fila1.insereFinal(7);
            fila1.insereFinal(8);

            fila1.imprimeFila();

            fila1.removeInicio();
            fila1.imprimeFila();
            fila1.removeInicio();
            fila1.imprimeFila();
            fila1.removeInicio();
            fila1.imprimeFila();
            fila1.removeInicio();
            fila1.imprimeFila();
            fila1.removeInicio();
            fila1.imprimeFila();
            fila1.removeInicio();
            fila1.imprimeFila();
            fila1.removeInicio();
            fila1.imprimeFila();
            fila1.removeInicio();
            fila1.imprimeFila();

            fila1.insereFinal(45);
            fila1.imprimeFila();
            fila1.insereFinal(70);
            fila1.imprimeFila();
            fila1.insereFinal(40);
            fila1.imprimeFila();
            fila1.insereFinal(55);
            fila1.imprimeFila();
            fila1.insereFinal(142);
            fila1.imprimeFila();
            fila1.insereFinal(111);
            fila1.imprimeFila();
            fila1.insereFinal(222);
            fila1.imprimeFila();
            fila1.insereFinal(888);
            fila1.imprimeFila();
            fila1.insereFinal(777);
            fila1.imprimeFila();
            fila1.insereFinal(600);
            fila1.imprimeFila();
            fila1.insereFinal(400);
        }catch (Exception e){
            e.getMessage();
        }

    }
}

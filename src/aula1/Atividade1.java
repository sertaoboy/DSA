package aula1;

import java.util.Arrays;

public class Atividade1 {

    private int [] inteiros;
    private int tamanho;




    public Atividade1(int capacidade){
        this.inteiros = new int[capacidade];
        this.tamanho = 0;
    }




    void  adicionaInicio(int valor){
        inteiros[0] = valor;
        tamanho ++;
    }

    void adicionaFim(int valor) {
        inteiros[inteiros.length-1] = valor;
        tamanho = inteiros.length+1;
    }

    void adicionaMeio(int valor, int posicao) {
        inteiros[posicao] = valor;
    }

    void removeInicio(){
        inteiros[0] = 0;
    }

    void removeFim(){
        inteiros[inteiros.length-1] = 0;
    }

    void removePosicao(int posicao){
        inteiros[posicao]=0;
    }


    public int getTamanho() {
        return tamanho;
    }

    public static void main(String[] args) {
        var atividade1 = new Atividade1(10);
        System.out.println("ADICIONANDO VALOR AO INICIO:");
        atividade1.adicionaInicio(555);
        System.out.println(atividade1.getTamanho());

        System.out.println("ADICIONANDO VALOR AO FIM:");
        atividade1.adicionaFim(222);
        System.out.println(atividade1.getTamanho());
        for(int inteiro : atividade1.inteiros) {
            System.out.println(inteiro);
        }

        System.out.println("ADICIONANDO VALOR AO FIM:");
        atividade1.adicionaFim(232423);
        for(int inteiro : atividade1.inteiros) {
            System.out.println(inteiro);
        }

        System.out.println("REMOVENDO INDICE FINAL:");
        atividade1.removeFim();
        Arrays.stream(atividade1.inteiros).forEach(System.out::println);

        System.out.println("ADICIONANDO NO MEIO:");
        atividade1.adicionaMeio(5,5);
        for(int inteiro: atividade1.inteiros) {
            System.out.println(inteiro);
        }



    }
}

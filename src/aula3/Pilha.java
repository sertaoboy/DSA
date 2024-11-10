package aula3;
// Considera-se o topo o indice 0 do vetor.
public class Pilha implements TADPilha{

    private Integer[] pilha;
    private int posicao;

    public Pilha(int capacidade){
        this.pilha = new Integer[capacidade];
        posicao = -1;
    }

    @Override
    public void adicionarTopo(Integer valor) {
        //validacoes
        if(pilhaCheia()) {
            System.out.println("Pilha esta cheia, nao e possivel adicionar mais elementos.");
            return;
        }
        //deslocamento de todos os elementos uma posicao para a direita
        for(int i = posicao; i >= 0;i--){
            pilha[i+1] = pilha[i];
        }
        pilha[0] = valor;
        posicao++;
    }

    @Override
    public Integer removerTopo() {
        //validacoes
        if(pilhaVazia()) {
            System.out.println("Pilha vazia, nenhum elemento a ser removido.");
            return null;
        }
        var elementoTopoRemovido = pilha[0];
        for(int i = 0; i<this.posicao;i++){
            pilha[i] = pilha[i+1];
        }
        pilha[posicao--] = null;
        System.out.println("Elemento removido: "+elementoTopoRemovido);
        return elementoTopoRemovido;
    }

    @Override
    public boolean pilhaCheia() {
        if(posicao == pilha.length -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean pilhaVazia() {
        if(posicao == -1) {
            return true;
        }
        return false;
    }

    @Override
    public void imprimirPilha() {
        //validacoes:
        if(pilhaVazia()) {
            System.out.println("Pilha vazia, nenhum elemento a imprimir.");
        }
        for(int i = 0; i <= posicao; i++){
            System.out.print(pilha[i] + "\t");
        }
        System.out.println();
    }






    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);
        pilha.removerTopo();
        pilha.imprimirPilha();

        pilha.adicionarTopo(90);
        pilha.imprimirPilha();
        pilha.adicionarTopo(50);
        pilha.imprimirPilha();
        pilha.adicionarTopo(85);
        pilha.imprimirPilha();
        pilha.adicionarTopo(10);
        pilha.imprimirPilha();
        pilha.adicionarTopo(25);
        pilha.imprimirPilha();
        pilha.adicionarTopo(44);
        pilha.imprimirPilha();

        pilha.removerTopo();
        pilha.imprimirPilha();
        pilha.removerTopo();
        pilha.imprimirPilha();
        pilha.removerTopo();
        pilha.imprimirPilha();
        pilha.removerTopo();
        pilha.imprimirPilha();
        pilha.removerTopo();
        pilha.imprimirPilha();
        pilha.removerTopo();
        pilha.imprimirPilha();






    }
}

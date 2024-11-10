package aula3;

public interface TADPilha {
    //Operacoes principais:
    void adicionarTopo(Integer valor);
    Integer removerTopo();

    //Operacoes secundarias:
    boolean pilhaCheia();
    boolean pilhaVazia();
    void imprimirPilha();
}

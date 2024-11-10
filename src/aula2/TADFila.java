package aula2;

public interface TADFila {
    //Operacoes principais
    public void insereFinal(Integer valor) throws Exception;
    public Integer removeInicio();

    //Operacoes secundarias
    public boolean filaCheia();
    public boolean filaVazia();
    public void imprimeFila();

}

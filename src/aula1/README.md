# Estrutura de dados - IFCE
## Programa da Disciplina
- Tipos de dados, estrutura de dados e tipos abstratos de dados
- Listas ligadas e lista duplamente ligadas
- Pilhas
- Filas
- Arvores (Binarias)
- Dicionarios e Tabelas Hash
- Heaps e Fila de Prioridade
- Arvore de Busca
- Arvore AVL e Rubro-Negras
- Arvores B

### O que sao Estrutura de dados?
- Forma de **armazenamento e organizacao** de dados em um computador, de modo que possam ser usados de **modo eficiente**.
- Vantagens:
1. Organizacao da informacao
2. Melhora o desempenho
3. Proporciona o reuso de codigo
4. Proporciona a interoperabilidade
5. Diminuis custos computacionais

### TAD - Tipo Abstrato de Dados
- Especifica tudo que se precisa saber para usar um determinado tipo de dado.
- **Nao faz referencia** a maneira com a qual o tipo de dado e **implementado**.
- Divide os programas em:
1. Programas usuarios: parte que usa o TAD.
2. Implementacoes: parte que implementa o TAD.
> "[...] Programe voltado a _interfaces_." <br>

## Estruturas de Dados Basica
### Fila
- Mantem objetos em sequencia;
- Primeiro a entrar, primeiro a sair (FIFO - First in, first out);
- Insercao no final, remocao no inicio;
- Onde e utilizado na computacao? Impressoras empresariais de uma rede;

### Pilha
- Mantem objetos em sequencia;
- Ultimo a entrar, primeiro a sair (LIFO - Last in, first out);
- Insercao no topo, remocao no topo;
- Exemplos: ordem de execucao das instrucoes de um programa, empilhadas a cada metodo(_Pilha de execucao_); historico de navegacao nos browsers.

### Lista
- Mantem objetos em sequencia;
- Pode manipular elementos em qualquer posicao; insercao e remocao livre.


### Lista com Arranjo (Vetor)
- Suponha que deseja armazenar o ranking das 10 maiores pontuacoes para um determinado jogo.
- O ranking deve conter o nome e pontuacao;
```java
class PontuacaoJogador{
    String nome;
    int pontuacao;
}
```
```java
class Ranking {
    PontuacaoJogador [] ranking;
    
    Ranking(int capacidade){
        this.ranking = new PontuacaoJogador[capacidade];
    } 
    
    void adicionar(PontuacaoJogador jogador){
        for(int i =0;i<ranking.length;i++) {
            if(ranking[i]==null) {
                ranking[i] = jogador;
            }
            if(i == ranking.length-1) {
                System.out.println("Ranking cheio.");
            }
        }
    }
    
    void ordenar(){
        for(int i = 0; i<ranking.length;i++){
            for(int j = i + 1; j < ranking.length; j++) {
                if(ranking[j] != null && ranking[i].pontuacao < ranking[j].pontuacao){
                    PontuacaoJogador aux = ranking[i];
                    ranking[i] = ranking[j];
                    ranking[j] = aux;
                }
            }
        }
    }
}
```

